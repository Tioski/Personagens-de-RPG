package model;

public class Mago extends Personagem {

    public Mago(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " conjura uma Bola de Fogo causando " + (getAtaque() * 2) + " de dano mágico em todos os inimigos!");
    }

    @Override
    public String getTipo() {
        return "Mago";
    }
}
