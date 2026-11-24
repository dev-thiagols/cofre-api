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

    @Override
	public String toString() {
        return "R$ " + valor.toString().replace('.', ',');
	}
}
