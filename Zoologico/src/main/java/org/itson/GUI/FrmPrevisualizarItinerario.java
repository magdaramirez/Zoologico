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
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.itson.dominio.Habitat;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.HabitatsDAO;

/**
 * Clase encargada de la ventana Previsualizar Itinerario.
 *
 * @author Magda Ramírez - 233523
 */
public class FrmPrevisualizarItinerario extends javax.swing.JFrame {

    int xMouse, yMouse;
    private int contador = 1;

    private final Color AMARILLO = new Color(255, 255, 153);
    private final Color CAFE = new Color(102, 0, 0);

    private final String FLECHA_BLANCA = "src\\main\\resources\\img\\flecha (1).png";
    private final String FLECHA_CAFE = "src\\main\\resources\\img\\flecha.png";

    /**
     * Método que crea FrmPrevisualizarItinerario.
     */
    public FrmPrevisualizarItinerario() {
        initComponents();
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
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
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
        pnlRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
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
        cbLunes = new org.itson.utils.CheckBoxCustom();
        cbMartes = new org.itson.utils.CheckBoxCustom();
        cbMiercoles = new org.itson.utils.CheckBoxCustom();
        cbJueves = new org.itson.utils.CheckBoxCustom();
        cbViernes = new org.itson.utils.CheckBoxCustom();
        jLabel1 = new javax.swing.JLabel();
        cbSabado = new org.itson.utils.CheckBoxCustom();
        cbDomingo = new org.itson.utils.CheckBoxCustom();
        txtViernes = new org.itson.utils.TextFieldSuggestion();
        txtJueves = new org.itson.utils.TextFieldSuggestion();
        txtSabado = new org.itson.utils.TextFieldSuggestion();
        txtDomingo = new org.itson.utils.TextFieldSuggestion();
        txtLunes = new org.itson.utils.TextFieldSuggestion();
        txtMartes = new org.itson.utils.TextFieldSuggestion();
        txtMiercoles = new org.itson.utils.TextFieldSuggestion();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        pnlHeader.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        pnlRegresar.setBackground(new java.awt.Color(255, 255, 153));
        pnlRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(lblRegresar)
                .addContainerGap())
        );

        pnlHeader.add(pnlRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, -1));

        pnlFondo.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Previsualización");
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

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

        lblDuracion.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblDuracion.setText("Duración");
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

        lblLunes.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblLunes.setText("Lunes");
        pnlFondo.add(lblLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, -1, -1));

        lblMartes.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblMartes.setText("Martes");
        pnlFondo.add(lblMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, -1, -1));

        lblMiercoles.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblMiercoles.setText("Miércoles");
        pnlFondo.add(lblMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 680, -1, -1));

        lblJueves.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblJueves.setText("Jueves");
        pnlFondo.add(lblJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 730, -1, -1));

        lblViernes.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblViernes.setText("Viernes");
        pnlFondo.add(lblViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, -1, -1));

        lblSabado.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblSabado.setText("Sábado");
        pnlFondo.add(lblSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 650, -1, -1));

        lblDomingo.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblDomingo.setText("Domingo");
        pnlFondo.add(lblDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 700, -1, -1));
        pnlFondo.add(cbLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, -1, -1));
        pnlFondo.add(cbMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, -1, -1));
        pnlFondo.add(cbMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 680, -1, -1));
        pnlFondo.add(cbJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 730, -1, -1));
        pnlFondo.add(cbViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText(" Horarios ");
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 140, -1));
        pnlFondo.add(cbSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, -1, -1));
        pnlFondo.add(cbDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 700, -1, -1));

        txtViernes.setEditable(false);
        txtViernes.setForeground(new java.awt.Color(204, 204, 204));
        txtViernes.setText("Ingrese las horas de inicio");
        txtViernes.setToolTipText("");
        txtViernes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtViernes.setOpaque(true);
        pnlFondo.add(txtViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, 260, -1));

        txtJueves.setEditable(false);
        txtJueves.setForeground(new java.awt.Color(204, 204, 204));
        txtJueves.setText("Ingrese las horas de inicio");
        txtJueves.setToolTipText("");
        txtJueves.setCaretColor(new java.awt.Color(0, 51, 51));
        txtJueves.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtJueves.setOpaque(true);
        pnlFondo.add(txtJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 720, 250, -1));

        txtSabado.setEditable(false);
        txtSabado.setForeground(new java.awt.Color(204, 204, 204));
        txtSabado.setText("Ingrese las horas de inicio");
        txtSabado.setToolTipText("");
        txtSabado.setCaretColor(new java.awt.Color(0, 51, 51));
        txtSabado.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtSabado.setOpaque(true);
        pnlFondo.add(txtSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 640, 260, -1));

        txtDomingo.setEditable(false);
        txtDomingo.setForeground(new java.awt.Color(204, 204, 204));
        txtDomingo.setText("Ingrese las horas de inicio");
        txtDomingo.setToolTipText("");
        txtDomingo.setCaretColor(new java.awt.Color(0, 51, 51));
        txtDomingo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtDomingo.setOpaque(true);
        pnlFondo.add(txtDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 690, 250, -1));

        txtLunes.setEditable(false);
        txtLunes.setForeground(new java.awt.Color(204, 204, 204));
        txtLunes.setText("Ingrese las horas de inicio");
        txtLunes.setToolTipText("");
        txtLunes.setCaretColor(new java.awt.Color(0, 51, 51));
        txtLunes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtLunes.setOpaque(true);
        pnlFondo.add(txtLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 250, -1));

        txtMartes.setEditable(false);
        txtMartes.setForeground(new java.awt.Color(204, 204, 204));
        txtMartes.setText("Ingrese las horas de inicio");
        txtMartes.setToolTipText("");
        txtMartes.setCaretColor(new java.awt.Color(0, 51, 51));
        txtMartes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtMartes.setOpaque(true);
        pnlFondo.add(txtMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 250, -1));

        txtMiercoles.setEditable(false);
        txtMiercoles.setForeground(new java.awt.Color(204, 204, 204));
        txtMiercoles.setText("Ingrese las horas de inicio");
        txtMiercoles.setToolTipText("");
        txtMiercoles.setCaretColor(new java.awt.Color(0, 51, 51));
        txtMiercoles.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtMiercoles.setOpaque(true);
        pnlFondo.add(txtMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 670, 250, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pajaros.png"))); // NOI18N
        pnlFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbol2.png"))); // NOI18N
        pnlFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 640, 240, 190));

        jSeparator5.setForeground(new java.awt.Color(102, 0, 0));
        pnlFondo.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 300, 20));

        jSeparator6.setForeground(new java.awt.Color(102, 0, 0));
        pnlFondo.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 310, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.itson.utils.CheckBoxCustom cbDomingo;
    private org.itson.utils.CheckBoxCustom cbJueves;
    private org.itson.utils.CheckBoxCustom cbLunes;
    private org.itson.utils.CheckBoxCustom cbMartes;
    private org.itson.utils.CheckBoxCustom cbMiercoles;
    private org.itson.utils.CheckBoxCustom cbSabado;
    private org.itson.utils.CheckBoxCustom cbViernes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblSabado;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblViernes;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlRegresar;
    private javax.swing.JPanel pnlSalir;
    private javax.swing.JTable tblHabitats;
    private org.itson.utils.TextFieldSuggestion txtDomingo;
    private javax.swing.JTextField txtDuracion;
    private org.itson.utils.TextFieldSuggestion txtJueves;
    private javax.swing.JTextField txtLongitud;
    private org.itson.utils.TextFieldSuggestion txtLunes;
    private org.itson.utils.TextFieldSuggestion txtMartes;
    private org.itson.utils.TextFieldSuggestion txtMiercoles;
    private javax.swing.JTextField txtNoVisitantes;
    private javax.swing.JTextField txtNombre;
    private org.itson.utils.TextFieldSuggestion txtSabado;
    private org.itson.utils.TextFieldSuggestion txtViernes;
    // End of variables declaration//GEN-END:variables
}
