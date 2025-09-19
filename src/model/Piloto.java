package model;

public class Piloto {
    //atbs
    private int id;
    private String nome;
    private int pontuacao;


//constructors
    public Piloto() {
    }

    public Piloto(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    //getters, setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return nome + '\'' +
                "------- pontuacao= " + pontuacao;
    }
}
