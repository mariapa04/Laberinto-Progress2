/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberinto.model;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Paula
 */
public class Personaje {

    private int x, y;
    private final int tamaño = 25; // Tamaño del personaje

    private ImageIcon personajePrincipal;

    public Personaje(int x, int y) {
        this.x = x;
        this.y = y;

        personajePrincipal = new ImageIcon("./src/main/resources/images/PersonajePrincipal.gif");
    }

    // Función para mover el personaje
    public void mover(String direccion, Laberinto laberinto) {

        switch (direccion) {

            case "ARRIBA":
                if (laberinto.puedeMover(x, y - 1)) {
                    y--; // Verifica si puede moverse arriba
                }
                break;
            case "ABAJO":
                if (laberinto.puedeMover(x, y + 1)) {
                    y++; // Verifica si puede moverse abajo
                }
                break;
            case "IZQUIERDA":
                if (laberinto.puedeMover(x - 1, y)) {
                    x--; // Verifica si puede moverse izquierda
                }
                break;
            case "DERECHA":
                if (laberinto.puedeMover(x + 1, y)) {
                    x++; // Verifica si puede moverse derecha
                }
                break;
        }
    }

 
    
     // Dibuja el personaje como imagen en la pantalla
    public void dibujar(Graphics g) {
        g.drawImage(personajePrincipal.getImage(), x * tamaño, y * tamaño, tamaño, tamaño, null); 
    }

    // Get de atributos
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
