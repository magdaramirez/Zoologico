/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.GUI;

import com.github.lgooddatepicker.components.TimePicker;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Habitat;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Zona;
import org.itson.fachadaAdministrarItinerario.FachadaAdministrarItinerario;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.HabitatsDAO;
import org.itson.persistencia.ItinerariosDAO;
import org.itson.utils.ModoVentana;
import org.itson.utils.Validadores;

/**
 * Clase que contiene la lógica de la ventana de registrar itinerarios.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class LogicaRegistrarItinerarios {

    private JFrame frame;
    private final Itinerario itinerario;
    private final FrmRegistrarItinerario registro;

    private final IHabitatsDAO persistenciaHabitats;
    private final ConexionMongoDB conexion = new ConexionMongoDB();

    /**
     * Constructor de la clase LogicaRegistrarItinerarios.
     *
     * @param frame el JFrame asociado a la ventana.
     * @param itinerario el itinerario a gestionar.
     * @param registro la ventana de registro de itinerarios.
     */
    public LogicaRegistrarItinerarios(JFrame frame, Itinerario itinerario, FrmRegistrarItinerario registro) {
        persistenciaHabitats = new HabitatsDAO(conexion);
        this.itinerario = itinerario;
        this.frame = frame;
        this.registro = registro;
    }

    /**
     * Genera una lista de horas con un intervalo específico entre ellas.
     *
     * @param inicio la hora de inicio.
     * @param fin la hora de fin.
     * @param hours las horas de intervalo.
     * @param minutes los minutos de intervalo.
     * @return una lista de LocalTime con las horas generadas.
     */
    public static List<LocalTime> generarHorasConIntervalo(LocalTime inicio, LocalTime fin, int hours, int minutes) {
        List<LocalTime> horas = new ArrayList<>();
        LocalTime tiempo = inicio;

        while (tiempo.isBefore(fin)) {
            horas.add(tiempo);
            tiempo = tiempo.plusHours(hours).plusMinutes(minutes);
        }

        return horas;
    }

    /**
     * Configura la tabla de itinerarios y el JComboBox de hábitats.
     *
     * @param table la tabla de itinerarios.
     * @param cbx el JComboBox de hábitats.
     */
    public void configurarTabla(JTable table, JComboBox cbx) {
        this.llenarTablaHabitats(cbx);
        table.getTableHeader().setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setForeground(new Color(102, 0, 0));
        table.setRowHeight(40);
    }

    /**
     * Carga los datos del itinerario en los campos correspondientes del
     * formulario.
     *
     * @param nombre el campo de texto para el nombre del itinerario.
     * @param noVisitantes el campo de texto para el número de visitantes del
     * itinerario.
     * @param table la tabla de hábitats del itinerario.
     */
    public void cargarItinerario(JTextField nombre, JTextField noVisitantes, JTable table) {
        nombre.setText(itinerario.getNombre());
        noVisitantes.setText(itinerario.getNoVisitantes().toString());
        this.insertarHabitatsEnTablaActualizar(itinerario, table);

        // Inicializar los contadores de días iguales
        int maxCantidad = 0;
        HashMap<String, Integer> diasIguales = new HashMap<>();
        List<Horario> listaHorarios = itinerario.getListaHorarios();
        for (Horario horario : listaHorarios) {
            String dia = horario.getDia();
            int contador = diasIguales.getOrDefault(dia, 0) + 1;
            diasIguales.put(dia, contador);
            maxCantidad = Math.max(maxCantidad, contador);
        }

        // Asignar las horas a los TimePicker correspondientes
        for (String dia : diasIguales.keySet()) {
            int contador = diasIguales.get(dia);
            List<Horario> horariosDia = listaHorarios.stream().filter(h -> h.getDia().equals(dia)).collect(Collectors.toList());
            for (int i = 1; i <= contador; i++) {
                TimePicker timePicker = registro.getTimePicker(dia, i);
                if (timePicker != null && i <= horariosDia.size()) {
                    Horario horario = horariosDia.get(i - 1);
                    Date horaInicio = horario.getHoraInicio();
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(horaInicio.toInstant(), ZoneOffset.UTC);
                    LocalTime horaInicioLocal = localDateTime.toLocalTime();
                    timePicker.setTime(horaInicioLocal);
                }
            }
        }

        // Asignar los días iguales a las variables correspondientes
        registro.setCantLunes(diasIguales.getOrDefault("Lunes", 0));
        registro.setCantMartes(diasIguales.getOrDefault("Martes", 0));
        registro.setCantMiercoles(diasIguales.getOrDefault("Miércoles", 0));
        registro.setCantJueves(diasIguales.getOrDefault("Jueves", 0));
        registro.setCantViernes(diasIguales.getOrDefault("Viernes", 0));
        registro.setCantSabado(diasIguales.getOrDefault("Sábado", 0));
        registro.setCantDomingo(diasIguales.getOrDefault("Domingo", 0));
    }

    /**
     * Configura los componentes TimePicker dentro de un panel.
     *
     * @param panel el panel que contiene los componentes TimePicker.
     */
    public void configurarTimePicker(JPanel panel) {
        LocalTime inicio = LocalTime.of(9, 0);
        LocalTime fin = LocalTime.of(21, 0);
        int hours = 1;
        int minutes = 30;

        List<LocalTime> horas = generarHorasConIntervalo(inicio, fin, hours, minutes);
        for (Component componente : panel.getComponents()) {
            if (componente instanceof TimePicker) {
                TimePicker datePicker = (TimePicker) componente;
                if (registro.getModo() == ModoVentana.PREVISUALIZAR) {
                    datePicker.setEnabled(false);
                } else {
                    datePicker.getComponentTimeTextField().setEditable(false);
                    datePicker.getSettings().generatePotentialMenuTimes((ArrayList<LocalTime>) horas);
                }
            }
        }
    }

    /**
     * Método para visualizar los time pickers para ingresar las horas.
     */
    public void visualizarTimePicker() {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        for (String dia : dias) {
            int cantidad = obtenerCantidad(dia);
            for (int i = 1; i <= 4; i++) {
                TimePicker timePicker = registro.getTimePicker(dia, i);
                timePicker.setVisible(i <= cantidad);
            }
        }
    }

    /**
     * Obtiene la cantidad de días iguales para un día específico.
     *
     * @param dia el día para el cual se desea obtener la cantidad de días
     * iguales.
     * @return la cantidad de días iguales para el día especificado.
     */
    private int obtenerCantidad(String dia) {
        switch (dia) {
            case "Lunes":
                return registro.getCantLunes();
            case "Martes":
                return registro.getCantMartes();
            case "Miércoles":
                return registro.getCantMiercoles();
            case "Jueves":
                return registro.getCantJueves();
            case "Viernes":
                return registro.getCantViernes();
            case "Sábado":
                return registro.getCantSabado();
            case "Domingo":
                return registro.getCantDomingo();
            default:
                return 0;
        }
    }

    /**
     * Extrae los datos de los campos de texto proporcionados y los devuelve
     * como un HashMap.
     *
     * @param txtNombre el campo de texto para el nombre.
     * @param txtNoVisitantes el campo de texto para el número de visitantes.
     * @return un HashMap que contiene los datos extraídos, donde la clave es el
     * nombre del campo y el valor es el texto ingresado.
     */
    public HashMap<String, String> extraerDatos(JTextField txtNombre, JTextField txtNoVisitantes) {
        String nombre = txtNombre.getText();
        String noVisitantes = txtNoVisitantes.getText();

        HashMap<String, String> datos = new HashMap<>();
        datos.put("nombre", nombre);
        datos.put("noVisitantes", noVisitantes);

        return datos;
    }

    /**
     * Valida los datos proporcionados y devuelve una lista de errores de
     * validación.
     *
     * @param datos el HashMap que contiene los datos a validar.
     * @param table la tabla que se debe validar.
     * @return una lista de errores de validación. La lista estará vacía si no
     * hay errores.
     */
    public List<String> validarDatos(HashMap<String, String> datos, JTable table) {
        List<String> erroresValidacion = new LinkedList<>();
        String nombre = datos.get("nombre");
        String noVisitantes = datos.get("noVisitantes");

        if (Validadores.esTextoVacio(nombre) || Validadores.esTablaVacia(table)) {
            erroresValidacion.add("Tienes campos vacíos");
        }
        if (!Validadores.esEntero(noVisitantes)) {
            erroresValidacion.add("El número de visitantes NO es número entero");
        }

        return erroresValidacion;
    }

    /**
     * Registra un nuevo itinerario utilizando los datos proporcionados.
     *
     * @param txtNombre el campo de texto para el nombre del itinerario.
     * @param txtNoVisitantes el campo de texto para el número de visitantes del
     * itinerario.
     * @param table la tabla de hábitats del itinerario.
     */
    public void registrarItinerario(JTextField txtNombre, JTextField txtNoVisitantes, JTable table) {
        HashMap<String, String> datos = extraerDatos(txtNombre, txtNoVisitantes);
        List<String> errores = validarDatos(datos, table);

        if (!errores.isEmpty()) {
            registro.mostrarErroresValidacion(errores);
        } else {
            List<Horario> listaHorarios = new LinkedList<>();
            LocalDate currentDate = LocalDate.now();
            Zona zonaAux = new Zona();

            String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

            for (String dia : dias) {
                for (int i = 1; i <= 4; i++) {
                    TimePicker timePicker = registro.getTimePicker(dia, i);
                    if (!timePicker.getText().isEmpty()) {
                        LocalDateTime localDateTime = timePicker.getTime().atDate(currentDate);
                        ZoneOffset zoneOffset = ZoneOffset.ofHours(0);
                        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
                        Date horaInicio = Date.from(offsetDateTime.toInstant());
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(horaInicio);
                        calendar.add(Calendar.MINUTE, this.obtenerHabitatsDeTabla(table).size() * zonaAux.getDuracion());
                        Date horaFin = calendar.getTime();
                        Horario horario = new Horario(dia, horaInicio, horaFin);
                        listaHorarios.add(horario);
                    }
                }
            }

            if (!listaHorarios.isEmpty()) {
                ConexionMongoDB conexion = new ConexionMongoDB();
                FachadaAdministrarItinerario fachadaItinerario = new FachadaAdministrarItinerario();
                Itinerario itinerario = new Itinerario(txtNombre.getText(), Integer.valueOf(txtNoVisitantes.getText()), listaHorarios, this.obtenerHabitatsDeTabla(table));
                if (fachadaItinerario.registrarItinerario(itinerario, conexion)) {
                    regresarVentanaItinerarios();
                }
            }
        }
    }

    /**
     * Obtiene una lista de hábitats a partir de los datos de una tabla.
     *
     * @param table la tabla que contiene los datos de los hábitats.
     * @return una lista de hábitats obtenidos de la tabla.
     */
    public List<Habitat> obtenerHabitatsDeTabla(JTable table) {
        List<Habitat> habitatsT = new ArrayList<>();

        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        int rowCount = modelo.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String nombreHabitat = modelo.getValueAt(i, 1).toString();
            habitatsT.add(persistenciaHabitats.obtenerHabitat(nombreHabitat));
        }

        return habitatsT;
    }

    /**
     * Actualiza un itinerario existente con los datos proporcionados.
     *
     * @param txtNombre el campo de texto para el nombre del itinerario.
     * @param txtNoVisitantes el campo de texto para el número de visitantes del
     * itinerario.
     * @param table la tabla de hábitats del itinerario.
     */
    public void actualizarItinerario(JTextField txtNombre, JTextField txtNoVisitantes, JTable table) {
        HashMap<String, String> datos = extraerDatos(txtNombre, txtNoVisitantes);
        List<String> errores = this.validarDatos(datos, table);

        if (!errores.isEmpty()) {
            registro.mostrarErroresValidacion(errores);
            return; // Se detiene la ejecución si hay errores de validación
        }

        List<Horario> listaHorarios = new LinkedList<>();
        LocalDate currentDate = LocalDate.now();
        Zona zonaAux = new Zona();

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        for (String dia : dias) {
            for (int i = 1; i <= 4; i++) {
                TimePicker timePicker = registro.getTimePicker(dia, i);
                if (!timePicker.getText().isEmpty()) {
                    LocalDateTime localDateTime = timePicker.getTime().atDate(currentDate);
                    ZoneOffset zoneOffset = ZoneOffset.ofHours(0);
                    OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
                    Date horaInicio = Date.from(offsetDateTime.toInstant());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(horaInicio);
                    calendar.add(Calendar.MINUTE, this.obtenerHabitatsDeTabla(table).size() * zonaAux.getDuracion());
                    Date horaFin = calendar.getTime();
                    Horario horario = new Horario(dia, horaInicio, horaFin);
                    listaHorarios.add(horario);
                }
            }
        }

        if (listaHorarios.isEmpty()) {
            return; // No se realizan más acciones si no hay horarios seleccionados
        }

        List<Zona> listaZonas = new LinkedList<>();
        ConexionMongoDB conexion = new ConexionMongoDB();

        Itinerario itinerario = new Itinerario(txtNombre.getText(), Integer.valueOf(txtNoVisitantes.getText()), listaHorarios, this.obtenerHabitatsDeTabla(table));
        itinerario.setDuracion(itinerario.getListaHabitats().size() * zonaAux.getDuracion());
        itinerario.setLongitud(itinerario.getListaHabitats().size() * 100f);

        ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        Itinerario itinerarioExistente = itinerariosDAO.obtener(itinerario.getNombre());

        if (itinerarioExistente == null) {
            JOptionPane.showMessageDialog(null, "El itinerario no existe en la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si el itinerario existente tiene exactamente los mismos datos
        if (itinerarioExistente.equals(itinerario)) {
            JOptionPane.showMessageDialog(null, "No se realizaron cambios en el itinerario", "Advertencia", JOptionPane.WARNING_MESSAGE);
            regresarVentanaItinerarios();
            return;
        }

        // Actualizar el itinerario existente con los nuevos datos
        itinerarioExistente.setNoVisitantes(itinerario.getNoVisitantes());
        itinerarioExistente.setListaHorarios(itinerario.getListaHorarios());
        itinerarioExistente.setDuracion(itinerario.getDuracion());
        itinerarioExistente.setLongitud(itinerario.getLongitud());
        itinerarioExistente.setListaZonas(itinerario.getListaZonas());
        itinerarioExistente.setListaHabitats(itinerario.getListaHabitats());

        // Actualizar el itinerario en la base de datos
        itinerariosDAO.actualizar(itinerarioExistente);

        JOptionPane.showMessageDialog(null, "Se ha actualizado el itinerario " + datos.get("nombre"), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        regresarVentanaItinerarios();
    }

    /**
     * Llena un JComboBox con los hábitats obtenidos de la base de datos.
     *
     * @param cbx el JComboBox que se debe llenar con los hábitats.
     */
    public void llenarTablaHabitats(JComboBox cbx) {
        //CONEXIÓN A LA BASE DE DATOS
        ConexionMongoDB conexion = new ConexionMongoDB();
        IHabitatsDAO habitatsDAO = new HabitatsDAO(conexion);
        //Consultar habitats
        List<Habitat> habitats = habitatsDAO.consultarTodos();

        //llenar combobox
        DefaultComboBoxModel<Habitat> modelo = new DefaultComboBoxModel<>();
        habitats.forEach(habitat -> {
            modelo.addElement(habitat);
        });
        cbx.setModel(modelo);
    }

    /**
     * Agrega un hábitat seleccionado del JComboBox a la tabla.
     *
     * @param cbx el JComboBox que contiene los hábitats.
     * @param table la tabla donde se agregará el hábitat.
     * @param label el JLabel que se ocultará si no hay más hábitats disponibles
     * en el JComboBox.
     */
    public void agregarHabitat(JComboBox cbx, JTable table, JLabel label) {
        // Obtener habitat seleccionado del combobox
        Habitat habitat = (Habitat) cbx.getSelectedItem();

        // Agregar el número y el nombre del hábitat
        Object[] fila = {
            registro.getContador(),
            habitat.getNombre()
        };

        registro.setContador(registro.getContador() + 1);
        // Agregar la fila con el hábitat en la tabla
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.addRow(fila);

        // Eliminar la selección del ComboBox
        cbx.removeItemAt(cbx.getSelectedIndex());

        if (cbx.getSelectedItem() == null) {
            label.setVisible(false);
        }
    }

    /**
     * Inserta los hábitats de un itinerario en una tabla.
     *
     * @param itinerario el itinerario del cual se obtienen los hábitats.
     * @param table la tabla donde se insertarán los hábitats.
     */
    public void insertarHabitatsEnTablaActualizar(Itinerario itinerario, JTable table) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        List<Habitat> habitats = itinerario.getListaHabitats();

        for (Habitat habitat : habitats) {
            Object[] fila = {
                registro.getContador(),
                habitat.getNombre()
            };
            modelo.addRow(fila);
        }
        registro.setContador(registro.getContador() + 1);

        table.setModel(modelo);
    }

    /**
     * Método que establece el color del fondo de un JPanel.
     *
     * @param panel JPanel cuyo color de fondo va a cambiar.
     * @param color Color a poner de fondo.
     */
    public void cambiarColorPanel(JPanel panel, Color color) {
        panel.setBackground(color);
    }

    /**
     * Método que establece el color de letra de un JLabel.
     *
     * @param label JLabel cuyo color de letra va a cambiar.
     * @param color Color a poner en la letra.
     */
    public void cambiarColorLetra(JLabel label, Color color) {
        label.setForeground(color);
    }

    /**
     * Método que establece el texto y el color de letra de un JTextField.
     *
     * @param textField JTextfield a establecer.
     * @param texto Texto a colocar en JTextField.
     * @param color Color del texto a colocar en JTextField.
     */
    public void establecerTextField(JTextField textField, String texto, Color color) {
        textField.setText(texto);
        textField.setForeground(color);
    }

    /**
     * Método que esteblece el borde de un JPanel.
     *
     * @param panel JPanel cuyo borde va a cambiar.
     * @param borde Borde a poner en el panel.
     */
    public void cambiarBordePanel(JPanel panel, Border borde) {
        panel.setBorder(borde);
    }

    /**
     * Método que regresa a FrmItinerarios.
     */
    public void regresarVentanaItinerarios() {
        FrmItinerarios itinerarios = new FrmItinerarios();
        itinerarios.setVisible(true);
        frame.dispose();
    }

    /**
     * Método que establece un ícono a un JLabel.
     *
     * @param label JLabel cuyo ícono será establecido.
     * @param icono Ícono a establecer.
     */
    public void cambiarIcono(JLabel label, String icono) {
        label.setIcon(new ImageIcon(icono));
    }

    /**
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
    }

    /**
     * Restaura los hábitats en el ComboBox y muestra el label correspondiente.
     *
     * @param cbx el ComboBox donde se restaurarán los hábitats.
     * @param label el label que se mostrará después de restaurar los hábitats.
     */
    public void restaurarHabitats(JComboBox cbx, JLabel label) {
        llenarTablaHabitats(cbx);
        label.setVisible(true);
    }

}
