package br.senac.sp.swingcrud.controller;

import br.senac.sp.swingcrud.view.ClienteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteController {
    private ClienteView view;
    // Referência para DAO

    public ClienteController(ClienteView view) {
        this.view = view;

//        view.addListenerSalvar(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               salvar();
//            }
//        });
        // O script acima faz exatamente a mesma coisa que o abaixo:
        view.addListenerSalvar(e -> {
            salvar();
        });

    }

    private void salvar() {

        if(view.getNome().trim().isEmpty()) {
            System.out.println("Nome não digitado");
        }

        System.out.println("Saved");
    }
}
