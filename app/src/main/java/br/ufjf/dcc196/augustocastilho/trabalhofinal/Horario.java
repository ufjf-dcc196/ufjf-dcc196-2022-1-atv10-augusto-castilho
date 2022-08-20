package br.ufjf.dcc196.augustocastilho.trabalhofinal;

public class Horario {
    private final String dia;
    private final String mes;
    private final String hora;

    public Horario(String dia, String mes, String hora) {
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public String getMes() {
        return mes;
    }
}
