package model;

import java.util.Objects;

public class Venda {
    private Produto produtoVendido;

    public Venda(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public Produto getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(produtoVendido, venda.produtoVendido);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(produtoVendido);
    }
}
