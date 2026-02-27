package br.senac.sp.poo.banco;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Cliente {
    public String nome;
    public String cpf;
    public String rg;
    public String nacionalidade;
    public String[] enderecos = new String[2];
    public String[] telefones = new String[3];
    public boolean dependente;
    public Date dataNascimento;

    public String resumoCliente() {

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Nome:%s%nCPF:%s%nRG:%s%nNacionalidade:%s%nNacimento:%s%n",
                nome,cpf,rg,nacionalidade,fmt.format(dataNascimento));
    }
}
