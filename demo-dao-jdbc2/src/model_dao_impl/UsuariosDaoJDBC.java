package model_dao_impl;

import db.DB;
import db.DbException;
import model_dao.UsuariosDao;
import model_entities.Usuarios;

import java.sql.*;

public class UsuariosDaoJDBC implements UsuariosDao {

    private Connection conn;

    public UsuariosDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Usuarios obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO Usuarios "
                            +"(nome, senha, email, telefone, vida) "
                            +"VALUES "
                            +"(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getSenha());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getTelefone());
            st.setInt(5, obj.getVida());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0 ) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);

                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);

        }


    }

    @Override
    public void update(Usuarios obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE Usuarios "
                            + "SET senha = ? "
                            + "WHERE Id = ?");

            st.setString(1, obj.getSenha());
            st.setInt(2, obj.getId());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);

        }
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM Usuarios WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }


    @Override
    public Usuarios findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT Usuarios.* "
                            +"FROM Usuarios "
                            +"WHERE Usuarios.Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {

                Usuarios obj = instantiateUsuarios(rs);
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);


        }

    }

    private Usuarios instantiateUsuarios(ResultSet rs) throws SQLException {
        Usuarios obj = new Usuarios(null, "Diogo", "123456", "diogo@gmail.com", "99999-9999", 5);
        obj.setId(rs.getInt("Id"));
        obj.setNome(rs.getString("Nome"));
        obj.setSenha(rs.getString("Senha"));
        obj.setEmail(rs.getString("Email"));
        obj.setVida(rs.getInt("Vida"));
        return obj;
    }






}
