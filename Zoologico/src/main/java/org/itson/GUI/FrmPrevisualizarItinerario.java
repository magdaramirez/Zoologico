/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.itson.dominio.Habitat;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.HabitatsDAO;

/**
 * Clase encargada de la ventana Previsualizar Itinerario.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class FrmPrevisualizarItinerario extends javax.swing.JFrame {

    int xMouse, yMouse;

    private final Color AMARILLO = new Color(255, 255, 153);
    private final Color CAFE = new Color(102, 0, 0);

    /**
     * Método que crea FrmPrevisualizarItinerario.
     */
    public FrmPrevisualizarItinerario() {
        initComponents();
        setTitle("Previsualización de Itinerario");
        ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\paw.png");
        this.setIconImage(icon.getImage());
    }

    /**
     * Método que extrae los datos del JFrame.
     *
     * @return datos extraidos.
     */
    public HashMap<String, String> extraerDatos() {
        String nombre = txtNombre.getText();
        String duracion = txtDuracion.getText();
        String longitud = txtLongitud.getText();
        String noVisitantes = txtNoVisitantes.getText();

        HashMap<String, String> datos = new HashMap<>();
        datos.put("nombre", nombre);
        datos.put("duracion", duracion);
        datos.put("longitud", longitud);
        datos.put("noVisitantes", noVisitantes);

        return datos;
    }

    /**
     * Método que cierra la ventana FrmPrevisualizarItinerario.
     */
    public void cerrarVentana() {
        dispose();
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

    /**
     * Método que despliega la tabla de hábitats.
     */
    public void desplegarTablaHabitats() {
        //CONEXIÓN A LA BASE DE DATOS
        ConexionMongoDB conexion = new ConexionMongoDB();
        IHabitatsDAO habitatsDAO = new HabitatsDAO(conexion);
        //Consultar habitats
        List<Habitat> habitats = habitatsDAO.consultarTodos();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tpMiercoles1 = new com.github.lgooddatepicker.components.TimePicker();
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
        jLabel6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

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
        jLabel2.setText("Previsualización");
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

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

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(255, 255, 153));
        txtNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("Ingrese el nombre del itinerario");
        txtNombre.setBorder(null);
        pnlFondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 310, -1));

        txtDuracion.setEditable(false);
        txtDuracion.setBackground(new java.awt.Color(255, 255, 153));
        txtDuracion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtDuracion.setForeground(new java.awt.Color(204, 204, 204));
        txtDuracion.setText("Ingrese la duración del itinerario");
        txtDuracion.setBorder(null);
        pnlFondo.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 310, -1));

        txtLongitud.setEditable(false);
        txtLongitud.setBackground(new java.awt.Color(255, 255, 153));
        txtLongitud.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtLongitud.setForeground(new java.awt.Color(204, 204, 204));
        txtLongitud.setText("Ingrese la longitud del itinerario");
        txtLongitud.setBorder(null);
        pnlFondo.add(txtLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 310, -1));

        txtNoVisitantes.setEditable(false);
        txtNoVisitantes.setBackground(new java.awt.Color(255, 255, 153));
        txtNoVisitantes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtNoVisitantes.setForeground(new java.awt.Color(204, 204, 204));
        txtNoVisitantes.setText("Ingrese el número máximo de visitantes");
        txtNoVisitantes.setBorder(null);
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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pajaros.png"))); // NOI18N
        pnlFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbol2.png"))); // NOI18N
        pnlFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 790, 240, 190));

        tpMiercoles1.setEnabled(false);
        pnlFondo.add(tpMiercoles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, -1, -1));

        tpLunes1.setEnabled(false);
        pnlFondo.add(tpLunes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, -1, -1));

        tpLunes2.setEnabled(false);
        pnlFondo.add(tpLunes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, -1, -1));

        tpLunes3.setEnabled(false);
        pnlFondo.add(tpLunes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, -1, -1));

        tpLunes4.setEnabled(false);
        pnlFondo.add(tpLunes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 580, -1, -1));

        tpDomingo4.setEnabled(false);
        pnlFondo.add(tpDomingo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 880, -1, -1));

        tpDomingo1.setEnabled(false);
        pnlFondo.add(tpDomingo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 880, -1, -1));

        tpSabado1.setEnabled(false);
        pnlFondo.add(tpSabado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 830, -1, -1));

        tpViernes1.setEnabled(false);
        pnlFondo.add(tpViernes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 780, -1, -1));

        tpJueves1.setEnabled(false);
        pnlFondo.add(tpJueves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 730, -1, -1));

        tpMartes1.setEnabled(false);
        pnlFondo.add(tpMartes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 630, -1, -1));

        tpMartes2.setEnabled(false);
        pnlFondo.add(tpMartes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, -1, -1));

        tpMartes3.setEnabled(false);
        pnlFondo.add(tpMartes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 630, -1, -1));

        tpMartes4.setEnabled(false);
        pnlFondo.add(tpMartes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 630, -1, -1));

        tpMiercoles2.setEnabled(false);
        pnlFondo.add(tpMiercoles2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 680, -1, -1));

        tpMiercoles3.setEnabled(false);
        pnlFondo.add(tpMiercoles3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 680, -1, -1));

        tpMiercoles4.setEnabled(false);
        pnlFondo.add(tpMiercoles4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 680, -1, -1));

        tpJueves2.setEnabled(false);
        pnlFondo.add(tpJueves2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 730, -1, -1));

        tpJueves3.setEnabled(false);
        pnlFondo.add(tpJueves3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 730, -1, -1));

        tpJueves4.setEnabled(false);
        pnlFondo.add(tpJueves4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 730, -1, -1));

        tpViernes2.setEnabled(false);
        pnlFondo.add(tpViernes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 780, -1, -1));

        tpViernes3.setEnabled(false);
        pnlFondo.add(tpViernes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 780, -1, -1));

        tpViernes4.setEnabled(false);
        pnlFondo.add(tpViernes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 780, -1, -1));

        tpSabado2.setEnabled(false);
        pnlFondo.add(tpSabado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 830, -1, -1));

        tpSabado3.setEnabled(false);
        pnlFondo.add(tpSabado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 830, -1, -1));

        tpSabado4.setEnabled(false);
        pnlFondo.add(tpSabado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 830, -1, -1));

        tpDomingo2.setEnabled(false);
        pnlFondo.add(tpDomingo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 880, -1, -1));

        tpDomingo3.setEnabled(false);
        pnlFondo.add(tpDomingo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 880, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 153));
        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 35)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText(" Horarios ");
        pnlFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 140, -1));

        jSeparator6.setForeground(new java.awt.Color(102, 0, 0));
        pnlFondo.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 310, 20));

        jSeparator5.setForeground(new java.awt.Color(102, 0, 0));
        pnlFondo.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 300, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
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
