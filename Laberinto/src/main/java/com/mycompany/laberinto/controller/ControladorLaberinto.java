/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.laberinto.controller;

import com.mycompany.laberinto.model.Enemigo;
import com.mycompany.laberinto.model.Laberinto;
import com.mycompany.laberinto.model.Personaje;
import com.mycompany.laberinto.view.PanelLaberinto;

/**
 *
 * @author Paula
 */
public class ControladorLaberinto {

    private Laberinto matriz;
    private PanelLaberinto panelLaberinto;
    private Enemigo enemigo;
    private Personaje personaje;
    private static int puntaje=0;

    public ControladorLaberinto() {
        this.matriz = new Laberinto();
        this.personaje=matriz.getPersonaje();
        this.enemigo=matriz.getEnemigo();
    }

    public void aumentarPuntaje(){
        puntaje+=10;
    }
    
    public void resetPuntaje(){
        puntaje=0;
    }
    
    public int getPuntaje(){
        return puntaje;
    }
    public Laberinto getMatriz() {
        return matriz;
    }

    public void setMatriz(Laberinto matriz) {
        this.matriz = matriz;
    }

    public PanelLaberinto getPanelLaberinto() {
        return panelLaberinto;
    }

    public void setPanelLaberinto(PanelLaberinto panelLaberinto) {
        this.panelLaberinto = panelLaberinto;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public Personaje getPersonaje() {
        return matriz.getPersonaje();
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = matriz.getPersonaje();
    }

    
}
