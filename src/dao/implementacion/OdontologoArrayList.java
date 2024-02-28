package dao.implementacion;

import dao.IDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoArrayList implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoArrayList.class);
    private static int contador = 1;
    private static List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(contador);
        odontologos.add(odontologo);
        contador++;
        LOGGER.info("Se persistio en la lista de Java: " + odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer i) {
        return null;
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> listarTodo() {
        LOGGER.info("Lista de odontologos de java: " + odontologos);
        return odontologos;
    }
}
