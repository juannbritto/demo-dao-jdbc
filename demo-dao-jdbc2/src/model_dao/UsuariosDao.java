package model_dao;



import model_entities.Usuarios;

import java.util.List;

public interface UsuariosDao {

    void insert(Usuarios obj);
    void update(Usuarios obj);
    void deleteById(int id);



    Usuarios findById(int id);
}

