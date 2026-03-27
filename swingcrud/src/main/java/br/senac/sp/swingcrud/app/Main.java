package br.senac.sp.swingcrud.app;

import br.senac.sp.swingcrud.controller.ClienteController;
import br.senac.sp.swingcrud.view.ClienteView;

public class Main {
    public static void main(String[] args) {
        ClienteView view = new ClienteView();
        view.setVisible(true);

        new ClienteController(view);
    }
}
