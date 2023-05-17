/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Habitat;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.HabitatsDAO;

/**
 * Clase encargada de la ventana Actualizar Itinerario.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class FrmActualizarItinerario extends javax.swing.JFrame {

    int xMouse, yMouse;
    private int contador = 1;
    private int cantLunes, cantMartes, cantMiercoles, cantJueves, cantViernes, cantSabado, cantDomingo;

    private final Color AMARILLO = new Color(255, 255, 153);
    private final Color GRIS = new Color(245, 245, 245);
    private final Color CAFE = new Color(102, 0, 0);

    private final int BORDE_GRUESO = 3;
    private final int BORDE_ESTRECHO = 1;

    private final String AGREGAR_CLARO = "src\\main\\resources\\img\\boton-agregar (1).png";
    private final String AGREGAR_OSCURO = "src\\main\\resources\\img\\boton-agregar (2).png";

    private final IHabitatsDAO persistencia;

    /**
     *
     * Método constructor de la clase FrmActualizarItinerario.
     *
     * @param persistencia El objeto que maneja la persistencia de los datos.
     */
    public FrmActualizarItinerario(IHabitatsDAO persistencia) {
        initComponents();
        setTitle("Actualizar Itinerario");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\paw.png");
        this.setIconImage(icon.getImage());
        this.persistencia = persistencia;
        this.llenarTablaHabitats();
        this.cantLunes = 1;
        this.cantMartes = 1;
        this.cantMiercoles = 1;
        this.cantJueves = 1;
        this.cantViernes = 1;
        this.cantSabado = 1;
        this.cantDomingo = 1;
        this.visualizarTimePicker();
        this.btnRestaLunes.setEnabled(false);
        this.btnRestaMartes.setEnabled(false);
        this.btnRestaMiercoles.setEnabled(false);
        this.btnRestaJueves.setEnabled(false);
        this.btnRestaViernes.setEnabled(false);
        this.btnRestaSabado.setEnabled(false);
        this.btnRestaDomingo.setEnabled(false);
        tblHabitats.getTableHeader().setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        tblHabitats.getTableHeader().setOpaque(false);
        tblHabitats.getTableHeader().setForeground(new Color(102, 0, 0));
        tblHabitats.setRowHeight(40);
    }

    /**
     * Método que cierra la ventana FrmActualizarItinerario.
     */
    public void cerrarVentana() {
        dispose();
    }

    /**
     * Método para visualizar los time pickers para ingresar las horas.
     */
    private void visualizarTimePicker() {
        switch (this.cantLunes) {
            case 1:
                this.tpLunes1.setVisible(true);
                this.tpLunes2.setVisible(false);
                this.tpLunes3.setVisible(false);
                this.tpLunes4.setVisible(false);
                break;
            case 2:
                this.tpLunes1.setVisible(true);
                this.tpLunes2.setVisible(true);
                this.tpLunes3.setVisible(false);
                this.tpLunes4.setVisible(false);
                break;
            case 3:
                this.tpLunes1.setVisible(true);
                this.tpLunes2.setVisible(true);
                this.tpLunes3.setVisible(true);
                this.tpLunes4.setVisible(false);
                break;
            case 4:
                this.tpLunes1.setVisible(true);
                this.tpLunes2.setVisible(true);
                this.tpLunes3.setVisible(true);
                this.tpLunes4.setVisible(true);
                break;
        }

        switch (this.cantMartes) {
            case 1:
                this.tpMartes1.setVisible(true);
                this.tpMartes2.setVisible(false);
                this.tpMartes3.setVisible(false);
                this.tpMartes4.setVisible(false);
                break;
            case 2:
                this.tpMartes1.setVisible(true);
                this.tpMartes2.setVisible(true);
                this.tpMartes3.setVisible(false);
                this.tpMartes4.setVisible(false);
                break;
            case 3:
                this.tpMartes1.setVisible(true);
                this.tpMartes2.setVisible(true);
                this.tpMartes3.setVisible(true);
                this.tpMartes4.setVisible(false);
                break;
            case 4:
                this.tpMartes1.setVisible(true);
                this.tpMartes2.setVisible(true);
                this.tpMartes3.setVisible(true);
                this.tpMartes4.setVisible(true);
                break;
        }

        switch (this.cantMiercoles) {
            case 1:
                this.tpMiercoles1.setVisible(true);
                this.tpMiercoles2.setVisible(false);
                this.tpMiercoles3.setVisible(false);
                this.tpMiercoles4.setVisible(false);
                break;
            case 2:
                this.tpMiercoles1.setVisible(true);
                this.tpMiercoles2.setVisible(true);
                this.tpMiercoles3.setVisible(false);
                this.tpMiercoles4.setVisible(false);
                break;
            case 3:
                this.tpMiercoles1.setVisible(true);
                this.tpMiercoles2.setVisible(true);
                this.tpMiercoles3.setVisible(true);
                this.tpMiercoles4.setVisible(false);
                break;
            case 4:
                this.tpMiercoles1.setVisible(true);
                this.tpMiercoles2.setVisible(true);
                this.tpMiercoles3.setVisible(true);
                this.tpMiercoles4.setVisible(true);
                break;
        }

        switch (this.cantJueves) {
            case 1:
                this.tpJueves1.setVisible(true);
                this.tpJueves2.setVisible(false);
                this.tpJueves3.setVisible(false);
                this.tpJueves4.setVisible(false);
                break;
            case 2:
                this.tpJueves1.setVisible(true);
                this.tpJueves2.setVisible(true);
                this.tpJueves3.setVisible(false);
                this.tpJueves4.setVisible(false);
                break;
            case 3:
                this.tpJueves1.setVisible(true);
                this.tpJueves2.setVisible(true);
                this.tpJueves3.setVisible(true);
                this.tpJueves4.setVisible(false);
                break;
            case 4:
                this.tpJueves1.setVisible(true);
                this.tpJueves2.setVisible(true);
                this.tpJueves3.setVisible(true);
                this.tpJueves4.setVisible(true);
                break;
        }

        switch (this.cantViernes) {
            case 1:
                this.tpViernes1.setVisible(true);
                this.tpViernes2.setVisible(false);
                this.tpViernes3.setVisible(false);
                this.tpViernes4.setVisible(false);
                break;
            case 2:
                this.tpViernes1.setVisible(true);
                this.tpViernes2.setVisible(true);
                this.tpViernes3.setVisible(false);
                this.tpViernes4.setVisible(false);
                break;
            case 3:
                this.tpViernes1.setVisible(true);
                this.tpViernes2.setVisible(true);
                this.tpViernes3.setVisible(true);
                this.tpViernes4.setVisible(false);
                break;
            case 4:
                this.tpViernes1.setVisible(true);
                this.tpViernes2.setVisible(true);
                this.tpViernes3.setVisible(true);
                this.tpViernes4.setVisible(true);
                break;
        }

        switch (this.cantSabado) {
            case 1:
                this.tpSabado1.setVisible(true);
                this.tpSabado2.setVisible(false);
                this.tpSabado3.setVisible(false);
                this.tpSabado4.setVisible(false);
                break;
            case 2:
                this.tpSabado1.setVisible(true);
                this.tpSabado2.setVisible(true);
                this.tpSabado3.setVisible(false);
                this.tpSabado4.setVisible(false);
                break;
            case 3:
                this.tpSabado1.setVisible(true);
                this.tpSabado2.setVisible(true);
                this.tpSabado3.setVisible(true);
                this.tpSabado4.setVisible(false);
                break;
            case 4:
                this.tpSabado1.setVisible(true);
                this.tpSabado2.setVisible(true);
                this.tpSabado3.setVisible(true);
                this.tpSabado4.setVisible(true);
                break;
        }

        switch (this.cantDomingo) {
            case 1:
                this.tpDomingo1.setVisible(true);
                this.tpDomingo2.setVisible(false);
                this.tpDomingo3.setVisible(false);
                this.tpDomingo4.setVisible(false);
                break;
            case 2:
                this.tpDomingo1.setVisible(true);
                this.tpDomingo2.setVisible(true);
                this.tpDomingo3.setVisible(false);
                this.tpDomingo4.setVisible(false);
                break;
            case 3:
                this.tpDomingo1.setVisible(true);
                this.tpDomingo2.setVisible(true);
                this.tpDomingo3.setVisible(true);
                this.tpDomingo4.setVisible(false);
                break;
            case 4:
                this.tpDomingo1.setVisible(true);
                this.tpDomingo2.setVisible(true);
                this.tpDomingo3.setVisible(true);
                this.tpDomingo4.setVisible(true);
                break;
        }
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
        //Obtener habitat seleccionado del combobox
        Habitat habitat = (Habitat) cbxHabitat.getSelectedItem();

        //Agregar el número y el nombre del hábitat
        Object[] fila = {
            contador++,
            habitat.getNombre()
        };
        //Agregar la fila con el hábitat en la tabla 
        DefaultTableModel modelo = (DefaultTableModel) this.tblHabitats.getModel();
        modelo.addRow(fila);

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
     * Método que establece un ícono a un JLabel.
     *
     * @param label JLabel cuyo ícono será establecido.
     * @param icono Ícono a establecer.
     */
    public void cambiarIcono(JLabel label, String icono) {
        label.setIcon(new ImageIcon(icono));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        pnlActualizar = new javax.swing.JPanel();
        lblActualizar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

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
        pnlSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        lblSalir.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(102, 0, 0));
        lblSalir.setText("X");

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
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(lblSalir)
                .addContainerGap())
        );

        pnlHeader.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, -1));

        pnlFondo.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Actualización de Itinerario");
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

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

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 340, 280));

        cbxHabitat.setBackground(new java.awt.Color(255, 255, 153));
        cbxHabitat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        cbxHabitat.setLabeText("Hábitat");
        cbxHabitat.setLineColor(new java.awt.Color(102, 0, 0));
        cbxHabitat.setToolTipText("");
        pnlFondo.add(cbxHabitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 210, 40));

        lblAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar (2).png"))); // NOI18N
        lblAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        txtNombre.setBackground(new java.awt.Color(255, 255, 153));
        txtNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("Ingrese el nombre del itinerario");
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        pnlFondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 310, -1));

        txtDuracion.setText("Ingrese la duración del itinerario");
        txtDuracion.setBackground(new java.awt.Color(255, 255, 153));
        txtDuracion.setBorder(null);
        txtDuracion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtDuracion.setForeground(new java.awt.Color(204, 204, 204));
        txtDuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDuracionMousePressed(evt);
            }
        });
        pnlFondo.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 310, -1));

        txtLongitud.setBackground(new java.awt.Color(255, 255, 153));
        txtLongitud.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtLongitud.setForeground(new java.awt.Color(204, 204, 204));
        txtLongitud.setText("Ingrese la longitud del itinerario");
        txtLongitud.setBorder(null);
        txtLongitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLongitudMousePressed(evt);
            }
        });
        pnlFondo.add(txtLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 310, -1));

        txtNoVisitantes.setBackground(new java.awt.Color(255, 255, 153));
        txtNoVisitantes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtNoVisitantes.setForeground(new java.awt.Color(204, 204, 204));
        txtNoVisitantes.setText("Ingrese el número máximo de visitantes");
        txtNoVisitantes.setBorder(null);
        txtNoVisitantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNoVisitantesMousePressed(evt);
            }
        });
        pnlFondo.add(txtNoVisitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 310, -1));

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

        pnlActualizar.setBackground(new java.awt.Color(255, 255, 255));
        pnlActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        pnlActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlActualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlActualizarMouseExited(evt);
            }
        });

        lblActualizar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblActualizar.setText("Actualizar");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N

        javax.swing.GroupLayout pnlActualizarLayout = new javax.swing.GroupLayout(pnlActualizar);
        pnlActualizar.setLayout(pnlActualizarLayout);
        pnlActualizarLayout.setHorizontalGroup(
            pnlActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActualizarLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlActualizarLayout.setVerticalGroup(
            pnlActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActualizarLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(pnlActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblActualizar))
                .addContainerGap())
        );

        pnlFondo.add(pnlActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 940, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pajaros.png"))); // NOI18N
        pnlFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbol2.png"))); // NOI18N
        pnlFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 760, 240, 190));
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
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseClicked
        cerrarVentana();
    }//GEN-LAST:event_pnlSalirMouseClicked

    private void pnlSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseEntered
        cambiarColorPanel(pnlSalir, Color.RED);
        cambiarColorLetra(lblSalir, Color.WHITE);
    }//GEN-LAST:event_pnlSalirMouseEntered

    private void pnlSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseExited
        cambiarColorPanel(pnlSalir, AMARILLO);
        cambiarColorLetra(lblSalir, CAFE);
    }//GEN-LAST:event_pnlSalirMouseExited

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
        agregarHabitat();
    }//GEN-LAST:event_lblAgregarMouseClicked

    private void lblAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseEntered
        cambiarIcono(lblAgregar, AGREGAR_CLARO);
    }//GEN-LAST:event_lblAgregarMouseEntered

    private void lblAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseExited
        cambiarIcono(lblAgregar, AGREGAR_OSCURO);
    }//GEN-LAST:event_lblAgregarMouseExited

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        establecerTextField(txtNombre, "", Color.BLACK);
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtDuracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuracionMousePressed
        establecerTextField(txtDuracion, "", Color.BLACK);
    }//GEN-LAST:event_txtDuracionMousePressed

    private void txtLongitudMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLongitudMousePressed
        establecerTextField(txtLongitud, "", Color.BLACK);
    }//GEN-LAST:event_txtLongitudMousePressed

    private void txtNoVisitantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNoVisitantesMousePressed
        establecerTextField(txtNoVisitantes, "", Color.BLACK);
    }//GEN-LAST:event_txtNoVisitantesMousePressed

    private void pnlActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlActualizarMouseClicked

    }//GEN-LAST:event_pnlActualizarMouseClicked

    private void pnlActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlActualizarMouseEntered
        cambiarColorPanel(pnlActualizar, GRIS);
        cambiarBordePanel(pnlActualizar, BorderFactory.createLineBorder(CAFE, BORDE_GRUESO));
    }//GEN-LAST:event_pnlActualizarMouseEntered

    private void pnlActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlActualizarMouseExited
        cambiarColorPanel(pnlActualizar, Color.WHITE);
        cambiarBordePanel(pnlActualizar, BorderFactory.createLineBorder(CAFE, BORDE_ESTRECHO));
    }//GEN-LAST:event_pnlActualizarMouseExited

    private void btnSumDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumDomingoActionPerformed
        this.btnRestaDomingo.setEnabled(true);
        this.cantDomingo += 1;
        this.visualizarTimePicker();
        if (this.cantDomingo == 4) {
            this.btnSumDomingo.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumDomingoActionPerformed

    private void btnRestaDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaDomingoActionPerformed
        this.btnSumDomingo.setEnabled(true);
        this.cantDomingo -= 1;
        this.visualizarTimePicker();
        if (this.cantDomingo == 1) {
            this.btnRestaDomingo.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaDomingoActionPerformed

    private void btnSumMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumMartesActionPerformed
        this.btnRestaMartes.setEnabled(true);
        this.cantMartes += 1;
        this.visualizarTimePicker();
        if (this.cantMartes == 4) {
            this.btnSumMartes.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumMartesActionPerformed

    private void btnSumMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumMiercolesActionPerformed
        this.btnRestaMiercoles.setEnabled(true);
        this.cantMiercoles += 1;
        this.visualizarTimePicker();
        if (this.cantMiercoles == 4) {
            this.btnSumMiercoles.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumMiercolesActionPerformed

    private void btnSumJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumJuevesActionPerformed
        this.btnRestaJueves.setEnabled(true);
        this.cantJueves += 1;
        this.visualizarTimePicker();
        if (this.cantJueves == 4) {
            this.btnSumJueves.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumJuevesActionPerformed

    private void btnSumViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumViernesActionPerformed
        this.btnRestaViernes.setEnabled(true);
        this.cantViernes += 1;
        this.visualizarTimePicker();
        if (this.cantViernes == 4) {
            this.btnSumViernes.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumViernesActionPerformed

    private void btnSumSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumSabadoActionPerformed
        this.btnRestaSabado.setEnabled(true);
        this.cantSabado += 1;
        this.visualizarTimePicker();
        if (this.cantSabado == 4) {
            this.btnSumSabado.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumSabadoActionPerformed

    private void btnSumLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumLunesActionPerformed
        this.btnRestaLunes.setEnabled(true);
        this.cantLunes += 1;
        this.visualizarTimePicker();
        if (this.cantLunes == 4) {
            this.btnSumLunes.setEnabled(false);
        }
    }//GEN-LAST:event_btnSumLunesActionPerformed

    private void btnRestaLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaLunesActionPerformed
        this.btnSumLunes.setEnabled(true);
        this.cantLunes -= 1;
        this.visualizarTimePicker();
        if (this.cantLunes == 1) {
            this.btnRestaLunes.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaLunesActionPerformed

    private void btnRestaMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaMartesActionPerformed
        this.btnSumMartes.setEnabled(true);
        this.cantMartes -= 1;
        this.visualizarTimePicker();
        if (this.cantMartes == 1) {
            this.btnRestaMartes.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaMartesActionPerformed

    private void btnRestaMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaMiercolesActionPerformed
        this.btnSumMiercoles.setEnabled(true);
        this.cantMiercoles -= 1;
        this.visualizarTimePicker();
        if (this.cantMiercoles == 1) {
            this.btnRestaMiercoles.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaMiercolesActionPerformed

    private void btnRestaJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaJuevesActionPerformed
        this.btnSumJueves.setEnabled(true);
        this.cantJueves -= 1;
        this.visualizarTimePicker();
        if (this.cantJueves == 1) {
            this.btnRestaJueves.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaJuevesActionPerformed

    private void btnRestaViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaViernesActionPerformed
        this.btnSumViernes.setEnabled(true);
        this.cantViernes -= 1;
        this.visualizarTimePicker();
        if (this.cantViernes == 1) {
            this.btnRestaViernes.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaViernesActionPerformed

    private void btnRestaSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaSabadoActionPerformed
        this.btnSumSabado.setEnabled(true);
        this.cantSabado -= 1;
        this.visualizarTimePicker();
        if (this.cantSabado == 1) {
            this.btnRestaSabado.setEnabled(false);
        }
    }//GEN-LAST:event_btnRestaSabadoActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblDomingo;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblJueves;
    private javax.swing.JLabel lblLongitud;
    private javax.swing.JLabel lblLunes;
    private javax.swing.JLabel lblMartes;
    private javax.swing.JLabel lblMiercoles;
    private javax.swing.JLabel lblNoVisitantes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSabado;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblViernes;
    private javax.swing.JPanel pnlActualizar;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlSalir;
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
