package cofre.dominio;
public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException(int numero) {
        super("Conta: " + numero);
    }
}
