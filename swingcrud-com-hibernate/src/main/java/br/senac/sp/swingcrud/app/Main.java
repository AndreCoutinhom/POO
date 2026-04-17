package br.senac.sp.swingcrud.app;

import br.senac.sp.swingcrud.controller.ClienteController;
import br.senac.sp.swingcrud.dao.ClienteDao;
import br.senac.sp.swingcrud.model.Cliente;
import br.senac.sp.swingcrud.repository.ClienteRepository;
import br.senac.sp.swingcrud.repository.GenericRepository;
import br.senac.sp.swingcrud.view.ClienteView;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
//        ClienteDao dao = new ClienteDao();
        ClienteView view = new ClienteView();
        GenericRepository<Cliente> dao = new ClienteRepository(Persistence.createEntityManagerFactory("swingcrud"));
        new ClienteController(view, dao);
        view.setVisible(true);
    }
}
