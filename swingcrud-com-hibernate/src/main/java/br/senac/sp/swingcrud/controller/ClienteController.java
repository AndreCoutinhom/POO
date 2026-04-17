package br.senac.sp.swingcrud.controller;

import br.senac.sp.swingcrud.dao.ClienteDao;
import br.senac.sp.swingcrud.model.Cliente;
import br.senac.sp.swingcrud.repository.GenericRepository;
import br.senac.sp.swingcrud.view.ClienteView;

public class ClienteController {
    private ClienteView view;
    // referência para DAO
    private GenericRepository<Cliente> dao;

    public ClienteController(ClienteView view, GenericRepository<Cliente> dao) {
        this.dao = dao;
        this.view = view;
        /*
         * view.addListenerSalvar(new ActionListener() {
         *
         * @Override public void actionPerformed(ActionEvent e) {
         * System.out.println("Teste1"); } });
         */
        view.addListenerSalvar(e -> {
            salvar();
        });

        view.addListenerExcluir(e -> {
            excluir();
        });

        view.addListenerLimpar(e -> {
            view.limparCampos();
        });

        atualizarTabela();

    }

    private void atualizarTabela() {
        try {
            view.getTableModel().setClientes(dao.listar());
        } catch (Exception e) {
            e.printStackTrace();
            view.mostrarErro("Erro ao atualizar a tabela: " + e.getMessage());
        }
    }

    private void salvar() {
        // validar os campos
        if (view.getNome().trim().isEmpty()) {
            // avisar ao usuário que não foi digitado o nome
            view.mostrarErro("Informe o nome");
        } else if (view.getEmail().trim().isEmpty()) {
            // avisar ao usuário que não foi digitado o e-mail
            view.mostrarErro("Informe o e-mail");
        } else if (view.getEndereco().trim().isEmpty()) {
            // avisar ao usuário que não foi digitado o endereço
            view.mostrarErro("Informe o endereço");
        } else {
            Cliente cliente = view.getCliente();
            // se cliente == null, estamos inserindo
            if (cliente == null) {
                cliente = new Cliente();
            }
            cliente.setNome(view.getNome());
            cliente.setEmail(view.getEmail());
            cliente.setEndereco(view.getEndereco());
            try {
                if (cliente.getId() == null) {
                    dao.inserir(cliente);
                    view.mostrarSucesso("Cliente inserido com sucesso");
                } else {
                    dao.atualizar(cliente);
                    view.mostrarSucesso("Cliente atualizado com sucesso");
                }

                view.limparCampos();
            } catch (Exception e) {
                e.printStackTrace();
                view.mostrarErro("Erro ao salvar: " + e.getMessage());
            }
            atualizarTabela();
        }

    }

    private void excluir()
    {
        if (view.getCliente() == null)
        {
            view.mostrarErro("Selecione um cliente para excluí-lo.");
            return;
        }

        boolean confirme = view.confirmaExclusao();

        if (!confirme)
        {
            return;
        }

        try
        {
            dao.excluir(view.getCliente().getId());
            view.limparCampos();
            atualizarTabela();
        }
        catch (Exception e)
        {
            view.mostrarErro("Erro ao excluir " + e.getMessage());
        }
    }

}