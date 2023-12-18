package model_dao;

import db.DB;
import model_dao_impl.UsuariosDaoJDBC;

public class DaoFactory {

    public static UsuariosDao createUsuariosDao() {
        return new UsuariosDaoJDBC(DB.getConnection());
    }
}
