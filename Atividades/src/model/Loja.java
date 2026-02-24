package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Loja {
    private Estoque estoque;
    private Financeiro financeiro;
    private List<Compra> compras;
    private List<Venda> vendas;

    public Loja() {
        this.estoque = new Estoque();
        this.financeiro = new Financeiro(BigDecimal.valueOf(100));
        this.compras = List.of();
        this.vendas = List.of();
        ;
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
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Loja loja = (Loja) object;
        return Objects.equals(getEstoque(), loja.getEstoque()) && Objects.equals(getFinanceiro(), loja.getFinanceiro()) && Objects.equals(getCompras(), loja.getCompras()) && Objects.equals(getVendas(), loja.getVendas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstoque(), getFinanceiro(), getCompras(), getVendas());
    }
}
