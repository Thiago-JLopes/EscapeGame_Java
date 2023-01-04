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

    public static void main(String[] args) {
        System.out.println("################################################");
        System.out.println("                 ESCAPE GAME");
        System.out.println("################################################");
//-------------------------------------------------------------------------------
        Scanner teclado = new Scanner(System.in);
        String opcaoModoJogo = "0";
        Tabuleiro novoTabuleiro;
        System.out.println("Bem vindo ao Escape Game!");
        System.out.println("Escolha o nível de dificuldade: ");
        System.out.println("0 - Fácil\n1 - Médio\n2 - Díficil");

        opcaoModoJogo = teclado.next();
        String jogada[] = new String[2];
        switch (opcaoModoJogo) {
            case "0":
                novoTabuleiro = new TabuleiroFacil();
                novoTabuleiro.InicializarTabuleiro();
                novoTabuleiro.imprimirSemBombas();
                System.out.println("");
                novoTabuleiro.imprimir();
                jogada = leJogada();
                //novoTabuleiro.inserirJogada(jogada);
                break;
            case "1":
                break;
            case "2":
                break;
            default:
                System.out.println("opção inválida!");
                break;
        }

    }

    public static String[] leJogada() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a sua jogada no formato (direção, deslocamento): ");
        String leituraJogada = teclado.nextLine();
        String Jogada[] = leituraJogada.substring(1, leituraJogada.length() - 1).split(", ");

        try {
            validarJogada(Jogada);
        } catch (OpcaoException | NumberFormatException | ArrayIndexException e) {
            System.out.println("Direção e/ou deslocamento inválido!\nJOGUE NOVAMENTE!");
            return leJogada();
        }
        return Jogada;
    }

    private static void validarJogada(String[] Jogada) throws OpcaoException, ArrayIndexException {
        if (!Jogada[0].contains("d") && !Jogada[0].contains("e") && !Jogada[0].contains("b") && !Jogada[0].contains("c")) {
            throw new OpcaoException();
        }
        int desl = 0;

        try {
            desl = Integer.parseInt(Jogada[1]);

            if (desl < 0 || desl > 10) {
                throw new OpcaoException();
            }
        } catch (NumberFormatException | OpcaoException e) {
            throw new NumberFormatException();
        }

        int deslocamento = Integer.parseInt(Jogada[1]);
        switch (Jogada[0]) {
            case "d":
                if (Tabuleiro.getpX() + deslocamento > 9) {
                    throw new ArrayIndexException();
                }
                break;
            case "e":
                if (Tabuleiro.getpX() - deslocamento < 0) {
                    throw new ArrayIndexException();
                }
                break;
            case "c":
                if (Tabuleiro.getpY() - deslocamento < 0) {
                    throw new ArrayIndexException();
                }
                break;
            default:
                if (Tabuleiro.getpY() + deslocamento > 9) {
                    throw new ArrayIndexException();
                }
                break;
        }
    }
}
