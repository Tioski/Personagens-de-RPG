package model;

public class MagoSombrio extends Mago {

    public MagoSombrio(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " invoca Magia das Trevas causando " + (getAtaque() * 4) + " de dano sombrio, drenando vida do inimigo!");
    }

    @Override
    public String getTipo() {
        return "Mago Sombrio";
    }
}
