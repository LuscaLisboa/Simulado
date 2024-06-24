package models;

public class Pessoa {
    public int id;
    public String nome;
    public String rua;
    public String cidade;

    public Pessoa(int id, String nome, String rua, String cidade) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
    }

    public void toCsv() {

    }
}
