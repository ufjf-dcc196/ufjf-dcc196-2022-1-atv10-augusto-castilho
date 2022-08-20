package br.ufjf.dcc196.augustocastilho.trabalhofinal;

public class Clinica {
    private final String nome;
    private final String endereco;

    public Clinica(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }
}
