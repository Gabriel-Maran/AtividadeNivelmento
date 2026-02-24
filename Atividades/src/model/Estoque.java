package model;

import java.util.*;

public class Estoque {
    private Map<Integer, Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public Map<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<Integer, Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(produtos, estoque.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(produtos);
    }
}
