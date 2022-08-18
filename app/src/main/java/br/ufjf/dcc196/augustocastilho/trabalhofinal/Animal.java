package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "animal")
public class Animal {
    @PrimaryKey(autoGenerate =  true)
    private Long id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "raça")
    private String raça;

    @ColumnInfo(name = "peso")
    private Integer peso;

    @ColumnInfo(name = "nascimento")
    private Date nascimento;

    @ColumnInfo(name = "vacinas")
    private List<String> vacinas;

}
