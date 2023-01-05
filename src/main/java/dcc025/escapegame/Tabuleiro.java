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
        int n = 0;
        int i = 0;

        //Deslocamento para direita
        if (direcao.equals("d")) {
            n = getpY();
            i = getpY();
            while (n < deslocamento + i) {
                if (Tabuleiro.tabuleiro[getpX()][n].equals(" B ")) {
                    Tabuleiro.tabuleiro[getpX()][n] = " X ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpY(n);
                    return;
                } else if (Tabuleiro.tabuleiro[getpX()][n].equals(" S ")) {
                    Tabuleiro.tabuleiro[getpX()][n] = " -- ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpY(n);
                    return;
                }
                n++;
            }
            if (Tabuleiro.tabuleiro[getpX()][i + deslocamento].equals("   ")) {

                Tabuleiro.tabuleiro[getpX()][i + deslocamento] = " P ";
                Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                setpY(i + deslocamento);
            }
        } else if (direcao.equals("e")) { //Deslocamento para esquerda
            n = getpY();
            i = getpY();
            while (n > i - deslocamento) {
                if (Tabuleiro.tabuleiro[getpX()][n].equals(" B ")) {
                    Tabuleiro.tabuleiro[getpX()][n] = " X ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpY(n);
                    return;
                } else if (Tabuleiro.tabuleiro[getpX()][n].equals(" S ")) {
                    Tabuleiro.tabuleiro[getpX()][n] = " -- ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpY(n);
                    return;
                }
                n--;
            }
            Tabuleiro.tabuleiro[getpX()][i - deslocamento] = " P ";
            Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
            setpY(i - deslocamento);
        } else if (direcao.equals("c")) {
            n = getpX();
            while (n > getpX() - deslocamento) {
                if (Tabuleiro.tabuleiro[n][getpY()].equals(" B ")) {
                    Tabuleiro.tabuleiro[n][getpY()] = " X ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpX(n);
                    break;
                } else if (Tabuleiro.tabuleiro[n][getpY()].equals(" S ")) {
                    Tabuleiro.tabuleiro[n][getpY()] = " -- ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpX(n);
                    break;
                } else {
                    Tabuleiro.tabuleiro[n][getpY()] = " P ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpX(n);
                }
                n--;
            }
        } else {
            n = getpX();
            while (n < deslocamento) {
                if (Tabuleiro.tabuleiro[n][getpY()].equals(" B ")) {
                    Tabuleiro.tabuleiro[n][getpY()] = " X ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpX(n);
                    break;
                } else if (Tabuleiro.tabuleiro[n][getpY()].equals(" S ")) {
                    Tabuleiro.tabuleiro[n][getpY()] = " -- ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpX(n);
                    break;
                } else {
                    Tabuleiro.tabuleiro[n][getpY()] = " P ";
                    Tabuleiro.tabuleiro[getpX()][getpY()] = "   ";
                    setpX(n);
                }
                n++;
            }
        }

    }

    public boolean fimDejogo() {
        switch (Tabuleiro.tabuleiro[getpX()][getpX()]) {
            case " P ":
                return false;
            case " X ":
                System.out.println("Game Over!");
                break;
            case " S ":
                System.out.println("Parabéns!");
                break;
        }
        System.out.println("Jogadas realizadas: ");
        for (String jogadasFeitas : jogadasRealizadas) {
            System.out.println(jogadasFeitas);
        }
        return true;
    }
}
