package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Financeiro {
    private BigDecimal saldoTotal;

    public Financeiro(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Financeiro that = (Financeiro) o;
        return Objects.equals(saldoTotal, that.saldoTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(saldoTotal);
    }
}
