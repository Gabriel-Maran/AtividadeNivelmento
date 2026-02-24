package desafio;

import java.util.Scanner;

public class Desafios {
    private final Scanner scan = new Scanner(System.in);

    public void desafio01() {
        System.out.println("Digite seu nome");
        String nome = scan.nextLine();
        System.out.println("Bem vindo " + nome + "!");
    }

    public void desafio02() {
        System.out.println("Digite o primeiro número");
        int num1 = scan.nextInt();
        System.out.println("Digite o segundo número");
        int num2 = scan.nextInt();
        int escolha = 0;
        do {
            System.out.println("""
                    Escolha a operação desejada:
                    - Digite 1 para adição
                    - Digite 2 para subtração
                    - Digite 3 para multiplicação
                    - Digite 4 para divisão
                    """);
            escolha = scan.nextInt();
        } while (escolha <= 0 || escolha > 4);
        switch (escolha) {
            case 1:
                System.out.println(num1 + num2);
                break;
            case 2:
                System.out.println(num1 - num2);
                break;
            case 3:
                System.out.println(num1 * num2);
                break;
            case 4:
                System.out.println(num1 / num2);
                break;
        }
    }

    public void desafio03() {
        int escolha = 0;
        while (escolha != 5) {
            System.out.println("""
                    Escolha o que deseja acessar:
                    - 1 para Compra
                    - 2 para Venda
                    - 3 para Estoque
                    - 4 para Financeiro
                    - 5 sair
                    """);
            escolha = scan.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Entrando em Compra...");
                    break;
                case 2:
                    System.out.println("Entrando em Venda...");
                    break;
                case 3:
                    System.out.println("Entrando no Estoque...");
                    break;
                case 4:
                    System.out.println("Entrando no Financeiro...");
                    break;
                case 5:
                    System.out.println("Sainda...");
            }
        }

    }
}
