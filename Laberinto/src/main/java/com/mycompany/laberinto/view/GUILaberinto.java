
package com.mycompany.laberinto.view;

import com.mycompany.laberinto.controller.ControladorLaberinto;
import com.mycompany.laberinto.controller.ControladorPrincipal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;


public class GUILaberinto extends javax.swing.JFrame {
    boolean teclaActivada=false;
    private ControladorLaberinto controladorLaberinto; 
    private PanelLaberinto panelLaberinto;
    private ControladorPrincipal controlador;
    private GUIPrincipal guiPrincipal;
    
    private Thread hiloDeRepaint;
    
    
    private Thread hiloTemporizador;
    private int tiempoRestante;
    public GUILaberinto(ControladorPrincipal controlador, GUIPrincipal guiPrincipal) {
        initComponents();
        this.controlador = controlador;
        this.guiPrincipal = guiPrincipal;
        this.controladorLaberinto=new ControladorLaberinto();
        
        panelLaberinto = new PanelLaberinto(controlador, guiPrincipal,controladorLaberinto);
        add(panelLaberinto);

        setTitle("Golden Rays");
        setSize(815, 638);
        setLocationRelativeTo(null);
        setResizable(false);

        panelLaberinto.setSize(815, 638);

        
        // Añadir el KeyListener correctamente
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setFocusable(true);  // Asegúrate de que el JFrame pueda recibir el foco de teclado
        requestFocusInWindow();  // Esto asegura que el JFrame reciba el foco inmediatamente
        
        iniciarHiloEnemigo();
        
        iniciarTemporizador();
        
        tiempoRestante = 60; // Tiempo en segundos

        lblPuntaje.setText(String.valueOf(controladorLaberinto.getPuntaje()));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTerminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblTemp = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        btnTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnTerminar.png"))); // NOI18N
        btnTerminar.setText("btnTerminar");
        btnTerminar.setBorderPainted(false);
        btnTerminar.setContentAreaFilled(false);
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnRegresar.png"))); // NOI18N
        btnRegresar.setText("btnRegresar");
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblTemp.setBackground(new java.awt.Color(255, 0, 0));
        lblTemp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTemp.setForeground(new java.awt.Color(255, 255, 255));

        lblPuntaje.setBackground(new java.awt.Color(255, 0, 0));
        lblPuntaje.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPuntaje.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(491, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(lblTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void iniciarTemporizador() {
        hiloTemporizador = new Thread(()->{
        while (tiempoRestante > 0) {
            try {
                Thread.sleep(1000); // Espera 1 segundo
                tiempoRestante--; // Reduce el tiempo restante en 1 segundo
                lblTemp.setText("Tiempo: " + tiempoRestante + "s"); // Actualiza la etiqueta
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restablece el estado de interrupción
                break;
            }
        }
        ////Revisar: por que no termina el tiempo a los 50/////
        
        // Aquí puedes agregar cualquier acción cuando el tiempo llegue a 0
        if (tiempoRestante == 50) {
            JOptionPane.showMessageDialog(null, "TIEMPO AGOTADO!");
            terminarJuego();
        }
        }); // Pasa esta instancia como Runnable
        hiloTemporizador.start();
    }

    
    public PanelLaberinto getPanelLaberinto() {
        return panelLaberinto;
    }
    
    private void iniciarHiloEnemigo() {
        hiloDeRepaint = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    controladorLaberinto.getEnemigo().movAleatorio(controladorLaberinto.getMatriz().getLaberinto());
                    repaint();  // Actualiza visualización
                    if (controladorLaberinto.getPuntaje()==0){
                        Thread.sleep(600);
                    }
                    else if(controladorLaberinto.getPuntaje()==10){
                        Thread.sleep(400);
                    }
                    else if(controladorLaberinto.getPuntaje()==20){
                        Thread.sleep(100);
                    }
                    
                    
                    else{
                        Thread.sleep(50);
                    }

                    if (controladorLaberinto.getMatriz().hayContacto()) {
                        JOptionPane.showMessageDialog(this, "HAZ PERDIDO.");
                        controladorLaberinto.resetPuntaje();
                        terminarJuego();
                        break;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        hiloDeRepaint.start();
    }
    
    private void terminarJuego() {
        if (hiloDeRepaint != null && hiloDeRepaint.isAlive()) {
            hiloDeRepaint.interrupt(); 
        }
        if(hiloTemporizador!=null && hiloTemporizador.isAlive()){
            hiloTemporizador.interrupt();
        }
        controlador.mostrarGUIPrincipal();
        this.dispose();
    }
    
    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        controlador.mostrarGUIPrincipal();
        this.setVisible(false);
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        controlador.mostrarGUIPrincipal();
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (!teclaActivada){
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    controladorLaberinto.getPersonaje().mover("ARRIBA", controladorLaberinto.getMatriz());
                    teclaActivada=true;
                    break;
                case KeyEvent.VK_DOWN:

                    controladorLaberinto.getPersonaje().mover("ABAJO", controladorLaberinto.getMatriz());
                    teclaActivada=true;
                    
                    if(controladorLaberinto.getPersonaje().getY()==23 && (controladorLaberinto.getPersonaje().getX()==11 || controladorLaberinto.getPersonaje().getX()==12)){
                        JOptionPane.showMessageDialog(this, "¡FELICIDADES, HAZ GANADO!");
                        controladorLaberinto.aumentarPuntaje();
                        terminarJuego(); // Cerrar juego
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    controladorLaberinto.getPersonaje().mover("IZQUIERDA", controladorLaberinto.getMatriz());
                    teclaActivada=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    controladorLaberinto.getPersonaje().mover("DERECHA", controladorLaberinto.getMatriz());
                    teclaActivada=true;
                    break;
            }
            repaint(); // Redibuja el panel después de mover al personaje
        }
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        teclaActivada=false;        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblTemp;
    // End of variables declaration//GEN-END:variables
}
