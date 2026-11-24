package cofre.dominio;
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(Money saldo, Money valor) {
        super("Saldo insuficiente: saldo " + saldo + ", valor " + valor);
    }
}
