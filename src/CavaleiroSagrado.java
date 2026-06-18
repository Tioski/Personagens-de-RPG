class CavaleiroSagrado extends Cavaleiro implements Curavel {
    public CavaleiroSagrado(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    public String getTipo() { return "Cavaleiro Sagrado"; }

    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " usa Golpe Sagrado causando " + (getAtaque() * 3) + " de dano divino!");
        curar(15);
    }

    public void curar(int quantidade) {
        setVida(getVida() + quantidade);
        System.out.println(getNome() + " recuperou " + quantidade + " de vida. Vida atual: " + getVida());
    }
}
