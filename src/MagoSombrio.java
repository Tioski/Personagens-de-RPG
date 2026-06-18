class MagoSombrio extends Mago {
    public MagoSombrio(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    public String getTipo() { return "Mago Sombrio"; }

    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " invoca Magia das Trevas causando " + (getAtaque() * 4) + " de dano sombrio!");
    }
}
