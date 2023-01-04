/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.escapegame;

import java.util.*;

/**
 *
 * @author thiago
 */
public abstract class Tabuleiro {

    private static String tabuleiro[][] = new String[10][10];
    List<String> jogadasRealizadas;
    Random numAleatorio = new Random();
    int numBombas;
    private static int pX;
    private static int pY;
    private static int linha;
    private static int coluna;

    public static int getpX() {
        return pX;
    }

    public static void setpX(int pX) {
        Tabuleiro.pX = pX;
    }

    public static int getpY() {
        return pY;
    }

    public static void setpY(int pY) {
        Tabuleiro.pY = pY;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        Tabuleiro.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        Tabuleiro.coluna = coluna;
    }

    public int sortearPosicoes(int min, int max) {
        return this.numAleatorio.nextInt(min, max);
    }

    public void InicializarTabuleiro() {
        //Inicializa o tabuleiro
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Tabuleiro.tabuleiro[i][j] = "   ";
            }
        }
        Tabuleiro.tabuleiro[0][0] = " P ";
        //localização do P
        setpX(0);
        setpY(0);
        Tabuleiro.linha = sortearPosicoes(1, 10);
        Tabuleiro.coluna = sortearPosicoes(0, 10);
        Tabuleiro.tabuleiro[getLinha()][getColuna()] = " S ";
        //----------------------------------------------------------------------
        //Adiciona as bombas
        int cont = 0;
        do {
            setLinha(sortearPosicoes(0, 10));
            setColuna(sortearPosicoes(0, 10));

            if (this.tabuleiro[getLinha()][getColuna()].equals("   ")) {
                this.tabuleiro[linha][coluna] = " B ";
                cont++;
            }

        } while (cont < this.numBombas);
    }

    public void imprimirSemBombas() {
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            for (int j = 0; j < 10; j++) {
                if (Tabuleiro.tabuleiro[i][j].equals(" P ")) {
                    System.out.print(Tabuleiro.tabuleiro[i][j] + "|");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println("");
        }
    }

    public void imprimir() {
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            for (int j = 0; j < 10; j++) {
                System.out.print(Tabuleiro.tabuleiro[i][j] + "|");
            }
            System.out.println("");
        }
    }

    public void inserirJogada(String[] jogada) {
        this.jogadasRealizadas.add("(" + jogada[0] + ", " + jogada[1] + ")");
        String direcao = jogada[0];
        int deslocamento = Integer.parseInt(jogada[1]);
        int posicaoD = 0;
        
        
       

    }
    

    public boolean fimDejogo(String s) {
        return s.equals(" B ") || s.equals("S");
    }
}
