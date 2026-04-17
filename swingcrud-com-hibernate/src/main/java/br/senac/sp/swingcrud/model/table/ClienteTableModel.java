package br.senac.sp.swingcrud.model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.senac.sp.swingcrud.model.Cliente;

public class ClienteTableModel extends AbstractTableModel {
    private List<Cliente> clientes;
    private String[] cabecalho = {"ID", "Nome", "E-mail", "Endereço"};

    public Cliente getClienteAt(int linha) {
        return clientes.get(linha);
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        fireTableDataChanged();
    }
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    @Override
    public int getColumnCount() {
        return cabecalho.length;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public Object getValueAt(int lin, int col) {
        Cliente c = clientes.get(lin);
        switch (col) {
            case 0:
                return c.getId();
            case 1:
                return c.getNome();
            case 2:
                return c.getEmail();
            case 3:
                return c.getEndereco();
            default:
                return null;
        }
    }

}