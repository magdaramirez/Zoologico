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
 * Clase encargada de la ventana Registro Itinerario.
 *
 * @author Magda Ramírez - 233523
 */
public class FrmRegistroItinerario extends javax.swing.JFrame {

    private int xMouse, yMouse;
    private int contador = 1;
    
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
   
    private final IHabitatsDAO persistencia;

    /**
     * Método que crea FrmRegistroItinerario.
     * @param persistencia
     */
    public FrmRegistroItinerario(IHabitatsDAO persistencia) {
        initComponents();
        ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\paw.png");
        this.setIconImage(icon.getImage());
        this.persistencia = persistencia;
        this.llenarTablaHabitats();

        tblHabitats.getTableHeader().setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        tblHabitats.getTableHeader().setOpaque(false);
        tblHabitats.getTableHeader().setForeground(new Color(102, 0, 0));
        tblHabitats.setRowHeight(40);
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
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
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
     * Método que vacía todos los datos ingresados al FrmRegistroItinerario.
     */
    public void vaciarDatos() {
        establecerTextField(txtNombre, "Ingrese el nombre del itinerario", GRIS_CLARO);
        establecerTextField(txtDuracion, "Ingrese la duración del itinerario", GRIS_CLARO);
        establecerTextField(txtLongitud, "Ingrese la longitud del itinerario", GRIS_CLARO);
        establecerTextField(txtNoVisitantes, "Ingrese el número máximo de visitantes", GRIS_CLARO);

        establecerTextField(txtLunes, "Ingrese las horas de inicio", GRIS_CLARO);
        establecerTextField(txtMartes, "Ingrese las horas de inicio", GRIS_CLARO);
        establecerTextField(txtMiercoles, "Ingrese las horas de inicio", GRIS_CLARO);
        establecerTextField(txtJueves, "Ingrese las horas de inicio", GRIS_CLARO);
        establecerTextField(txtViernes, "Ingrese las horas de inicio", GRIS_CLARO);
        establecerTextField(txtSabado, "Ingrese las horas de inicio", GRIS_CLARO);
        establecerTextField(txtDomingo, "Ingrese las horas de inicio", GRIS_CLARO);

        cbLunes.setSelected(false);
        cbMartes.setSelected(false);
        cbMiercoles.setSelected(false);
        cbJueves.setSelected(false);
        cbViernes.setSelected(false);
        cbSabado.setSelected(false);
        cbDomingo.setSelected(false);

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
        cbLunes = new org.itson.utils.CheckBoxCustom();
        cbMartes = new org.itson.utils.CheckBoxCustom();
        cbMiercoles = new org.itson.utils.CheckBoxCustom();
        cbJueves = new org.itson.utils.CheckBoxCustom();
        cbViernes = new org.itson.utils.CheckBoxCustom();
        cbSabado = new org.itson.utils.CheckBoxCustom();
        cbDomingo = new org.itson.utils.CheckBoxCustom();
        jLabel1 = new javax.swing.JLabel();
        txtViernes = new org.itson.utils.TextFieldSuggestion();
        txtJueves = new org.itson.utils.TextFieldSuggestion();
        txtSabado = new org.itson.utils.TextFieldSuggestion();
        txtDomingo = new org.itson.utils.TextFieldSuggestion();
        txtLunes = new org.itson.utils.TextFieldSuggestion();
        txtMartes = new org.itson.utils.TextFieldSuggestion();
        txtMiercoles = new org.itson.utils.TextFieldSuggestion();
        pnlGuardar = new javax.swing.JPanel();
        lblGuardar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlVaciarDatos = new javax.swing.JPanel();
        lblVaciarDatos = new javax.swing.JLabel();
        lblVaciar = new javax.swing.JLabel();
        lblUnderline = new javax.swing.JLabel();

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
        jLabel2.setText("Registro de Itinerario");
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

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
        cbxHabitat.setToolTipText("");
        cbxHabitat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        cbxHabitat.setLabeText("Hábitat");
        cbxHabitat.setLineColor(new java.awt.Color(102, 0, 0));
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

        lblDuracion.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        lblDuracion.setText("Duración");
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

        txtDuracion.setBackground(new java.awt.Color(255, 255, 153));
        txtDuracion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtDuracion.setForeground(new java.awt.Color(204, 204, 204));
        txtDuracion.setText("Ingrese la duración del itinerario");
        txtDuracion.setBorder(null);
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
        pnlFondo.add(cbSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, -1, -1));
        pnlFondo.add(cbDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 700, -1, -1));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Seleccione días y especifique horas de inicio");
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        txtViernes.setForeground(new java.awt.Color(204, 204, 204));
        txtViernes.setText("Ingrese las horas de inicio");
        txtViernes.setToolTipText("");
        txtViernes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtViernes.setOpaque(true);
        txtViernes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtViernesMousePressed(evt);
            }
        });
        pnlFondo.add(txtViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, 260, -1));

        txtJueves.setForeground(new java.awt.Color(204, 204, 204));
        txtJueves.setText("Ingrese las horas de inicio");
        txtJueves.setToolTipText("");
        txtJueves.setCaretColor(new java.awt.Color(0, 51, 51));
        txtJueves.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtJueves.setOpaque(true);
        txtJueves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtJuevesMousePressed(evt);
            }
        });
        pnlFondo.add(txtJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 720, 250, -1));

        txtSabado.setForeground(new java.awt.Color(204, 204, 204));
        txtSabado.setText("Ingrese las horas de inicio");
        txtSabado.setToolTipText("");
        txtSabado.setCaretColor(new java.awt.Color(0, 51, 51));
        txtSabado.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtSabado.setOpaque(true);
        txtSabado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSabadoMousePressed(evt);
            }
        });
        pnlFondo.add(txtSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 640, 260, -1));

        txtDomingo.setForeground(new java.awt.Color(204, 204, 204));
        txtDomingo.setText("Ingrese las horas de inicio");
        txtDomingo.setToolTipText("");
        txtDomingo.setCaretColor(new java.awt.Color(0, 51, 51));
        txtDomingo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtDomingo.setOpaque(true);
        txtDomingo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDomingoMousePressed(evt);
            }
        });
        pnlFondo.add(txtDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 690, 250, -1));

        txtLunes.setForeground(new java.awt.Color(204, 204, 204));
        txtLunes.setText("Ingrese las horas de inicio");
        txtLunes.setToolTipText("");
        txtLunes.setCaretColor(new java.awt.Color(0, 51, 51));
        txtLunes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtLunes.setOpaque(true);
        txtLunes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLunesMousePressed(evt);
            }
        });
        pnlFondo.add(txtLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 250, -1));

        txtMartes.setForeground(new java.awt.Color(204, 204, 204));
        txtMartes.setText("Ingrese las horas de inicio");
        txtMartes.setToolTipText("");
        txtMartes.setCaretColor(new java.awt.Color(0, 51, 51));
        txtMartes.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtMartes.setOpaque(true);
        txtMartes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMartesMousePressed(evt);
            }
        });
        pnlFondo.add(txtMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 250, -1));

        txtMiercoles.setForeground(new java.awt.Color(204, 204, 204));
        txtMiercoles.setText("Ingrese las horas de inicio");
        txtMiercoles.setToolTipText("");
        txtMiercoles.setCaretColor(new java.awt.Color(0, 51, 51));
        txtMiercoles.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        txtMiercoles.setOpaque(true);
        txtMiercoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMiercolesMousePressed(evt);
            }
        });
        pnlFondo.add(txtMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 670, 250, -1));

        pnlGuardar.setBackground(new java.awt.Color(255, 255, 255));
        pnlGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        pnlGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        lblGuardar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblGuardar.setText("Guardar");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N

        javax.swing.GroupLayout pnlGuardarLayout = new javax.swing.GroupLayout(pnlGuardar);
        pnlGuardar.setLayout(pnlGuardarLayout);
        pnlGuardarLayout.setHorizontalGroup(
            pnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGuardarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGuardar)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlGuardarLayout.setVerticalGroup(
            pnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGuardarLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(pnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblGuardar))
                .addContainerGap())
        );

        pnlFondo.add(pnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 770, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pajaros.png"))); // NOI18N
        pnlFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbol2.png"))); // NOI18N
        pnlFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 640, 240, 190));

        pnlVaciarDatos.setBackground(new java.awt.Color(255, 255, 153));
        pnlVaciarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        lblVaciarDatos.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblVaciarDatos.setText("Vaciar Datos");
        pnlVaciarDatos.add(lblVaciarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        lblVaciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        pnlVaciarDatos.add(lblVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, -1, -1));

        lblUnderline.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblUnderline.setText("____________");
        pnlVaciarDatos.add(lblUnderline, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, -1));

        pnlFondo.add(pnlVaciarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 770, 140, 40));

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
        establecerTextField(txtDuracion, "", Color.BLACK);
    }//GEN-LAST:event_txtDuracionMousePressed
    /**
     * Método que al presionar txtLongitud ejecuta el método
     * establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtLongitudMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLongitudMousePressed
        establecerTextField(txtLongitud, "", Color.BLACK);
    }//GEN-LAST:event_txtLongitudMousePressed
    /**
     * Método que al presionar txtNoVisitantes ejecuta el método
     * establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtNoVisitantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNoVisitantesMousePressed
        establecerTextField(txtNoVisitantes, "", Color.BLACK);
    }//GEN-LAST:event_txtNoVisitantesMousePressed
    /**
     * Método que al presionar txtNombre ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        establecerTextField(txtNombre, "", Color.BLACK);
    }//GEN-LAST:event_txtNombreMousePressed
    /**
     * Método que al presionar txtViernes ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtViernesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtViernesMousePressed
        establecerTextField(txtViernes, "", Color.BLACK);
    }//GEN-LAST:event_txtViernesMousePressed
    /**
     * Método que al presionar txtSabado ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtSabadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSabadoMousePressed
        establecerTextField(txtSabado, "", Color.BLACK);
    }//GEN-LAST:event_txtSabadoMousePressed
    /**
     * Método que al presionar txtDomingo ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtDomingoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDomingoMousePressed
        establecerTextField(txtDomingo, "", Color.BLACK);
    }//GEN-LAST:event_txtDomingoMousePressed
    /**
     * Método que al presionar txtLunes ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtLunesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLunesMousePressed
        establecerTextField(txtLunes, "", Color.BLACK);
    }//GEN-LAST:event_txtLunesMousePressed
    /**
     * Método que al presionar txtJueves ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtJuevesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJuevesMousePressed
        establecerTextField(txtJueves, "", Color.BLACK);
    }//GEN-LAST:event_txtJuevesMousePressed
    /**
     * Método que al presionar txtMartes ejecuta el método establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtMartesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMartesMousePressed
        establecerTextField(txtMartes, "", Color.BLACK);
    }//GEN-LAST:event_txtMartesMousePressed
    /**
     * Método que al presionar txtMiercoles ejecuta el método
     * establecerTextField.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void txtMiercolesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMiercolesMousePressed
        establecerTextField(txtMiercoles, "", Color.BLACK);
    }//GEN-LAST:event_txtMiercolesMousePressed

    private void pnlGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGuardarMouseClicked
    // TODO add your handling code here:
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.itson.utils.CheckBoxCustom cbDomingo;
    private org.itson.utils.CheckBoxCustom cbJueves;
    private org.itson.utils.CheckBoxCustom cbLunes;
    private org.itson.utils.CheckBoxCustom cbMartes;
    private org.itson.utils.CheckBoxCustom cbMiercoles;
    private org.itson.utils.CheckBoxCustom cbSabado;
    private org.itson.utils.CheckBoxCustom cbViernes;
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
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblDomingo;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblGuardar;
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
