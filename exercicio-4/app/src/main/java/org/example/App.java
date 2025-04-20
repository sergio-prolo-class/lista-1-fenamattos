package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        char[][] tabuleiro = new char[10][10];
        int linhaAtual = 0;

        // Contadores de navios
        int portaAvioes = 0;
        int navioTanque = 0;
        int contratorpedeiro = 0;
        int submarino = 0;
        int tropa = 0;

        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                if (linhaAtual >= 10) {
                    System.out.println("Erro: o tabuleiro tem mais de 10 linhas.");
                    return;
                }

                if (linha.length() != 10) {
                    System.out.println("Erro: a linha " + (linhaAtual + 1) + " não tem 10 colunas.");
                    return;
                }

                for (int i = 0; i < 10; i++) {
                    char c = linha.charAt(i);
                    tabuleiro[linhaAtual][i] = c;

                    if (c == 'P') {
                        portaAvioes++;
                    } else if (c == 'N') {
                        navioTanque++;
                    } else if (c == 'C') {
                        contratorpedeiro++;
                    } else if (c == 'S') {
                        submarino++;
                    } else if (c == 'T') {
                        tropa++;
                    } else if (c != '.') {
                        System.out.println("Erro: navio desconhecido '" + c + "'.");
                        return;
                    }
                }

                linhaAtual++;
            }

            if (linhaAtual != 10) {
                System.out.println("Erro: o tabuleiro tem menos de 10 linhas.");
                return;
            }

            // Verificar se há exatamente um de cada tipo
            if (portaAvioes == 0) {
                System.out.println("Erro: falta o navio Porta-Aviões.");
                return;
            } else if (portaAvioes > 5) {
                System.out.println("Erro: múltiplos Porta-Aviões.");
                return;
            }

            if (navioTanque == 0) {
                System.out.println("Erro: falta o Navio-Tanque.");
                return;
            } else if (navioTanque > 4) {
                System.out.println("Erro: múltiplos Navios-Tanque.");
                return;
            }

            if (contratorpedeiro == 0) {
                System.out.println("Erro: falta o Contratorpedeiro.");
                return;
            } else if (contratorpedeiro > 3) {
                System.out.println("Erro: múltiplos Contratorpedeiros.");
                return;
            }

            if (submarino == 0) {
                System.out.println("Erro: falta o Submarino.");
                return;
            } else if (submarino > 3) {
                System.out.println("Erro: múltiplos Submarinos.");
                return;
            }

            if (tropa == 0) {
                System.out.println("Erro: falta a Tropa.");
                return;
            } else if (tropa > 2) {
                System.out.println("Erro: múltiplas Tropas.");
                return;
            }

            System.out.println("Tabuleiro válido");

        } catch (Exception e) {
            System.out.println("Erro ao ler o tabuleiro.");
        }
    }
}
