package cofre.dominio;

public class Conta {
    private final int numero;
    private final String titular;
    private Money saldo = Money.zero();

    public Conta(int numero, String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular não pode ser vazio ou nulo.");
        }
        if (numero <= 0) {
            throw new IllegalArgumentException("Numero não pode ser ZERO ou NEGATIVO.");
        }
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public Money getSaldo() {
        return saldo ;
    }

    public void depositar(Money valor) {
        if (!valor.ehPositivo()) {
            throw new IllegalArgumentException("Valor não pode ser ZERO ou NEGATIVO.");
        }
         saldo = saldo.somar(valor);
    }

    public void sacar(Money valor) {
        if (valor.ehMaiorQue(saldo)) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        if (!valor.ehPositivo()) {
            throw new IllegalArgumentException("Valor não pode ser ZERO ou NEGATIVO.");
        }
        saldo = saldo.subtrair(valor);
    }

    public void transferir(Conta destino, Money valor) {
        if (destino == this) {
            throw new IllegalArgumentException("Conta destino não pode ser a mesma a realizar a transferência.");
        }
        if (destino == null) {
            throw new IllegalArgumentException("Conta destino não pode ser NULL.");
        }
        sacar(valor);
        destino.depositar(valor);
    }
}
