package model;

import interfaces.Combatente;

public abstract class Personagem implements Combatente {
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

    // Getters e Setters (Encapsulamento)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public Item getItemEspecial() { return itemEspecial; }
    public void setItemEspecial(Item itemEspecial) { this.itemEspecial = itemEspecial; }

    // Método concreto comum
    @Override
    public void atacar(String alvo) {
        System.out.println(nome + " ataca " + alvo + " causando " + ataque + " de dano!");
    }

    // Método abstrato — cada subclasse implementa do seu jeito
    @Override
    public abstract void usarHabilidadeEspecial();

    public abstract String getTipo();

    @Override
    public String getStatus() {
        String itemInfo      = (item != null)        ? item.toString()        : "Nenhum";
        String itemEspInfo   = (itemEspecial != null) ? itemEspecial.toString() : "Nenhum";
        return String.format(
            "┌─────────────────────────────────────┐\n" +
            "│ Nome:         %-22s│\n" +
            "│ Tipo:         %-22s│\n" +
            "│ Vida:         %-22d│\n" +
            "│ Ataque:       %-22d│\n" +
            "│ Item:         %-22s│\n" +
            "│ Item Especial:%-22s│\n" +
            "└─────────────────────────────────────┘",
            nome, getTipo(), vida, ataque, itemInfo, itemEspInfo
        );
    }
}
