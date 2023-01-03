/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package dcc025.escapegame;

/**
 *
 * @author thiago
 */
import java.util.*;

public class EscapeGame {

    public static void main(String[] args) throws OpcaoException {
        System.out.println("################################################");
        System.out.println("                 ESCAPE GAME");
        System.out.println("################################################");
//-------------------------------------------------------------------------------
        Scanner teclado = new Scanner(System.in);
        String opcaoModoJogo = "0";

        System.out.println("Bem vindo ao Escape Game!");
        System.out.println("Escolha o nível de dificuldade: ");
        System.out.println("0 - Fácil\n1 - Médio\n2 - Díficil");
        
        Tabuleiro novoTabuleiro = new TabuleiroFacil();
        
        novoTabuleiro.leJogada();

    }
}
