/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laberinto.model;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Paula
 */
public class Enemigo implements Runnable {

    private int x;
    private int y;
    private final int tamaño = 25; // Tamaño del personaje

    private Random random = new Random();
    private int[][] laberinto;  // Referencia al laberinto para verificar movimientos válidos

    private ImageIcon personajePrincipal;

    public Enemigo(int x, int y, int[][] laberinto) {
        this.x = x;
        this.y = y;
        this.laberinto = laberinto;

        personajePrincipal = new ImageIcon("./src/main/resources/images/PersonajeEnemigo.gif");
    }

    @Override
    public void run() {
        while (true) {
            movAleatorio(laberinto);
            try {
                // Hacer una pausa aleatoria entre 1 y 3 segundos (1000 ms - 3000 ms)
                Thread.sleep(random.nextInt(400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void movAleatorio(int[][] laberinto) {
        int mover = random.nextInt(4);
        switch (mover) {
            case 0:  // Mover arriba
                if (y > 0 && laberinto[y - 1][x] == 0) {
                    y--;
                }
                break;

            case 1: // Mover abajo
                if (y < laberinto.length - 1 && laberinto[y + 1][x] == 0) {
                    y++;
                }
                break;

            case 2: // Mover izquierda
                if (x > 0 && laberinto[y][x - 1] == 0) {  // Corrige la condición de límite
                    x--;
                }
                break;

            case 3: // Mover derecha
                if (x < laberinto[0].length - 1 && laberinto[y][x + 1] == 0) {
                    x++;
                }
                break;
        }
    }

    public int getMovX() {
        return x;
    }

    public void setMovX(int x) {
        this.x = x;
    }

    public int getMovY() {
        return y;
    }

    public void setMovY(int y) {
        this.y = y;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    
    // Dibuja el personaje como imagen en la pantalla
    public void dibujar(Graphics g) {
        g.drawImage(personajePrincipal.getImage(), x * tamaño, y * tamaño, tamaño, tamaño, null); 
    }
}
