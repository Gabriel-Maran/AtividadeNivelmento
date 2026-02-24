package service;

import model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LojaService {
    private Loja loja;

    public LojaService(Loja loja) {
        this.loja = loja;
    }

    public Optional<Map<Integer, Produto>> pegarProdutoPorId(Integer id) {
        Map<Integer, Produto> estoque = loja.getEstoque().getProdutos();
        if (estoque.containsKey(id)) return Optional.of(Map.of(id, estoque.get(id)));
        return Optional.empty();
    }

    public boolean realizarCompra(Integer id, Produto produto) {
        Estoque estoque = loja.getEstoque();
        Financeiro financeiro = loja.getFinanceiro();
        BigDecimal valorTotal = produto.getPreco()
                .multiply(BigDecimal.valueOf(produto.getQuantidade()));
        if (financeiro.getSaldoTotal().compareTo(valorTotal) < 0) return false;
        financeiro.setSaldoTotal(financeiro.getSaldoTotal().subtract(valorTotal));
        Map<Integer, Produto> produtos = estoque.getProdutos();
        Produto produtoComprado = new Produto(
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
        );
        if (produtos.containsKey(id)) {
            produtoComprado.setQuantidade(produtoComprado.getQuantidade() + produtos.get(id).getQuantidade());
            produtos.put(id, produtoComprado);
        } else {
            produtos.put(id, produtoComprado);
        }
        List<Compra> compras = loja.getCompras();
        compras.add(new Compra(produtoComprado));
        loja.setCompras(compras);
        return true;
    }

    public boolean realizarVenda(Integer id, int quantidade) {
        Optional<Map<Integer, Produto>> produtoOpt = pegarProdutoPorId(id);
        if (produtoOpt.isEmpty()) return false;
        Produto produto = produtoOpt.get().get(id);
        Estoque estoque = loja.getEstoque();
        Map<Integer, Produto> produtos = estoque.getProdutos();
        if (produtos.containsKey(id)) {
            if (produtos.get(id).getQuantidade() - produto.getQuantidade() < 0) return false;
            Produto produtoVendido = new Produto(
                    produto.getNome(),
                    produto.getPreco(),
                    produtos.get(id).getQuantidade() - quantidade);
            produtos.put(id,produtoVendido);
            BigDecimal saldoAtual = loja.getFinanceiro().getSaldoTotal();
            BigDecimal valorProduto = produto.getPreco().multiply(BigDecimal.valueOf(1.05));
            loja.getFinanceiro().
                    setSaldoTotal(
                            saldoAtual.add(
                                    valorProduto.multiply(BigDecimal.valueOf(produto.getQuantidade()))
                            )
                    );
            List<Venda> vendas = loja.getVendas();
            vendas.add(new Venda(produtoVendido));
            loja.setVendas(vendas);
        } else {
            return false;
        }
        return true;
    }

    public BigDecimal verificarSaldo() {
        return loja.getFinanceiro().getSaldoTotal();
    }

    public void listarTodosOsProdutos() {
        Map<Integer, Produto> produtos = loja.getEstoque().getProdutos();
        System.out.println("================ List de itens atuais ================");
        if (produtos.isEmpty()) System.out.println("Sem produtos disponíveis");
        for (int key : produtos.keySet()) {
            Produto produtoAtual = produtos.get(key);
            System.out.println(
                    "ID: " + key +
                            " - Nome: " + produtoAtual.getNome() +
                            " - Qntdd: " + produtoAtual.getQuantidade() +
                            " - Preço bruto uni: R$" + produtoAtual.getPreco());
        }
        System.out.println("======================================================");
    }
}
