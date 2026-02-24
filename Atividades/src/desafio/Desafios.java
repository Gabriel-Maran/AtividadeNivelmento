package desafio;

import model.Loja;
import model.Produto;
import service.LojaService;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Desafios {
    private final Scanner scan = new Scanner(System.in);
    private final LojaService lojaService = new LojaService(new Loja());

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
                    ==============================
                    Escolha o que deseja acessar:
                    - 1 para Compra
                    - 2 para Venda
                    - 3 para Estoque
                    - 4 para Financeiro
                    - 5 sair
                    ==============================
                    """);
            escolha = scan.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Entrando em Compra...");
                    lojaService.listarTodosOsProdutos();
                    System.out.println("Digite o id do produto comprado");
                    int id = scan.nextInt();
                    Produto produto = montarProduto();
                    if (lojaService.realizarCompra(id, produto)) {
                        System.out.println("Compra realizada com sucesso");
                    } else {
                        System.out.println("Erro! Não foi possivel conluir a compra");
                    }
                    break;
                case 2:
                    System.out.println("Entrando em Venda...");
                    if (realizarVenda()) {
                        System.out.println("Venda realizada com sucesso");
                    } else {
                        System.out.println("Erro! Não foi possivel conluir a venda");
                    }
                    break;
                case 3:
                    System.out.println("Entrando no Estoque...");
                    lojaService.listarTodosOsProdutos();
                    break;
                case 4:
                    System.out.println("Entrando no Financeiro...");
                    System.out.println("O saldo atual é de: R$" + lojaService.verificarSaldo());
                    break;
                case 5:
                    System.out.println("Sainda...");
            }
        }
    }

    private Produto montarProduto() {
        String nome;
        BigDecimal preco;
        int quantidade;
        System.out.println("Digite o nome/novo nome deste produto");
        nome = scan.nextLine();
        nome = scan.nextLine();
        System.out.println("Digite o preço/novo preço deste produto");
        preco = BigDecimal.valueOf(scan.nextDouble());
        System.out.println("Digite a quantidade do produto");
        quantidade = scan.nextInt();
        return new Produto(nome, preco, quantidade);
    }

    private boolean realizarVenda() {
        System.out.println("Digite o id do produto vendido");
        int id = scan.nextInt();
        System.out.println("Digite a quantidade do produto vendido");
        int quantidade = scan.nextInt();
        return lojaService.realizarVenda(id, quantidade);
    }
}
