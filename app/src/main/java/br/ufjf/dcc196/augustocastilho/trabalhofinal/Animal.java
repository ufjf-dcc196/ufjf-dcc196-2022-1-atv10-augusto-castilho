package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animal")
public class Animal {
    @PrimaryKey(autoGenerate =  true)
    private Long id;

    private String nome;
    private String raca;
    private Integer peso;
    private Integer nascimento;
    private String vacinas;

    public Animal(@NonNull String nome, @NonNull String raca){
        this.nome = nome;
        this.raca = raca;
        this.peso = 0;
        this.nascimento = 0;
        this.vacinas = "a";
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getRaca(){
        return this.raca;
    }

    public Integer getPeso(){
        return this.peso;
    }

    public Integer getNascimento(){
        return this.nascimento;
    }

    public String getVacinas(){
        return this.vacinas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void setNascimento(Integer nascimento) {
        this.nascimento = nascimento;
    }

    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }
}
