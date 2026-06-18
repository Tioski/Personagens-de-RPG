package util;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPersonagens {
    private List<Personagem> personagens = new ArrayList<>();

    public void adicionar(Personagem p) {
        personagens.add(p);
    }

    public List<Personagem> listar() {
        return personagens;
    }

    public Personagem buscarPorIndice(int indice) {
        if (indice >= 0 && indice < personagens.size()) {
            return personagens.get(indice);
        }
        return null;
    }

    public int total() {
        return personagens.size();
    }
}
