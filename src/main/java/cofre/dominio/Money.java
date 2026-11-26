package cofre.dominio;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {
	private final BigDecimal valor;

	private Money(BigDecimal valor) {
        this.valor = valor.setScale(2, RoundingMode.UNNECESSARY);
	}

	public static Money of(String valor) {
        return new Money(new BigDecimal(valor));
	}

	public static Money zero() {
		return new Money(BigDecimal.ZERO);
	}

	public Money somar(Money outro) {
        return new Money(this.valor.add(outro.valor));
	}

    public Money subtrair(Money outro) {
        return new Money(this.valor.subtract(outro.valor));
    }

    public boolean ehMaiorQue(Money outro) {
        return this.valor.compareTo(outro.valor) > 0;
    }

    public boolean ehPositivo() {
        return this.valor.signum() > 0;
    }

    public static String gerarExtrato(String titular, Money[] movimentos) {
        StringBuilder extrato = new StringBuilder();
        extrato.append("Extrato de ").append(titular).append("\n").append("-------------------------------\n");
        int counter = 0;
        Money total = Money.zero();
        for(Money movimento : movimentos) {
            counter++;
            total = total.somar(movimento);
            extrato.append(String.format("%-15s%12s%n", "Movimento " + counter, movimento));
        }
        extrato.append("-------------------------------\n").append(String.format("%-15s%12s", "Total ", total));

        return extrato.toString();
    }

    @Override
    public String toString() {
        return "R$ " + valor.toString().replace('.', ',');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money outro)) {
            return false;
        }
        return this.valor.equals(outro.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}
