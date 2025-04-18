package org.example;

public class App { // Valida se os argumentos estão corretos
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: triangulo <tamanho> | losango <tamanho ímpar> | retangulo <altura> <largura>");
            return; // caso os argumentos não estiverem corretos o programa se encerra
        }

        String forma = args[0]; // forma desejada (triangulo, losango ou quadrado)

        if (forma.equals("triangulo")) {
            int tamanho = Integer.parseInt(args[1]); // altura da forma desejada
            for (int i = 1; i <= tamanho; i++) { // aqui percebemos a lógica do processo, onde entramos com um loop para cada linha da forma, nesse caso o triangulo
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println(); // faz pular para a proxima linha
            }
        } else if (forma.equals("losango")) { // valida se é a forma escolhida
            int tamanho = Integer.parseInt(args[1]); // altura da figura geometrica
            if (tamanho % 2 == 0) {
                System.out.println("Escreva a altura do losango, tem que ser um numero impar");
                return;
            }
            int meio = tamanho / 2; // calcula da ponta ate o meio do losango
            for (int i = 0; i <= meio; i++) { // aqui mostra a parte de cima ate o meio
                System.out.print(" ".repeat(meio - i));
                System.out.println("*".repeat(i * 2 + 1));
            }
            for (int i = meio - 1; i >= 0; i--) { // parte de baixo da figura
                System.out.print(" ".repeat(meio - i));
                System.out.println("*".repeat(i * 2 + 1));
            }
        } else if (forma.equals("retangulo")) { // valida se foi encaminhada a altura e a largura do ratangulo
            if (args.length < 3) {
                System.out.println("Entre com altura e largura por favor");
                return;
            }
            int altura = Integer.parseInt(args[1]); // converte a altura do retangulo e a largura logo abaixo
            int largura = Integer.parseInt(args[2]);

            for (int i = 0; i < altura; i++) { // aqui percebemos o loop para formar a figura
                for (int j = 0; j < largura; j++) {
                    if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else { // usado para garantir que vamos ter como entrada uma forma geometrica valida com as que temos
            System.out.println("Use as formas existentes: triangulo, losango, retangulo");
        }
    }
}
