package br.senac.sp.swingcrud.repository;

import java.util.List;

public interface GenericRepository<T> {
    public void inserir(T objeto);
    public void atualizar(T objeto);
    public void excluir(Long id);
    public List<T> listar();
}
