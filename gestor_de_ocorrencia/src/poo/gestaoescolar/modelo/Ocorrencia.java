package poo.gestaoescolar.modelo;

import java.util.Calendar;

public class Ocorrencia {
    private Long id;
    private String descricao;
    private TipoOcorrencia tipo;
    private Calendar data;
    private Funcionario relator;
    private Estudante estudante;
    private TipoAcao acao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoOcorrencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoOcorrencia tipo) {
        this.tipo = tipo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Funcionario getRelator() {
        return relator;
    }

    public void setRelator(Funcionario relator) {
        this.relator = relator;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public TipoAcao getAcao() {
        return acao;
    }

    public void setAcao(TipoAcao acao) {
        this.acao = acao;
    }
}
