package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Loja {
    private Estoque estoque;
    private Financeiro financeiro;
    private List<Compra> compras;
    private List<Venda> vendas;

    public Loja(BigDecimal valorInicial) {
        this.estoque = new Estoque();
        this.financeiro = new Financeiro(valorInicial);
        this.compras = List.of();
        this.vendas = List.of();;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Financeiro getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(Financeiro financeiro) {
        this.financeiro = financeiro;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Loja loja = (Loja) o;
        return Objects.equals(estoque, loja.estoque) && Objects.equals(financeiro, loja.financeiro) && Objects.equals(compras, loja.compras) && Objects.equals(vendas, loja.vendas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estoque, financeiro, compras, vendas);
    }
}
