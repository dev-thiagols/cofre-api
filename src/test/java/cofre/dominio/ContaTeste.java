package cofre.dominio;
import java.util.*;
public class ContaTeste {
    public static void main(String[] args) {

        Conta ana = new Conta(1, "Matteo Dias");
        Conta matteo = new Conta(2, "Matteo Dias");
        Conta vitoria = new Conta(2, "Vitoria Dias");

        System.out.println("Teste mesmo objeto: " + matteo.equals(matteo));
        System.out.println("Teste mesmo numero, titular diferente: " + matteo.equals(vitoria));
        System.out.println("Teste numero diferente, titular igual: " + matteo.equals(ana));
        System.out.println("Teste comparando null: " + matteo.equals(null));
        System.out.println("Teste comparando inteiro (tipos diferentes): " + matteo.equals(2));
        System.out.println("Teste comparando String (tipos diferentes): " + matteo.equals("2"));


        Set<Money> valores = new HashSet<>();
        valores.add(Money.of("10.00"));
        valores.add(Money.of("10.00"));
        System.out.println(valores.size());
        System.out.println(valores.contains(Money.of("10.00")));
    }

    static boolean testar(String nome, boolean obtido, boolean esperado) {
        if (obtido == esperado) {
            System.out.println("OK   :" + nome);
            return true;
        } else {
            System.out.println("FALHOU  " + nome + ": esperado " + esperado + ", obtido " + obtido);
            return false;
        }
    }
}
