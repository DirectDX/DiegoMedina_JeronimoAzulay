package dao.implementacion;

import dao.BD;
import dao.IDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        LOGGER.info("Persistiendo un Odontologo");
        try {
            connection = BD.getConnection();
            PreparedStatement insertSql = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO)" +
                    "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
                insertSql.setString(1, odontologo.getMatricula());
                insertSql.setString(2, odontologo.getNombre());
                insertSql.setString(3, odontologo.getApellido());
                insertSql.execute();
            ResultSet resultSet = insertSql.getGeneratedKeys();
            while (resultSet.next()) {
                odontologo.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("Se persistio exitosamente a: " + odontologo);
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
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            connection = BD.getConnection();
            PreparedStatement listarSql = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet resultSet = listarSql.executeQuery();

            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setId(resultSet.getInt(1));
                odontologo.setMatricula(resultSet.getString(2));
                odontologo.setNombre(resultSet.getString(3));
                odontologo.setApellido(resultSet.getString(4));
                odontologos.add(odontologo);

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("Lista de odontologos: " + odontologos);
        return odontologos;
    }
}
