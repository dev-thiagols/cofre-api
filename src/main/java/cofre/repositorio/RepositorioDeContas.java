package cofre.repositorio;
import cofre.dominio.Conta;
import cofre.dominio.ContaNaoEncontradaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioDeContas {
    private final Map<Integer, Conta> contas = new HashMap<>();

    public void salvar(Conta conta) {
        contas.put(conta.getNumero(), conta);
    }

    public Conta buscar(int numero) {
        Conta conta = contas.get(numero);
        if (conta == null) {
            throw new ContaNaoEncontradaException(numero);
        }
        return conta;
    }

    public List<Conta> listarContas() {
        return new ArrayList<>(contas.values());
    }
}