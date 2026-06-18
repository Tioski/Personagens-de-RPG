package model;

import interfaces.Curavel;

public class Curandeiro extends Personagem implements Curavel {

    public Curandeiro(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    @Override
    public void usarHabilidadeEspecial() {
        int cura = getAtaque() + 20;
        System.out.println(getNome() + " canaliza energia sagrada e se cura em " + cura + " pontos de vida!");
        curar(cura);
    }

    @Override
    public void curar(int quantidade) {
        setVida(getVida() + quantidade);
        System.out.println(">> " + getNome() + " agora tem " + getVida() + " de vida.");
    }

    @Override
    public String getTipo() {
        return "Curandeiro";
    }
}
