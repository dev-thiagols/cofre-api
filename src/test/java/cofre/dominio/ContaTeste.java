package cofre.dominio;
public class ContaTeste {
    public static void main(String[] args) {

        Conta ana = new Conta(1, "Ana Julia");
        Conta matteo = new Conta(2, "Matteo Dias");
        Conta vitoria = new Conta(3, "Vitoria Dias");

        ana.depositar(Money.of("150"));
        matteo.depositar(Money.of("150"));
        vitoria.depositar(Money.of("150"));

        try {
            ana.sacar(Money.of("200"));
            System.out.println("FALHOU   sacar sem saldo: deveria ter lançado exceção.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("OK   sacar sem saldo: " + e.getMessage());
        }

        try {
            matteo.transferir(null, Money.of("100"));
            System.out.println("Falhou   transferir sem destino: deveria ter lançado exceção.");
        } catch (IllegalArgumentException e) {
            System.out.println("OK   transferir com destino nulo: " + e.getMessage());
        }

        try {
            vitoria.depositar(Money.of("0"));
            System.out.println("FALHOU   depositar valor igual ou menor que ZERO: deveria ter lançado exceção.");
        } catch (IllegalArgumentException e) {
            System.out.println("OK   depositar valor ZERO: " + e.getMessage());
        }
    }

    static void testar(String nome, String obtido, String esperado) {
        if (obtido == esperado) {
            System.out.println("OK      " + nome);
        } else {
            System.out.println("FALHOU  " + nome + ": esperado " + esperado + ", obtido " + obtido);
        }
    }
}
