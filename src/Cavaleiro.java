class Cavaleiro extends Personagem {
    public Cavaleiro(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    public String getTipo() { return "Cavaleiro"; }

    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " usa Golpe Devastador causando " + (getAtaque() * 3) + " de dano fisico!");
    }
}
