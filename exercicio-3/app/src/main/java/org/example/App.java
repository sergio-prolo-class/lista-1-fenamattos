package org.example;

import java.util.Random;

public class App {

    char[][] tabuleiro = new char[10][10];
    Random random = new Random();

    public static void main(String[] args) {
        App jogo = new App(); // segue a lista abaixo
        jogo.iniciarTabuleiro();
        jogo.posicionarNavio(5, 'P'); // porta aviões
        jogo.posicionarNavio(4, 'E'); // encouraçado
        jogo.posicionarNavio(3, 'C'); // cruzador
        jogo.posicionarNavio(3, 'S'); // submarino
        jogo.posicionarNavio(2, 'N'); // contratorpedeiro
        jogo.imprimirTabuleiro();
    }

    public void iniciarTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiro[i][j] = '.';
            } // vai iniciar o tabuleiro
        }
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        } // apresenta o resultado
    }

    public void posicionarNavio(int tamanho, char simbolo) {
        boolean colocado = false; // o usuário escolhe o tamanho e simbolo

        while (!colocado) {
            int linha = random.nextInt(10);
            int coluna = random.nextInt(10);
            boolean horizontal = random.nextBoolean();

            if (podeColocar(linha, coluna, tamanho, horizontal)) {
                for (int i = 0; i < tamanho; i++) {
                    if (horizontal) {
                        tabuleiro[linha][coluna + i] = simbolo;
                    } else {
                        tabuleiro[linha + i][coluna] = simbolo;
                    }
                }
                colocado = true;
            }
        }
    }

    public boolean podeColocar(int linha, int coluna, int tamanho, boolean horizontal) {
        if (horizontal) {
            if (coluna + tamanho > 10) return false;
            for (int i = 0; i < tamanho; i++) {
                if (tabuleiro[linha][coluna + i] != '.') return false;
            }
        } else {
            if (linha + tamanho > 10) return false;
            for (int i = 0; i < tamanho; i++) {
                if (tabuleiro[linha + i][coluna] != '.') return false;
            }
        }
        return true;
    }
}
