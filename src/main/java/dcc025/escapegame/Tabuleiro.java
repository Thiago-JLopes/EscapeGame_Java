/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.escapegame;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author thiago
 */
public abstract class Tabuleiro implements Sorteador {

    static String tabuleiro[][] = new String[10][10];
    static List<String> jogadasRealizadas;
    int numBombas;

    public Tabuleiro(){
    }

    public String[] leJogada() throws OpcaoException {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite a sua jogada no formato (direção, deslocamento): ");
        String leituraJogada = teclado.nextLine();
        String Jogada[] = leituraJogada.substring(1, 5).split(", ");
        
        if(!Jogada[0].equals("d") || !Jogada[0].equals("e") || !Jogada[0].equals("c") || !Jogada[0].equals("c") || !Jogada[0].equals("b")) {
            throw new OpcaoException();
        }
        int dir = Integer.parseInt(Jogada[1]);
        if(dir < 0 || dir > 10) {
            throw new OpcaoException();
        }
        
        return Jogada;
    }   

    public void inserirJogada() {
        System.out.println("Jogada inserida!");

    }
}
