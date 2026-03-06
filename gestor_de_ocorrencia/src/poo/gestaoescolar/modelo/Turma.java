package poo.gestaoescolar.modelo;

import java.util.Calendar;

public class Turma {
    private Long id;
    private String sigla;
    private Calendar dataInicio;
    private Curso curso;

    public boolean isAtiva() {
        return true;
    }

    public Calendar getTermino() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
