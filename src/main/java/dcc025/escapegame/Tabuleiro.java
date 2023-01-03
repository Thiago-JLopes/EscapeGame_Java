/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.escapegame;

import java.util. *;

/**
 *
 * @author thiago
 */
public abstract class Tabuleiro {

    String tabuleiro[][];
    List<String> jogadasRealizadas;
    Random numAleatorio = new Random();
    int numBombas;
    int linha;
    int coluna;
    
    public int sortearPosicoes(int min, int max) {
        return this.numAleatorio.nextInt(min, max);
    }
    
    public void InicializarTabuleiro() {
        //Inicializa o tabuleiro
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; i++) {
                this.tabuleiro[i][j] = " ";
            }
        }
        this.tabuleiro[0][0] = " P ";
        this.linha = sortearPosicoes(1, 10);
        this.coluna = sortearPosicoes(0,10);
        this.tabuleiro[linha][coluna] = "S";
        //----------------------------------------------------------------------
        //Adiciona as bombas
        int cont = 0;
        do {
            this.linha = sortearPosicoes(0, 10);
            this.coluna = sortearPosicoes(0, 10);
            
            if(this.tabuleiro[this.linha][this.coluna].equals(" ")) {
                this.tabuleiro[this.linha][this.coluna] = "B";
                cont++;
            }
        } while(cont < this.numBombas);
    }
    
    public String[] leJogada() throws OpcaoException {
        Scanner teclado = new Scanner(System.in);
         
        System.out.println("Digite a sua jogada no formato (direção, deslocamento): ");
        String leituraJogada = teclado.nextLine();
        String Jogada[] = leituraJogada.substring(1, 5).split(", ");
        
        if(Jogada[0].equals("d") || !Jogada[0].equals("e") || !Jogada[0].equals("c") || !Jogada[0].equals("c") || !Jogada[0].equals("b")) {
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
