package dao;

import java.util.List;

public interface IDao<T> {
    T guardar(T t);
    T buscar(Integer i);
    T modificar(T t);
    void eliminar(Integer id);
    List<T> listarTodo();
}
