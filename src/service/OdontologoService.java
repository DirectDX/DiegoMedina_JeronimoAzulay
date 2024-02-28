package service;

import dao.IDao;
import dao.implementacion.OdontologoArrayList;
import dao.implementacion.OdontologoDaoH2;
import modelo.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;


    public OdontologoService(String nombre) {
        if (nombre == "h2") {
         this.odontologoIDao = new OdontologoDaoH2();
        } else if (nombre == "java") {
            this.odontologoIDao = new OdontologoArrayList();
        }

    }
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }
    public List<Odontologo> listarTodo() {
        return odontologoIDao.listarTodo();
    }
}
