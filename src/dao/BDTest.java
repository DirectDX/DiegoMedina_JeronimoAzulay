package dao;

import modelo.Odontologo;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

class BDTest {
        @Test
    public static void main(String[] args) {
        BD.createTableOdontologos();
            Odontologo odontologo = new Odontologo("1","Juan","Perez");
            Odontologo odontologo1 = new Odontologo("2","Juan2","Perez2");
            OdontologoService odontologoService = new OdontologoService("java");
            OdontologoService odontologoService1 = new OdontologoService("h2");
            odontologoService.guardar(odontologo);
            odontologoService.guardar(odontologo1);
            odontologoService.listarTodo();
            odontologoService1.guardar(odontologo);
            odontologoService1.guardar(odontologo1);
            odontologoService1.listarTodo();

    }

}