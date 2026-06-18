class Mago extends Personagem {
    public Mago(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    public String getTipo() { return "Mago"; }

    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " lanca uma Bola de Fogo causando " + (getAtaque() * 2) + " de dano magico!");
    }
}
