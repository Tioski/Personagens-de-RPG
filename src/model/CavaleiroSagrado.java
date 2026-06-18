package model;

import interfaces.Curavel;

public class CavaleiroSagrado extends Cavaleiro implements Curavel {

    public CavaleiroSagrado(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " usa Golpe Sagrado causando " + (getAtaque() * 3) + " de dano divino e se benze!");
        curar(15);
    }

    @Override
    public void curar(int quantidade) {
        setVida(getVida() + quantidade);
        System.out.println(">> " + getNome() + " recuperou " + quantidade + " de vida. Total: " + getVida());
    }

    @Override
    public String getTipo() {
        return "Cavaleiro Sagrado";
    }
}
