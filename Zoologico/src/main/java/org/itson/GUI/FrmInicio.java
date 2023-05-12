/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 * Clase encargada de la ventana Inicio.
 *
 * @author Magda Ramírez - 233523
 */
public class FrmInicio extends javax.swing.JFrame {

    int xMouse, yMouse;

    /**
     * Método que crea FrmInicio.
     */
    public FrmInicio() {
        initComponents();
        ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\paw.png");
        this.setIconImage(icon.getImage());
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Maximiza el tamaño de la ventana
        // this.getContentPane().setBackground(Color.getHSBColor(55, 15, 195)); //Da color al fondo

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlMapa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlAdministraritinerario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(255, 255, 153));
        pnlFondo.setPreferredSize(new java.awt.Dimension(970, 551));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMapa.setBackground(new java.awt.Color(255, 255, 255));
        pnlMapa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mapa.png"))); // NOI18N
        pnlMapa.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 21, -1, -1));

        pnlFondo.add(pnlMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 550));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalirLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lblSalir)
                .addGap(17, 17, 17))
        );
        pnlSalirLayout.setVerticalGroup(
            pnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSalir)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pnlFondo.add(pnlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 50, 40));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        pnlHeader.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlHeader.add(jPanel1);

        pnlFondo.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 40));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("¡Bienvenido, Guía!");
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        pnlAdministraritinerario.setBackground(new java.awt.Color(255, 255, 255));
        pnlAdministraritinerario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        pnlAdministraritinerario.setToolTipText("");
        pnlAdministraritinerario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlAdministraritinerario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAdministraritinerarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlAdministraritinerarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlAdministraritinerarioMouseExited(evt);
            }
        });
        pnlAdministraritinerario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel3.setText("Administrar Itinerarios");
        pnlAdministraritinerario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 86, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/itinerario (1).png"))); // NOI18N
        pnlAdministraritinerario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 16, -1, -1));

        pnlFondo.add(pnlAdministraritinerario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 250, 130));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 50)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("MAGIC ZOO");
        pnlFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rasgunio.png"))); // NOI18N
        pnlFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que al presionar el mouse permita obtener eventos.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

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
     * Método que permite que al hacerle clic a pnlSalir termine el programa.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_pnlSalirMouseClicked
    /**
     * Método que permite cambiar el color de fondo del pnlSalir y el color de
     * su ícono.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseEntered
        pnlSalir.setBackground(Color.red);
        lblSalir.setForeground(Color.white);
    }//GEN-LAST:event_pnlSalirMouseEntered
    /**
     * Método que permite que al quitar el mouse pnlSalir, regrese al color de
     * fondo y al color del icono originales.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSalirMouseExited
        pnlSalir.setBackground(new Color(255, 255, 153));
        lblSalir.setForeground(new Color(102, 0, 0));
    }//GEN-LAST:event_pnlSalirMouseExited

    /**
     * Método que permite cambiar el grosor del borde de
     * pnlAdministrarItinerario y el color de su fondo.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlAdministraritinerarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAdministraritinerarioMouseEntered
        pnlAdministraritinerario.setBackground(new Color(245, 245, 245));
        pnlAdministraritinerario.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 0), 3));
    }//GEN-LAST:event_pnlAdministraritinerarioMouseEntered
    /**
     * Método que permite que al quitar el mouse pnlAdministrarItinerario,
     * regrese al grosor del borde y al color de su fondo originales.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlAdministraritinerarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAdministraritinerarioMouseExited
        pnlAdministraritinerario.setBackground(Color.WHITE);
        pnlAdministraritinerario.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 0), 1));
    }//GEN-LAST:event_pnlAdministraritinerarioMouseExited

    /**
     * Método que permite que al hacerle clic a pnlAdministraritinerario abra la
     * ventana de Itinerarios.
     *
     * @param evt objeto de evento de acción.
     */
    private void pnlAdministraritinerarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAdministraritinerarioMouseClicked
        FrmItinerarios frmItinerarios = new FrmItinerarios();
        frmItinerarios.setVisible(true);
        dispose();
    }//GEN-LAST:event_pnlAdministraritinerarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel pnlAdministraritinerario;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMapa;
    private javax.swing.JPanel pnlSalir;
    // End of variables declaration//GEN-END:variables
}
