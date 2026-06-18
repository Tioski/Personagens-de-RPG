class Curandeiro extends Personagem implements Curavel {
    public Curandeiro(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    public String getTipo() { return "Curandeiro"; }

    public void usarHabilidadeEspecial() {
        System.out.println(getNome() + " canaliza energia sagrada!");
        curar(getAtaque() + 20);
    }

    public void curar(int quantidade) {
        setVida(getVida() + quantidade);
        System.out.println(getNome() + " se curou em " + quantidade + " pontos. Vida atual: " + getVida());
    }
}
