/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import com.github.lgooddatepicker.components.TimePicker;
import java.awt.Component;
import java.awt.Color;
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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
 * Clase encargada de la ventana Registro Itinerario.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class FrmRegistrarItinerario extends javax.swing.JFrame {

    private int xMouse, yMouse;
    private int contador = 1;
    private int cantLunes, cantMartes, cantMiercoles, cantJueves, cantViernes, cantSabado, cantDomingo;

    private final ModoVentana modo;
    private final Itinerario itinerario;

    private final Color AMARILLO = new Color(255, 255, 153);
    private final Color GRIS = new Color(245, 245, 245);
    private final Color CAFE = new Color(102, 0, 0);
    private final Color GRIS_CLARO = new Color(204, 204, 204);

    private final int BORDE_GRUESO = 3;
    private final int BORDE_ESTRECHO = 1;

    private final String FLECHA_BLANCA = "src\\main\\resources\\img\\flecha (1).png";
    private final String FLECHA_CAFE = "src\\main\\resources\\img\\flecha.png";
    private final String AGREGAR_CLARO = "src\\main\\resources\\img\\boton-agregar (1).png";
    private final String AGREGAR_OSCURO = "src\\main\\resources\\img\\boton-agregar (2).png";
    private final String VACIAR_CLARO = "src\\main\\resources\\img\\eliminar (1).png";
    private final String VACIAR_OSCURO = "src\\main\\resources\\img\\eliminar.png";

    /**
     *
     * Método constructor de la clase FrmRegistrarItinerario.
     *
     * @param modo
     * @param itinerario
     */
    public FrmRegistrarItinerario(ModoVentana modo, Itinerario itinerario) {
        initComponents();
        setTitle("Registro de Itinerario");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\paw.png");
        this.setIconImage(icon.getImage());
        this.modo = modo;
        this.itinerario = itinerario;
        this.configurarVentana(this.modo);
    }

    public void configurarVentana(ModoVentana modo) {
        this.configurarTimePicker();

        this.btnRestaLunes.setEnabled(false);
        this.btnRestaMartes.setEnabled(false);
        this.btnRestaMiercoles.setEnabled(false);
        this.btnRestaJueves.setEnabled(false);
        this.btnRestaViernes.setEnabled(false);
        this.btnRestaSabado.setEnabled(false);
        this.btnRestaDomingo.setEnabled(false);

        switch (modo) {

            case REGISTRAR:
            case REGISTRAR_VACIOS:
                this.cantLunes = 1;
                this.cantMartes = 1;
                this.cantMiercoles = 1;
                this.cantJueves = 1;
                this.cantViernes = 1;
                this.cantSabado = 1;
                this.cantDomingo = 1;

                if (modo == ModoVentana.REGISTRAR_VACIOS) {
                    pnlRegresar.setVisible(false);
                }
                break;

            case ACTUALIZAR:
                cargarItinerario();
                this.lblTitulo.setText("Actualización de Itinerario");
                this.pnlVaciarDatos.setVisible(false);
                this.lblGuardar.setText("Actualizar");
                break;

            case PREVISUALIZAR:
                cargarItinerario();
                for (Component componente : this.pnlFondo.getComponents()) {
                    if (componente instanceof JButton) {
                        JButton boton = (JButton) componente;
                        boton.setVisible(false);
                    }
                }

                this.lblTitulo.setText("Previsualización de Itinerario");
                this.pnlVaciarDatos.setVisible(false);
                this.cbxHabitat.setVisible(false);
                this.lblAgregar.setVisible(false);
                this.lblGuardar.setText("Ver mapa");
                this.lblGuardarIMG.setVisible(false);
                this.txtNombre.setEnabled(false);
                this.txtDuracion.setEnabled(false);
                this.txtLongitud.setEnabled(false);
                this.txtNoVisitantes.setEnabled(false);
                break;

            default:
                // Acción por defecto en caso de un modo no reconocido
                break;
        }
        this.visualizarTimePicker();
        this.configurarTabla();
    }

    public void configurarTabla() {
        this.llenarTablaHabitats();
        tblHabitats.getTableHeader().setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        tblHabitats.getTableHeader().setOpaque(false);
        tblHabitats.getTableHeader().setForeground(new Color(102, 0, 0));
        tblHabitats.setRowHeight(40);
    }

    public void cargarItinerario() {
        this.txtNombre.setText(itinerario.getNombre());
        this.txtDuracion.setText(itinerario.getDuracion().toString());
        this.txtLongitud.setText(itinerario.getLongitud().toString());
        this.txtNoVisitantes.setText(itinerario.getNoVisitantes().toString());
        this.insertarHabitatsEnTablaActualizar(itinerario);

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
                TimePicker timePicker = getTimePicker(dia, i);
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
        this.cantLunes = diasIguales.getOrDefault("Lunes", 0);
        this.cantMartes = diasIguales.getOrDefault("Martes", 0);
        this.cantMiercoles = diasIguales.getOrDefault("Miércoles", 0);
        this.cantJueves = diasIguales.getOrDefault("Jueves", 0);
        this.cantViernes = diasIguales.getOrDefault("Viernes", 0);
        this.cantSabado = diasIguales.getOrDefault("Sábado", 0);
        this.cantDomingo = diasIguales.getOrDefault("Domingo", 0);
    }

    public void configurarTimePicker() {
        for (Component componente : this.pnlFondo.getComponents()) {
            if (componente instanceof TimePicker) {
                TimePicker datePicker = (TimePicker) componente;
                if (modo == ModoVentana.PREVISUALIZAR) {
                    datePicker.setEnabled(false);
                } else {
                    datePicker.getComponentTimeTextField().setEditable(false);
                }
            }
        }
    }

    /**
     * Método para visualizar los time pickers para ingresar las horas.
     */
    private void visualizarTimePicker() {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        for (String dia : dias) {
            int cantidad = obtenerCantidad(dia);
            for (int i = 1; i <= 4; i++) {
                TimePicker timePicker = getTimePicker(dia, i);
                timePicker.setVisible(i <= cantidad);
            }
        }
    }

    private int obtenerCantidad(String dia) {
        switch (dia) {
            case "Lunes":
                return this.cantLunes;
            case "Martes":
                return this.cantMartes;
            case "Miércoles":
                return this.cantMiercoles;
            case "Jueves":
                return this.cantJueves;
            case "Viernes":
                return this.cantViernes;
            case "Sábado":
                return this.cantSabado;
            case "Domingo":
                return this.cantDomingo;
            default:
                return 0;
        }
    }

    /**
     * Método que extrae los datos del JFrame.
     *
     * @return datos.
     */
    private HashMap<String, String> extraerDatos() {
        String nombre = this.txtNombre.getText();
        String duracion = this.txtDuracion.getText();
        String longitud = this.txtLongitud.getText();
        String noVisitantes = this.txtNoVisitantes.getText();

        HashMap<String, String> datos = new HashMap<>();
        datos.put("nombre", nombre);
        datos.put("duracion", duracion);
        datos.put("longitud", longitud);
        datos.put("noVisitantes", noVisitantes);

        return datos;
    }

    /**
     * Método que valida los datos del JFrame.
     *
     * @param datos Datos a validar.
     * @return errores encontrados al momento de validar.
     */
    private List<String> validarDatos(HashMap<String, String> datos) {
        List<String> erroresValidacion = new LinkedList<>();
        String nombre = datos.get("nombre");
        String duracion = datos.get("duracion");
        String longitud = datos.get("longitud");
        String noVisitantes = datos.get("noVisitantes");

        if (Validadores.esTextoVacio(nombre) || Validadores.esTextoVacio(duracion) || Validadores.esTextoVacio(longitud) || Validadores.esTablaVacia(tblHabitats)) {
            erroresValidacion.add("Datos vacíos");
        }
        if (!Validadores.esEntero(noVisitantes)) {
            erroresValidacion.add("El número de visitantes NO es número entero");
        }
        if (!Validadores.esDecimal(longitud)) {
            erroresValidacion.add("La longitud NO es número decimal");
        }
        if (!Validadores.esEntero(duracion)) {
            erroresValidacion.add("La duración NO es número entero");
        }

        return erroresValidacion;
    }

    /**
     * Método que muestra los errores de validación.
     *
     * @param erroresValidacion Lista con los errores de validación.
     */
    private void mostrarErroresValidacion(List<String> erroresValidacion) {
        String mensaje = String.join("\n", erroresValidacion);

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "ERROR",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método que lleva a cabo el registro del itinerario.
     */
    private void registrarItinerario() {
        HashMap<String, String> datos = this.extraerDatos();
        List<String> errores = this.validarDatos(datos);

        if (!errores.isEmpty()) {
            mostrarErroresValidacion(errores);
        } else {
            List<Horario> listaHorarios = new LinkedList<>();
            LocalDate currentDate = LocalDate.now();

            String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

            for (String dia : dias) {
                for (int i = 1; i <= 4; i++) {
                    TimePicker timePicker = getTimePicker(dia, i);
                    if (!timePicker.getText().isEmpty()) {
                        LocalDateTime localDateTime = timePicker.getTime().atDate(currentDate);
                        ZoneOffset zoneOffset = ZoneOffset.ofHours(0);
                        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
                        Date horaInicio = Date.from(offsetDateTime.toInstant());
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(horaInicio);
                        calendar.add(Calendar.MINUTE, Integer.parseInt(this.txtDuracion.getText()));
                        Date horaFin = calendar.getTime();
                        Horario horario = new Horario(dia, horaInicio, horaFin);
                        listaHorarios.add(horario);
                    }
                }
            }

            if (!listaHorarios.isEmpty()) {
                List<Zona> listaZonas = new LinkedList<>();
                ConexionMongoDB conexion = new ConexionMongoDB();

                Itinerario itinerario = new Itinerario(this.txtNombre.getText(), Integer.valueOf(this.txtNoVisitantes.getText()), Float.valueOf(this.txtLongitud.getText()), Integer.valueOf(this.txtDuracion.getText()), listaHorarios, listaZonas, this.obtenerHabitatsDeTabla());

                ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
                FachadaAdministrarItinerario fachadaItinerario = new FachadaAdministrarItinerario();
                String validacion = "nombre";
                if (!fachadaItinerario.validacion(itinerario, validacion, conexion)) {
                    JOptionPane.showMessageDialog(null, "Nombre repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                validacion = "visitantes";
                if (!fachadaItinerario.validacion(itinerario, validacion, conexion)) {
                    JOptionPane.showMessageDialog(null, "Visitantes", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                validacion = "horarios";
                if (!fachadaItinerario.validacion(itinerario, validacion, conexion)) {
                    JOptionPane.showMessageDialog(null, "Hora inicio de horario repetido en el mismo día", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    itinerariosDAO.agregar(itinerario);
                    JOptionPane.showMessageDialog(null, "Se ha guardado el itinerario " + datos.get("nombre"), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    regresarVentanaItinerarios();
                }
            }
        }
    }

    private TimePicker getTimePicker(String dia, int index) {
        switch (dia) {
            case "Lunes":
                switch (index) {
                    case 1:
                        return this.tpLunes1;
                    case 2:
                        return this.tpLunes2;
                    case 3:
                        return this.tpLunes3;
                    case 4:
                        return this.tpLunes4;
                }
                break;
            case "Martes":
                switch (index) {
                    case 1:
                        return this.tpMartes1;
                    case 2:
                        return this.tpMartes2;
                    case 3:
                        return this.tpMartes3;
                    case 4:
                        return this.tpMartes4;
                }
                break;
            case "Miércoles":
                switch (index) {
                    case 1:
                        return this.tpMiercoles1;
                    case 2:
                        return this.tpMiercoles2;
                    case 3:
                        return this.tpMiercoles3;
                    case 4:
                        return this.tpMiercoles4;
                }
                break;
            case "Jueves":
                switch (index) {
                    case 1:
                        return this.tpJueves1;
                    case 2:
                        return this.tpJueves2;
                    case 3:
                        return this.tpJueves3;
                    case 4:
                        return this.tpJueves4;
                }
                break;
            case "Viernes":
                switch (index) {
                    case 1:
                        return this.tpViernes1;
                    case 2:
                        return this.tpViernes2;
                    case 3:
                        return this.tpViernes3;
                    case 4:
                        return this.tpViernes4;
                }
                break;
            case "Sábado":
                switch (index) {
                    case 1:
                        return this.tpSabado1;
                    case 2:
                        return this.tpSabado2;
                    case 3:
                        return this.tpSabado3;
                    case 4:
                        return this.tpSabado4;
                }
                break;
            case "Domingo":
                switch (index) {
                    case 1:
                        return this.tpDomingo1;
                    case 2:
                        return this.tpDomingo2;
                    case 3:
                        return this.tpDomingo3;
                    case 4:
                        return this.tpDomingo4;
                }
                break;
        }
        return null;
    }

    private List<Habitat> obtenerHabitatsDeTabla() {
        List<Habitat> habitatsT = new ArrayList<>();

        DefaultTableModel modelo = (DefaultTableModel) tblHabitats.getModel();
        int rowCount = modelo.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String nombreHabitat = modelo.getValueAt(i, 1).toString();
            Habitat habitat = new Habitat(nombreHabitat);
            habitatsT.add(habitat);
        }

        return habitatsT;
    }

    /**
     * Método que llena la tabla de hábitats.
     */
    private void llenarTablaHabitats() {
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
        cbxHabitat.setModel(modelo);
    }

    /**
     * Método que agrega hábitats seleccionados del comboBox a la tabla de
     * hábitats.
     */
    private void agregarHabitat() {
        // Obtener habitat seleccionado del combobox
        Habitat habitat = (Habitat) cbxHabitat.getSelectedItem();

        // Agregar el número y el nombre del hábitat
        Object[] fila = {
            contador++,
            habitat.getNombre()
        };

        // Agregar la fila con el hábitat en la tabla
        DefaultTableModel modelo = (DefaultTableModel) this.tblHabitats.getModel();
        modelo.addRow(fila);

        // Eliminar la selección del ComboBox
        cbxHabitat.removeItemAt(cbxHabitat.getSelectedIndex());

        if (cbxHabitat.getSelectedItem() == null) {
            lblAgregar.setVisible(false);
        }
    }

    private void insertarHabitatsEnTablaActualizar(Itinerario itinerario) {
        DefaultTableModel modelo = (DefaultTableModel) tblHabitats.getModel();

        List<Habitat> habitats = itinerario.getListaHabitats();
        for (Habitat habitat : habitats) {
            Object[] fila = {
                contador++,
                habitat.getNombre()
            };
            modelo.addRow(fila);
        }

        tblHabitats.setModel(modelo);
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
     * Método que vacía todos los datos ingresados al FrmRegistrarItinerario.
     */
    public void vaciarDatos() {
        establecerTextField(txtNombre, "Ingrese el nombre del itinerario", GRIS_CLARO);
        establecerTextField(txtDuracion, "Ingrese la duración del itinerario", GRIS_CLARO);
        establecerTextField(txtLongitud, "Ingrese la longitud del itinerario", GRIS_CLARO);
        establecerTextField(txtNoVisitantes, "Ingrese el número máximo de visitantes", GRIS_CLARO);

        tpLunes1.setText("");
        tpLunes2.setText("");
        tpLunes3.setText("");
        tpLunes4.setText("");

        tpMartes1.setText("");
        tpMartes2.setText("");
        tpMartes3.setText("");
        tpMartes4.setText("");

        tpMiercoles1.setText("");
        tpMiercoles2.setText("");
        tpMiercoles3.setText("");
        tpMiercoles4.setText("");

        tpJueves1.setText("");
        tpJueves2.setText("");
        tpJueves3.setText("");
        tpJueves4.setText("");

        tpViernes1.setText("");
        tpViernes2.setText("");
        tpViernes3.setText("");
        tpViernes4.setText("");

        tpSabado1.setText("");
        tpSabado2.setText("");
        tpSabado3.setText("");
        tpSabado4.setText("");

        tpDomingo1.setText("");
        tpDomingo2.setText("");
        tpDomingo3.setText("");
        tpDomingo4.setText("");

        DefaultTableModel modelo = (DefaultTableModel) this.tblHabitats.getModel();
        modelo.setRowCount(0);
        contador = 1;
    }

    /**
     * Método que regresa a FrmItinerarios.
     */
    public void regresarVentanaItinerarios() {
        FrmItinerarios itinerarios = new FrmItinerarios();
        itinerarios.setVisible(true);
        dispose();
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

    private void salirDelPrograma() {
        System.exit(0);
    }

    private void restaurarHabitats() {
        llenarTablaHabitats();
        lblAgregar.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        pnlRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHabitats = new javax.swing.JTable();
        cbxHabitat = new org.itson.utils.Combobox<>();
        lblAgregar = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        lblLongitud = new javax.swing.JLabel();
        lblNoVisitantes = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        txtLongitud = new javax.swing.JTextField();
        txtNoVisitantes = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lblLunes = new javax.swing.JLabel();
        lblMartes = new javax.swing.JLabel();
        lblMiercoles = new javax.swing.JLabel();
        lblJueves = new javax.swing.JLabel();
        lblViernes = new javax.swing.JLabel();
        lblSabado = new javax.swing.JLabel();
        lblDomingo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlGuardar = new javax.swing.JPanel();
        lblGuardar = new javax.swing.JLabel();
        lblGuardarIMG = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlVaciarDatos = new javax.swing.JPanel();
        lblVaciarDatos = new javax.swing.JLabel();
        lblVaciar = new javax.swing.JLabel();
        lblUnderline = new javax.swing.JLabel();
        tpMiercoles1 = new com.github.lgooddatepicker.components.TimePicker();
        btnSumDomingo = new javax.swing.JButton();
        btnRestaDomingo = new javax.swing.JButton();
        btnSumMartes = new javax.swing.JButton();
        btnSumMiercoles = new javax.swing.JButton();
        btnSumJueves = new javax.swing.JButton();
        btnSumViernes = new javax.swing.JButton();
        btnSumSabado = new javax.swing.JButton();
        tpLunes1 = new com.github.lgooddatepicker.components.TimePicker();
        tpLunes2 = new com.github.lgooddatepicker.components.TimePicker();
        tpLunes3 = new com.github.lgooddatepicker.components.TimePicker();
        tpLunes4 = new com.github.lgooddatepicker.components.TimePicker();
        tpDomingo4 = new com.github.lgooddatepicker.components.TimePicker();
        tpDomingo1 = new com.github.lgooddatepicker.components.TimePicker();
        tpSabado1 = new com.github.lgooddatepicker.components.TimePicker();
        tpViernes1 = new com.github.lgooddatepicker.components.TimePicker();
        tpJueves1 = new com.github.lgooddatepicker.components.TimePicker();
        tpMartes1 = new com.github.lgooddatepicker.components.TimePicker();
        tpMartes2 = new com.github.lgooddatepicker.components.TimePicker();
        tpMartes3 = new com.github.lgooddatepicker.components.TimePicker();
        tpMartes4 = new com.github.lgooddatepicker.components.TimePicker();
        tpMiercoles2 = new com.github.lgooddatepicker.components.TimePicker();
        tpMiercoles3 = new com.github.lgooddatepicker.components.TimePicker();
        tpMiercoles4 = new com.github.lgooddatepicker.components.TimePicker();
        tpJueves2 = new com.github.lgooddatepicker.components.TimePicker();
        tpJueves3 = new com.github.lgooddatepicker.components.TimePicker();
        tpJueves4 = new com.github.lgooddatepicker.components.TimePicker();
        tpViernes2 = new com.github.lgooddatepicker.components.TimePicker();
        tpViernes3 = new com.github.lgooddatepicker.components.TimePicker();
        tpViernes4 = new com.github.lgooddatepicker.components.TimePicker();
        tpSabado2 = new com.github.lgooddatepicker.components.TimePicker();
        tpSabado3 = new com.github.lgooddatepicker.components.TimePicker();
        tpSabado4 = new com.github.lgooddatepicker.components.TimePicker();
        tpDomingo2 = new com.github.lgooddatepicker.components.TimePicker();
        tpDomingo3 = new com.github.lgooddatepicker.components.TimePicker();
        btnSumLunes = new javax.swing.JButton();
        btnRestaLunes = new javax.swing.JButton();
        btnRestaMartes = new javax.swing.JButton();
        btnRestaMiercoles = new javax.swing.JButton();
        btnRestaJueves = new javax.swing.JButton();
        btnRestaViernes = new javax.swing.JButton();
        btnRestaSabado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(255, 255, 153));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 153));
        pnlHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSalir.setBackground(new java.awt.Color(255, 255, 153));
        pnlSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSalirMouseExited(evt);
            }
        });

        lblSalir.setText("X");
        lblSalir.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout pnlSalirLayout = new javax.swing.GroupLayout(pnlSalir);
        pnlSalir.setLayout(pnlSalirLayout);
        pnlSalirLayout.setHorizontalGroup(
            pnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalirLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblSalir)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlSalirLayout.setVerticalGroup(
            pnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir)
                .addContainerGap())
        );

        pnlHeader.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, -1));

        pnlRegresar.setBackground(new java.awt.Color(255, 255, 153));
        pnlRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlRegresarMouseExited(evt);
            }
        });

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha.png"))); // NOI18N

        javax.swing.GroupLayout pnlRegresarLayout = new javax.swing.GroupLayout(pnlRegresar);
        pnlRegresar.setLayout(pnlRegresarLayout);
        pnlRegresarLayout.setHorizontalGroup(
            pnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegresarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegresar)
                .addGap(17, 17, 17))
        );
        pnlRegresarLayout.setVerticalGroup(
            pnlRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegresarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegresar)
                .addContainerGap())
        );

        pnlHeader.add(pnlRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, -1));

        pnlFondo.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registro de Itinerario");
        lblTitulo.setFont(new java.awt.Font("Berlin Sans FB", 0, 50)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 0));
        pnlFondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 40, 1000, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tblHabitats.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tblHabitats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Hábitats"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHabitats.setSelectionBackground(new java.awt.Color(221, 192, 192));
        tblHabitats.getTableHeader().setResizingAllowed(false);
        tblHabitats.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHabitats);
        if (tblHabitats.getColumnModel().getColumnCount() > 0) {
            tblHabitats.getColumnModel().getColumn(0).setResizable(false);
            tblHabitats.getColumnModel().getColumn(1).setResizable(false);
        }

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 340, 280));

        cbxHabitat.setBackground(new java.awt.Color(255, 255, 153));
        cbxHabitat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        cbxHabitat.setLabeText("Hábitat");
        cbxHabitat.setLineColor(new java.awt.Color(102, 0, 0));
        cbxHabitat.setToolTipText("");
        pnlFondo.add(cbxHabitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 210, 40));

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar (2).png"))); // NOI18N
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAgregarMouseExited(evt);
            }
        });
        pnlFondo.add(lblAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        lblNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblNombre.setText("Nombre");
        pnlFondo.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        lblDuracion.setText("Duración");
        lblDuracion.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));

        lblLongitud.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblLongitud.setText("Longitud");
        pnlFondo.add(lblLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

        lblNoVisitantes.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblNoVisitantes.setText("No. máximo de visitantes");
        pnlFondo.add(lblNoVisitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, -1, -1));

        txtNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtNombre.setText("Ingrese el nombre del itinerario");
        txtNombre.setBackground(new java.awt.Color(255, 255, 153));
        txtNombre.setBorder(null);
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre.setDoubleBuffered(true);
        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        pnlFondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 310, 20));

        txtDuracion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtDuracion.setText("Ingrese la duración del itinerario");
        txtDuracion.setBackground(new java.awt.Color(255, 255, 153));
        txtDuracion.setBorder(null);
        txtDuracion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDuracion.setDoubleBuffered(true);
        txtDuracion.setForeground(new java.awt.Color(204, 204, 204));
        txtDuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDuracionMousePressed(evt);
            }
        });
        pnlFondo.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 310, 20));

        txtLongitud.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtLongitud.setText("Ingrese la longitud del itinerario");
        txtLongitud.setBackground(new java.awt.Color(255, 255, 153));
        txtLongitud.setBorder(null);
        txtLongitud.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLongitud.setDoubleBuffered(true);
        txtLongitud.setForeground(new java.awt.Color(204, 204, 204));
        txtLongitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLongitudMousePressed(evt);
            }
        });
        pnlFondo.add(txtLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 310, 20));

        txtNoVisitantes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtNoVisitantes.setText("Ingrese el número máximo de visitantes");
        txtNoVisitantes.setBackground(new java.awt.Color(255, 255, 153));
        txtNoVisitantes.setBorder(null);
        txtNoVisitantes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNoVisitantes.setDoubleBuffered(true);
        txtNoVisitantes.setForeground(new java.awt.Color(204, 204, 204));
        txtNoVisitantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNoVisitantesMousePressed(evt);
            }
        });
        pnlFondo.add(txtNoVisitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 310, 20));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        pnlFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 310, 20));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 153));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        pnlFondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 310, 20));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 153));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        pnlFondo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 310, 20));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 153));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        pnlFondo.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 310, 20));

        lblLunes.setText("Lunes");
        lblLunes.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, -1, -1));

        lblMartes.setText("Martes");
        lblMartes.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 630, -1, -1));

        lblMiercoles.setText("Miércoles");
        lblMiercoles.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 680, -1, -1));

        lblJueves.setText("Jueves");
        lblJueves.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 730, -1, -1));

        lblViernes.setText("Viernes");
        lblViernes.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 780, -1, -1));

        lblSabado.setText("Sábado");
        lblSabado.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 830, -1, -1));

        lblDomingo.setText("Domingo");
        lblDomingo.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        pnlFondo.add(lblDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 880, -1, -1));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Seleccione días y especifique horas de inicio");
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, -1));

        pnlGuardar.setBackground(new java.awt.Color(255, 255, 255));
        pnlGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        pnlGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlGuardarMouseExited(evt);
            }
        });

        lblGuardar.setText("Guardar");
        lblGuardar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        lblGuardarIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N

        javax.swing.GroupLayout pnlGuardarLayout = new javax.swing.GroupLayout(pnlGuardar);
        pnlGuardar.setLayout(pnlGuardarLayout);
        pnlGuardarLayout.setHorizontalGroup(
            pnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuardarLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblGuardarIMG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGuardar)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlGuardarLayout.setVerticalGroup(
            pnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGuardarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGuardarIMG)
                    .addComponent(lblGuardar))
                .addContainerGap())
        );

        pnlFondo.add(pnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 940, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pajaros.png"))); // NOI18N
        pnlFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbol2.png"))); // NOI18N
        pnlFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 760, 240, 190));

        pnlVaciarDatos.setBackground(new java.awt.Color(255, 255, 153));
        pnlVaciarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlVaciarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlVaciarDatosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlVaciarDatosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlVaciarDatosMouseExited(evt);
            }
        });
        pnlVaciarDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVaciarDatos.setText("Vaciar Datos");
        lblVaciarDatos.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        pnlVaciarDatos.add(lblVaciarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        lblVaciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        pnlVaciarDatos.add(lblVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, -1, -1));

        lblUnderline.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblUnderline.setText("____________");
        pnlVaciarDatos.add(lblUnderline, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, -1));

        pnlFondo.add(pnlVaciarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 940, 140, 40));
        pnlFondo.add(tpMiercoles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, -1, -1));

        btnSumDomingo.setText("+");
        btnSumDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumDomingoActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSumDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 880, -1, -1));

        btnRestaDomingo.setText("-");
        btnRestaDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaDomingoActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRestaDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 880, -1, -1));

        btnSumMartes.setText("+");
        btnSumMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumMartesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSumMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, -1, -1));

        btnSumMiercoles.setText("+");
        btnSumMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumMiercolesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSumMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 680, -1, -1));

        btnSumJueves.setText("+");
        btnSumJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumJuevesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSumJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 730, -1, -1));

        btnSumViernes.setText("+");
        btnSumViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumViernesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSumViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 780, -1, -1));

        btnSumSabado.setText("+");
        btnSumSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumSabadoActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSumSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 830, -1, -1));
        pnlFondo.add(tpLunes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, -1, -1));
        pnlFondo.add(tpLunes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, -1, -1));
        pnlFondo.add(tpLunes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, -1, -1));
        pnlFondo.add(tpLunes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 580, -1, -1));
        pnlFondo.add(tpDomingo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 880, -1, -1));
        pnlFondo.add(tpDomingo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 880, -1, -1));
        pnlFondo.add(tpSabado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 830, -1, -1));
        pnlFondo.add(tpViernes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 780, -1, -1));
        pnlFondo.add(tpJueves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 730, -1, -1));
        pnlFondo.add(tpMartes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 630, -1, -1));
        pnlFondo.add(tpMartes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, -1, -1));
        pnlFondo.add(tpMartes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 630, -1, -1));
        pnlFondo.add(tpMartes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 630, -1, -1));
        pnlFondo.add(tpMiercoles2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 680, -1, -1));
        pnlFondo.add(tpMiercoles3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 680, -1, -1));
        pnlFondo.add(tpMiercoles4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 680, -1, -1));
        pnlFondo.add(tpJueves2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 730, -1, -1));
        pnlFondo.add(tpJueves3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 730, -1, -1));
        pnlFondo.add(tpJueves4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 730, -1, -1));
        pnlFondo.add(tpViernes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 780, -1, -1));
        pnlFondo.add(tpViernes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 780, -1, -1));
        pnlFondo.add(tpViernes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 780, -1, -1));
        pnlFondo.add(tpSabado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 830, -1, -1));
        pnlFondo.add(tpSabado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 830, -1, -1));
        pnlFondo.add(tpSabado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 830, -1, -1));
        pnlFondo.add(tpDomingo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 880, -1, -1));
        pnlFondo.add(tpDomingo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 880, -1, -1));

        btnSumLunes.setText("+");
        btnSumLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumLunesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSumLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, -1, -1));

        btnRestaLunes.setText("-");
        btnRestaLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaLunesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRestaLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, -1, -1));

        btnRestaMartes.setText("-");
        btnRestaMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaMartesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRestaMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, -1, -1));

        btnRestaMiercoles.setText("-");
        btnRestaMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaMiercolesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRestaMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, -1, -1));

        btnRestaJueves.setText("-");
        btnRestaJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaJuevesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRestaJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 730, -1, -1));

        btnRestaViernes.setText("-");
        btnRestaViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaViernesActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRestaViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 780, -1, -1));

        btnRestaSabado.setText("-");
        btnRestaSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaSabadoActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRestaSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 830, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que permite que al hacerle clic a pnlSalir ejecute el método
     * salirDelPrograma.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseClicked
        salirDelPrograma();
    }//GEN-LAST:event_pnlSalirMouseClicked
    /**
     * Método que permite cambiar el color de fondo del pnlSalir y el color de
     * su letra.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseEntered
        cambiarColorPanel(pnlSalir, Color.RED);
        cambiarColorLetra(lblSalir, Color.WHITE);
    }//GEN-LAST:event_pnlSalirMouseEntered
    /**
     * Método que permite que al quitar el mouse de pnlSalir, regrese al color
     * de fondo y al color del letra originales.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseExited
        cambiarColorPanel(pnlSalir, AMARILLO);
        cambiarColorLetra(lblSalir, CAFE);
    }//GEN-LAST:event_pnlSalirMouseExited
    /**
     * Método que al darle click a pnlRegresar ejecuta el método
     * regresarVentanaItinerarios.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseClicked
        regresarVentanaItinerarios();
    }//GEN-LAST:event_pnlRegresarMouseClicked

    /**
     * Método que al entrar a pnlRegresar ejecuta los métodos cambiarColorPanel
     * y cambiarIcono.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseEntered
        cambiarColorPanel(pnlRegresar, Color.RED);
        cambiarIcono(lblRegresar, FLECHA_BLANCA);
    }//GEN-LAST:event_pnlRegresarMouseEntered
    /**
     * Método que al salir de pnlRegresar ejecuta los métodos cambiarColorPanel
     * y cambiarIcono.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseExited
        cambiarColorPanel(pnlRegresar, AMARILLO);
        cambiarIcono(lblRegresar, FLECHA_CAFE);
    }//GEN-LAST:event_pnlRegresarMouseExited
    /**
     * Método que al arrastrar el mouse permita mover la pantalla.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_pnlHeaderMouseDragged
    /**
     * Método que permita almacenar las coordenadas del mouse.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed
    /**
     * Método que al dale clic a lblAgregar, agrega el hábitat seleccionada en
     * el comboBox a la tabla.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
        agregarHabitat();
    }//GEN-LAST:event_lblAgregarMouseClicked
    /**
     * Método que al entrar al lblAgregar ejecuta el método cambiarIcono.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void lblAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseEntered
        cambiarIcono(lblAgregar, AGREGAR_CLARO);
    }//GEN-LAST:event_lblAgregarMouseEntered
    /**
     * Método que al salir al lblAgregar ejecuta el método cambiarIcono.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void lblAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseExited
        cambiarIcono(lblAgregar, AGREGAR_OSCURO);
    }//GEN-LAST:event_lblAgregarMouseExited
    /**
     * Método que al presionar txtDuracion ejecuta el método
     * establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtDuracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuracionMousePressed
        if (modo == ModoVentana.REGISTRAR || modo == ModoVentana.REGISTRAR_VACIOS) {
            establecerTextField(txtDuracion, "", Color.BLACK);
        }
    }//GEN-LAST:event_txtDuracionMousePressed
    /**
     * Método que al presionar txtLongitud ejecuta el método
     * establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtLongitudMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLongitudMousePressed
        if (modo == ModoVentana.REGISTRAR || modo == ModoVentana.REGISTRAR_VACIOS) {
            establecerTextField(txtLongitud, "", Color.BLACK);
        }
    }//GEN-LAST:event_txtLongitudMousePressed
    /**
     * Método que al presionar txtNoVisitantes ejecuta el método
     * establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtNoVisitantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNoVisitantesMousePressed
        if (modo == ModoVentana.REGISTRAR || modo == ModoVentana.REGISTRAR_VACIOS) {
            establecerTextField(txtNoVisitantes, "", Color.BLACK);
        }
    }//GEN-LAST:event_txtNoVisitantesMousePressed
    /**
     * Método que al presionar txtNombre ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        if (modo == ModoVentana.REGISTRAR || modo == ModoVentana.REGISTRAR_VACIOS) {
            establecerTextField(txtNombre, "", Color.BLACK);
        }
    }//GEN-LAST:event_txtNombreMousePressed

    private void pnlGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGuardarMouseClicked
        if (modo == ModoVentana.ACTUALIZAR) {

        } else {
            registrarItinerario();
        }
    }//GEN-LAST:event_pnlGuardarMouseClicked
    /**
     * Método que al entrar el mouse a pnlGuardar, ejecuta los métodos
     * cambiarColorPanel y cambiarBordePanel.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGuardarMouseEntered
        cambiarColorPanel(pnlGuardar, GRIS);
        cambiarBordePanel(pnlGuardar, BorderFactory.createLineBorder(CAFE, BORDE_GRUESO));
    }//GEN-LAST:event_pnlGuardarMouseEntered
    /**
     * Método que al salir el mouse a pnlGuardar, ejecuta los métodos
     * cambiarColorPanel y cambiarBordePanel.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGuardarMouseExited
        cambiarColorPanel(pnlGuardar, Color.WHITE);
        cambiarBordePanel(pnlGuardar, BorderFactory.createLineBorder(CAFE, BORDE_ESTRECHO));
    }//GEN-LAST:event_pnlGuardarMouseExited
    /**
     * Método que al darle click a pnlVaciarDatos ejecuta el método vaciarDatos.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlVaciarDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVaciarDatosMouseClicked
        vaciarDatos();
        restaurarHabitats();
    }//GEN-LAST:event_pnlVaciarDatosMouseClicked
    /**
     * Método que al entrar el mouse a pnlVaciarDatos ejecuta los métodos
     * cambiarColorLetra y cambiarIcono.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlVaciarDatosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVaciarDatosMouseEntered
        cambiarColorLetra(lblVaciarDatos, Color.GRAY);
        cambiarColorLetra(lblUnderline, Color.GRAY);
        cambiarIcono(lblVaciar, VACIAR_CLARO);
    }//GEN-LAST:event_pnlVaciarDatosMouseEntered
    /**
     * Método que al salir el mouse de pnlVaciarDatos ejecuta los métodos
     * cambiarColorLetra y cambiarIcono.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlVaciarDatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVaciarDatosMouseExited
        cambiarColorLetra(lblVaciarDatos, Color.BLACK);
        cambiarColorLetra(lblUnderline, Color.BLACK);
        cambiarIcono(lblVaciar, VACIAR_OSCURO);
    }//GEN-LAST:event_pnlVaciarDatosMouseExited
    /**
     * Método para agregar horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnSumLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumLunesActionPerformed
        this.btnRestaLunes.setEnabled(true);
        this.cantLunes += 1;
        this.visualizarTimePicker();
        if (this.cantLunes == 4) {
            this.btnSumLunes.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumLunesActionPerformed
    /**
     * Método para disminuir horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnRestaLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaLunesActionPerformed
        this.btnSumLunes.setEnabled(true);
        this.cantLunes -= 1;
        this.visualizarTimePicker();
        if (this.cantLunes == 1) {
            this.btnRestaLunes.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaLunesActionPerformed
    /**
     * Método para agregar horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnSumMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumMartesActionPerformed
        this.btnRestaMartes.setEnabled(true);
        this.cantMartes += 1;
        this.visualizarTimePicker();
        if (this.cantMartes == 4) {
            this.btnSumMartes.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumMartesActionPerformed
    /**
     * Método para disminuir horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnRestaMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaMartesActionPerformed
        this.btnSumMartes.setEnabled(true);
        this.cantMartes -= 1;
        this.visualizarTimePicker();
        if (this.cantMartes == 1) {
            this.btnRestaMartes.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaMartesActionPerformed
    /**
     * Método para agregar horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnSumMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumMiercolesActionPerformed
        this.btnRestaMiercoles.setEnabled(true);
        this.cantMiercoles += 1;
        this.visualizarTimePicker();
        if (this.cantMiercoles == 4) {
            this.btnSumMiercoles.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumMiercolesActionPerformed
    /**
     * Método para disminuir horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnRestaMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaMiercolesActionPerformed
        this.btnSumMiercoles.setEnabled(true);
        this.cantMiercoles -= 1;
        this.visualizarTimePicker();
        if (this.cantMiercoles == 1) {
            this.btnRestaMiercoles.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaMiercolesActionPerformed
    /**
     * Método para agregar horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnSumJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumJuevesActionPerformed
        this.btnRestaJueves.setEnabled(true);
        this.cantJueves += 1;
        this.visualizarTimePicker();
        if (this.cantJueves == 4) {
            this.btnSumJueves.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumJuevesActionPerformed
    /**
     * Método para disminuir horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnRestaJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaJuevesActionPerformed
        this.btnSumJueves.setEnabled(true);
        this.cantJueves -= 1;
        this.visualizarTimePicker();
        if (this.cantJueves == 1) {
            this.btnRestaJueves.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaJuevesActionPerformed
    /**
     * Método para agregar horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnSumViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumViernesActionPerformed
        this.btnRestaViernes.setEnabled(true);
        this.cantViernes += 1;
        this.visualizarTimePicker();
        if (this.cantViernes == 4) {
            this.btnSumViernes.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumViernesActionPerformed
    /**
     * Método para disminuir horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnRestaViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaViernesActionPerformed
        this.btnSumViernes.setEnabled(true);
        this.cantViernes -= 1;
        this.visualizarTimePicker();
        if (this.cantViernes == 1) {
            this.btnRestaViernes.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaViernesActionPerformed
    /**
     * Método para agregar horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnSumSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumSabadoActionPerformed
        this.btnRestaSabado.setEnabled(true);
        this.cantSabado += 1;
        this.visualizarTimePicker();
        if (this.cantSabado == 4) {
            this.btnSumSabado.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumSabadoActionPerformed
    /**
     * Método para disminuir horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnRestaSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaSabadoActionPerformed
        this.btnSumSabado.setEnabled(true);
        this.cantSabado -= 1;
        this.visualizarTimePicker();
        if (this.cantSabado == 1) {
            this.btnRestaSabado.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaSabadoActionPerformed
    /**
     * Método para agregar horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnSumDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumDomingoActionPerformed
        this.btnRestaDomingo.setEnabled(true);
        this.cantDomingo += 1;
        this.visualizarTimePicker();
        if (this.cantDomingo == 4) {
            this.btnSumDomingo.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumDomingoActionPerformed
    /**
     * Método para disminuir horas.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void btnRestaDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaDomingoActionPerformed
        this.btnSumDomingo.setEnabled(true);
        this.cantDomingo -= 1;
        this.visualizarTimePicker();
        if (this.cantDomingo == 1) {
            this.btnRestaDomingo.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaDomingoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestaDomingo;
    private javax.swing.JButton btnRestaJueves;
    private javax.swing.JButton btnRestaLunes;
    private javax.swing.JButton btnRestaMartes;
    private javax.swing.JButton btnRestaMiercoles;
    private javax.swing.JButton btnRestaSabado;
    private javax.swing.JButton btnRestaViernes;
    private javax.swing.JButton btnSumDomingo;
    private javax.swing.JButton btnSumJueves;
    private javax.swing.JButton btnSumLunes;
    private javax.swing.JButton btnSumMartes;
    private javax.swing.JButton btnSumMiercoles;
    private javax.swing.JButton btnSumSabado;
    private javax.swing.JButton btnSumViernes;
    private org.itson.utils.Combobox<Habitat> cbxHabitat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblDomingo;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblGuardarIMG;
    private javax.swing.JLabel lblJueves;
    private javax.swing.JLabel lblLongitud;
    private javax.swing.JLabel lblLunes;
    private javax.swing.JLabel lblMartes;
    private javax.swing.JLabel lblMiercoles;
    private javax.swing.JLabel lblNoVisitantes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblSabado;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnderline;
    private javax.swing.JLabel lblVaciar;
    private javax.swing.JLabel lblVaciarDatos;
    private javax.swing.JLabel lblViernes;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlGuardar;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlRegresar;
    private javax.swing.JPanel pnlSalir;
    private javax.swing.JPanel pnlVaciarDatos;
    private javax.swing.JTable tblHabitats;
    private com.github.lgooddatepicker.components.TimePicker tpDomingo1;
    private com.github.lgooddatepicker.components.TimePicker tpDomingo2;
    private com.github.lgooddatepicker.components.TimePicker tpDomingo3;
    private com.github.lgooddatepicker.components.TimePicker tpDomingo4;
    private com.github.lgooddatepicker.components.TimePicker tpJueves1;
    private com.github.lgooddatepicker.components.TimePicker tpJueves2;
    private com.github.lgooddatepicker.components.TimePicker tpJueves3;
    private com.github.lgooddatepicker.components.TimePicker tpJueves4;
    private com.github.lgooddatepicker.components.TimePicker tpLunes1;
    private com.github.lgooddatepicker.components.TimePicker tpLunes2;
    private com.github.lgooddatepicker.components.TimePicker tpLunes3;
    private com.github.lgooddatepicker.components.TimePicker tpLunes4;
    private com.github.lgooddatepicker.components.TimePicker tpMartes1;
    private com.github.lgooddatepicker.components.TimePicker tpMartes2;
    private com.github.lgooddatepicker.components.TimePicker tpMartes3;
    private com.github.lgooddatepicker.components.TimePicker tpMartes4;
    private com.github.lgooddatepicker.components.TimePicker tpMiercoles1;
    private com.github.lgooddatepicker.components.TimePicker tpMiercoles2;
    private com.github.lgooddatepicker.components.TimePicker tpMiercoles3;
    private com.github.lgooddatepicker.components.TimePicker tpMiercoles4;
    private com.github.lgooddatepicker.components.TimePicker tpSabado1;
    private com.github.lgooddatepicker.components.TimePicker tpSabado2;
    private com.github.lgooddatepicker.components.TimePicker tpSabado3;
    private com.github.lgooddatepicker.components.TimePicker tpSabado4;
    private com.github.lgooddatepicker.components.TimePicker tpViernes1;
    private com.github.lgooddatepicker.components.TimePicker tpViernes2;
    private com.github.lgooddatepicker.components.TimePicker tpViernes3;
    private com.github.lgooddatepicker.components.TimePicker tpViernes4;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNoVisitantes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
