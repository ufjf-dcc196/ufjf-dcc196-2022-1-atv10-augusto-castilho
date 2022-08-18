package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import java.util.List;

public class Animal {
    private String nome;
    private String raca;
    private Integer peso;
    private Integer nascimento;
    private List<String> vacinas;

    public Animal(String nome, String raca, Integer peso, Integer nascimento, List<String> vacinas) {
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.nascimento = nascimento;
        this.vacinas = vacinas;
    }
}
