package service;

import dao.IDao;
import dao.implementacion.OdontologoArrayList;
import dao.implementacion.OdontologoDaoH2;
import modelo.Odontologo;

import java.util.List;

public class OdontologoService {
    // private IDao<Odontologo> odontologoIDaoArray;
    private IDao<Odontologo> odontologoIDao;


    public OdontologoService() {
        // this.odontologoIDaoArray = new OdontologoArrayList();
        this.odontologoIDao = new OdontologoArrayList();
    }
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }
    public List<Odontologo> listarTodo() {
        return odontologoIDao.listarTodo();
    }
}
