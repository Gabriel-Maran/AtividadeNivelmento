package service;

import model.Estoque;
import model.Loja;
import model.Produto;

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

    public boolean adicionarProduto(Integer id, Produto produto) {
        Estoque estoque = loja.getEstoque();
        Map<Integer, Produto> produtos = estoque.getProdutos();
        if (produtos.containsKey(id)) {
            produtos.put(
                    id,
                    new Produto(
                            produto.getNome(),
                            produto.getPreco(),
                            produtos.get(id).getQuantidade() + produto.getQuantidade()
                    )
            );
        } else {
            produtos.put(id, new Produto(produto.getNome(), produto.getPreco(), produto.getQuantidade()));
        }
        return true;
    }

    public boolean removerQuantidadeProduto(Integer id, int quantidade) {
        Optional<Map<Integer, Produto>> produtoOpt = pegarProdutoPorId(id);
        if (produtoOpt.isEmpty()) return false;
        Produto produto = produtoOpt.get().get(id);
        Estoque estoque = loja.getEstoque();
        Map<Integer, Produto> produtos = estoque.getProdutos();
        if (produtos.containsKey(id)) {
            if (produtos.get(id).getQuantidade() - produto.getQuantidade() < 0) return false;
            produtos.put(
                    id,
                    new Produto(
                            produto.getNome(),
                            produto.getPreco(),
                            produtos.get(id).getQuantidade() - quantidade
                    )
            );
        } else {
            return false;
        }
        return true;
    }

    public boolean removerProdutoCompleto(Integer id) {
        Optional<Map<Integer, Produto>> produtoOpt = pegarProdutoPorId(id);
        if (produtoOpt.isEmpty()) return false;
        Produto produto = produtoOpt.get().get(id);
        Map<Integer, Produto> produtos = loja.getEstoque().getProdutos();
        if (produtos.containsKey(id)) {
            if (produtos.get(id).getQuantidade() - produto.getQuantidade() < 0) return false;
            produtos.remove(id);
        } else {
            return false;
        }
        return true;
    }

    public boolean adicionarQuantidade(Integer id, int quantidade) {
        Optional<Map<Integer, Produto>> produtoOpt = pegarProdutoPorId(id);
        if (produtoOpt.isEmpty()) return false;
        Produto produto = produtoOpt.get().get(id);
        Map<Integer, Produto> produtos = loja.getEstoque().getProdutos();
        if (produtos.containsKey(id)) {
            if (produtos.get(id).getQuantidade() - produto.getQuantidade() < 0) return false;
            produtos.put(
                    id,
                    new Produto(
                            produto.getNome(),
                            produto.getPreco(),
                            produtos.get(id).getQuantidade() + quantidade
                    )
            );
        } else {
            return false;
        }
        return true;
    }
}
