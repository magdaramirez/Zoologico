/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import org.itson.utils.TableActionCellRender;
import org.itson.utils.TableActionCellEditor;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.interfaces.IItinerariosDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;

/**
 * Clase encargada de la ventana Itinerarios.
 *
 * @author Magda Ramírez - 233523
 */
public class FrmItinerarios extends javax.swing.JFrame {

    int xMouse, yMouse;
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

    private IItinerariosDAO persistenciaItinerarios;
    private IHabitatsDAO persistenciaHabitats;

    /**
     * Método que crea FrmItinerarios y establece las configuraciones de diseño
     * de tblitinerarios.
     */
    public FrmItinerarios() {
        initComponents();
        ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\paw.png");
        this.setIconImage(icon.getImage());

        tblitinerarios.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        tblitinerarios.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor());

        tblitinerarios.getTableHeader().setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        tblitinerarios.getTableHeader().setOpaque(false);
        tblitinerarios.getTableHeader().setForeground(new Color(102, 0, 0));
        tblitinerarios.setRowHeight(40);

        llenarTablaItinerarios();
    }

    private void llenarTablaItinerarios() {
        //CONEXIÓN A LA BASE DE DATOS
        ConexionMongoDB conexion = new ConexionMongoDB();
        IItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        //Consultar itinerarios
        List<Itinerario> itinerarios = itinerariosDAO.consultarTodos();

        DefaultTableModel modelo = (DefaultTableModel) this.tblitinerarios.getModel();
        modelo.setRowCount(0);
        for (Itinerario itinerario : itinerarios) {
            Object[] fila = {
                contador++,
                itinerario.getNombre(),
                itinerario.getNoVisitantes()
            };
            modelo.addRow(fila);
        }
    }

    /**
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
    }

    /**
     * Método que regresa a FrmInicio.
     */
    private void regresarVentanaInicio() {
        FrmInicio inicio = new FrmInicio();
        inicio.setVisible(true);
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
     * Método que establece un ícono a un JLabel.
     *
     * @param label JLabel cuyo ícono será establecido.
     * @param icono Ícono a establecer.
     */
    public void cambiarIcono(JLabel label, String icono) {
        label.setIcon(new ImageIcon(icono));
    }

    /**
     * Método que despliega FrmRegistroItinerario.
     */
    public void abrirVentanaRegistro() {
        new FrmRegistroItinerario(this.persistenciaHabitats).setVisible(true);
        dispose();
    }

    /**
     * Método que esteblece el borde de un JPanel.
     *
     * @param panel JPanel cuyo borde va a cambiar.
     * @param border Borde a poner en el panel.
     */
    public void cambiarBordePanel(JPanel panel, Border border) {
        panel.setBorder(border);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblitinerarios = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        pnlSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        pnlRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
        pnlRegistrarItinerario = new javax.swing.JPanel();
        lblRegistrarItinerario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(255, 255, 153));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Itinerarios");
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tblitinerarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblitinerarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nombre", "Duración", "No. Visitantes", "Días", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblitinerarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblitinerarios.setFocusable(false);
        tblitinerarios.setGridColor(new java.awt.Color(153, 153, 153));
        tblitinerarios.setSelectionBackground(new java.awt.Color(221, 192, 192));
        tblitinerarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblitinerarios.setShowHorizontalLines(true);
        tblitinerarios.setShowVerticalLines(true);
        tblitinerarios.getTableHeader().setResizingAllowed(false);
        tblitinerarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblitinerarios);
        if (tblitinerarios.getColumnModel().getColumnCount() > 0) {
            tblitinerarios.getColumnModel().getColumn(0).setResizable(false);
            tblitinerarios.getColumnModel().getColumn(1).setResizable(false);
            tblitinerarios.getColumnModel().getColumn(2).setResizable(false);
            tblitinerarios.getColumnModel().getColumn(3).setResizable(false);
            tblitinerarios.getColumnModel().getColumn(4).setResizable(false);
            tblitinerarios.getColumnModel().getColumn(5).setResizable(false);
        }

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 840, -1));

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

        pnlHeader.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, -1, -1));

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

        pnlFondo.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 40));

        pnlRegistrarItinerario.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegistrarItinerario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        pnlRegistrarItinerario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlRegistrarItinerario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRegistrarItinerarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlRegistrarItinerarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlRegistrarItinerarioMouseExited(evt);
            }
        });

        lblRegistrarItinerario.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblRegistrarItinerario.setText("Registrar Nuevo Itinerario");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N

        javax.swing.GroupLayout pnlRegistrarItinerarioLayout = new javax.swing.GroupLayout(pnlRegistrarItinerario);
        pnlRegistrarItinerario.setLayout(pnlRegistrarItinerarioLayout);
        pnlRegistrarItinerarioLayout.setHorizontalGroup(
            pnlRegistrarItinerarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarItinerarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegistrarItinerario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegistrarItinerarioLayout.setVerticalGroup(
            pnlRegistrarItinerarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarItinerarioLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(pnlRegistrarItinerarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblRegistrarItinerario))
                .addContainerGap())
        );

        pnlFondo.add(pnlRegistrarItinerario, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 250, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/huellas (1).png"))); // NOI18N
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/huellas (1).png"))); // NOI18N
        pnlFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que al arrastrar el mouse permita mover la pantalla.
     *
     * @param evt objeto de evento de acción.
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
     * regresarVentanaInicio.
     *
     * @param evt El evento del mouse que activa el método.
     */
    private void pnlRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegresarMouseClicked
        regresarVentanaInicio();
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

    private void pnlRegistrarItinerarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegistrarItinerarioMouseClicked
        abrirVentanaRegistro();
    }//GEN-LAST:event_pnlRegistrarItinerarioMouseClicked
    /**
     * Método que permite cambiar el grosor del borde de pnlRegistrarItinerario
     * y el color de su fondo.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlRegistrarItinerarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegistrarItinerarioMouseEntered
        cambiarColorPanel(pnlRegistrarItinerario, GRIS);
        cambiarBordePanel(pnlRegistrarItinerario, BorderFactory.createLineBorder(CAFE, BORDE_GRUESO));
    }//GEN-LAST:event_pnlRegistrarItinerarioMouseEntered
    /**
     * Método que permite que al quitar el mouse pnlRegistrarItinerario, regrese
     * al grosor del borde y al color de su fondo originales.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlRegistrarItinerarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRegistrarItinerarioMouseExited
        cambiarColorPanel(pnlRegistrarItinerario, Color.WHITE);
        cambiarBordePanel(pnlRegistrarItinerario, BorderFactory.createLineBorder(CAFE, BORDE_ESTRECHO));
    }//GEN-LAST:event_pnlRegistrarItinerarioMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegistrarItinerario;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlRegistrarItinerario;
    private javax.swing.JPanel pnlRegresar;
    private javax.swing.JPanel pnlSalir;
    private javax.swing.JTable tblitinerarios;
    // End of variables declaration//GEN-END:variables
}
