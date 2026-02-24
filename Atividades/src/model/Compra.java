package model;

import java.util.Objects;

public class Compra {
    private Produto produtoComprado;

    public Compra(Produto produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    public Produto getProdutoVendido() {
        return produtoComprado;
    }

    public void setProdutoVendido(Produto produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Compra venda = (Compra) o;
        return Objects.equals(produtoComprado, venda.produtoComprado);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(produtoComprado);
    }
}
