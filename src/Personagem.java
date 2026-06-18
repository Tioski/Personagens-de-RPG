abstract class Personagem implements Combatente {
    private String nome;
    private int vida;
    private int ataque;
    private Item item;
    private Item itemEspecial;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public int getAtaque() { return ataque; }
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
    public Item getItemEspecial() { return itemEspecial; }
    public void setItemEspecial(Item itemEspecial) { this.itemEspecial = itemEspecial; }

    public abstract String getTipo();

    public void atacar(String alvo) {
        System.out.println(nome + " ataca " + alvo + " causando " + ataque + " de dano!");
    }

    public abstract void usarHabilidadeEspecial();

    public void exibirStatus() {
        System.out.println("-----------------------------");
        System.out.println("Nome:          " + nome);
        System.out.println("Tipo:          " + getTipo());
        System.out.println("Vida:          " + vida);
        System.out.println("Ataque:        " + ataque);
        System.out.println("Item:          " + (item != null ? item : "Nenhum"));
        System.out.println("Item especial: " + (itemEspecial != null ? itemEspecial : "Nenhum"));
        System.out.println("-----------------------------");
    }
}
