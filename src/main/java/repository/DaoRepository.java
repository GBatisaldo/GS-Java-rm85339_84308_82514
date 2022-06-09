package main.java.repository;

import java.util.List;

public interface DaoRepository<E> {
    void inserir(E entity);
    List<E> listarTodos();
    E acharPorId(Long id);
}
