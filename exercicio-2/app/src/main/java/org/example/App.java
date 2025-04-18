package org.example;

public class App {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) { // valida se tivemos 3  ou 4 entradas, 3 são obrigatórias e 4 opicional
            System.out.println("Uso: <cor1> <cor2> <multiplicador> [tolerancia]");
            return; // se a entrada for menos de 3, se encerra o programa
        }

        String[] cores = { // essas são as cores válidas
                "preto", "marrom", "vermelho", "laranja", "amarelo",
                "verde", "azul", "violeta", "cinza", "branco"
        };
// essa parte serve para armazenar as entradas
        String cor1 = args[0]; // representa a primeira faixa de cor do resistor e assim por diante
        String cor2 = args[1];
        String mult = args[2];
        String tol = args.length == 4 ? args[3] : ""; // isso é para a tolerancia (é uma parte opcional)

// aqui apresentamos variáveis para armazenar os valores para as respectivas cores das faixas do resistor
        int d1 = -1, d2 = -1;
        double multiplicador = -1;
        String tolerancia = "20%";

        // procurando os valores da primeira e segunda cor
        for (int i = 0; i < cores.length; i++) {
            if (cor1.equals(cores[i])) d1 = i;
            if (cor2.equals(cores[i])) d2 = i;
        }

        // Define o valor que vai ser multiplicado dependendo de cada cor de entrada
        switch (mult) {
            case "preto": multiplicador = 1; break;
            case "marrom": multiplicador = 10; break;
            case "vermelho": multiplicador = 100; break;
            case "laranja": multiplicador = 1000; break;
            case "amarelo": multiplicador = 10000; break;
            case "verde": multiplicador = 100000; break;
            case "azul": multiplicador = 1000000; break;
            case "violeta": multiplicador = 10000000; break;
            case "cinza": multiplicador = 100000000; break;
            case "branco": multiplicador = 1000000000; break;
            case "dourado": multiplicador = 0.1; break;
            case "prata": multiplicador = 0.01; break;
        }

        // tolerância
        if (!tol.equals("")) {
            switch (tol) {
                case "marrom": tolerancia = "1%"; break;
                case "vermelho": tolerancia = "2%"; break;
                case "verde": tolerancia = "0,5%"; break;
                case "azul": tolerancia = "0,25%"; break;
                case "violeta": tolerancia = "0,1%"; break;
                case "cinza": tolerancia = "0,05%"; break;
                case "dourado": tolerancia = "5%"; break;
                case "prata": tolerancia = "10%"; break;
                default: tolerancia = "20%";
            }
        }

        // se alguma cor for inválida
        if (d1 == -1 || d2 == -1 || multiplicador == -1) {
            System.out.println("Cor inválida. Verifique as cores digitadas.");
            return;
        }

        double resistencia = (d1 * 10 + d2) * multiplicador;

        String resultado = formatarResistencia(resistencia);
        System.out.println("Resistência: " + resultado + "Ω (+- " + tolerancia + ")");
    }

    public static String formatarResistencia(double valor) {
        if (valor >= 1_000_000_000) return String.format("%.1fG", valor / 1_000_000_000);
        if (valor >= 1_000_000) return String.format("%.1fM", valor / 1_000_000);
        if (valor >= 1000) return String.format("%.1fK", valor / 1000);
        return String.format("%.1f", valor);
    }
}

