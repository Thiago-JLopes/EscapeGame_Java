/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.escapegame;

import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class TabuleiroFacil extends Tabuleiro {

    public TabuleiroFacil() {
        this.numBombas = 12;
        this.jogadasRealizadas = new ArrayList<>();
        this.tabuleiro = new String[10][10];
        
        InicializarTabuleiro();
    }

}
