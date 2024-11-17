/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.laberinto.controller;

import com.mycompany.laberinto.view.GUIHistoria;
import com.mycompany.laberinto.view.GUIInstrucciones;
import com.mycompany.laberinto.view.GUILaberinto;
import com.mycompany.laberinto.view.GUIPrincipal;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Paula
 */
public class ControladorPrincipal implements ActionListener {

    private GUIPrincipal guiPrincipal;
    private GUIInstrucciones guiInstrucciones;
    private GUIHistoria guiHistoria;
    private GUILaberinto guiLaberinto;

    public ControladorPrincipal() {
        guiPrincipal = new GUIPrincipal(this);
        guiLaberinto = new GUILaberinto(this, guiPrincipal);
        guiInstrucciones = new GUIInstrucciones(this, guiPrincipal);
        guiHistoria = new GUIHistoria(this, guiPrincipal);

        guiLaberinto = new GUILaberinto(this, guiPrincipal);
        guiPrincipal.setVisible(true);

    }

    public void mostrarGUIPrincipal() {
        guiPrincipal.setVisible(true);
    }

    public void dibujar(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnJugar":
                guiLaberinto = new GUILaberinto(this, guiPrincipal);
                guiLaberinto.setVisible(true);
                guiPrincipal.setVisible(false);
                break;

            case "btnInstrucciones":
                guiInstrucciones.setVisible(true);
                guiPrincipal.setVisible(false);
                break;

            case "btnHistoria":
                guiHistoria.setVisible(true);
                guiPrincipal.setVisible(false);
                break;

            /////
            case "btnTerminarJuego":
                guiLaberinto.setVisible(false);
                guiPrincipal.setVisible(true);

                break;

            case "btnSalir":
                System.exit(0);
                break;

        }

    }

}
