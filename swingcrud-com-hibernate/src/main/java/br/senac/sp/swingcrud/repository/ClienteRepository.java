package br.senac.sp.swingcrud.repository;

import java.util.List;

import br.senac.sp.swingcrud.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ClienteRepository implements GenericRepository<Cliente>{
    private EntityManagerFactory factory;

    public ClienteRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void inserir(Cliente objeto) {
        try (EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(objeto);
            manager.getTransaction().commit();
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void atualizar(Cliente objeto) {
        try (EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            manager.merge(objeto);
            manager.getTransaction().commit();
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Cliente> listar() {
        try (EntityManager manager = factory.createEntityManager()) {
            TypedQuery<Cliente> query = manager.createQuery("select c from Cliente c", Cliente.class);
            return query.getResultList();
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void excluir(Long id) {
        try (EntityManager manager = factory.createEntityManager()) {
            Cliente c = manager.find(Cliente.class, id);
            manager.getTransaction().begin();
            manager.remove(c);
            manager.getTransaction().commit();
        }catch (Exception e) {
            throw e;
        }
    }
}