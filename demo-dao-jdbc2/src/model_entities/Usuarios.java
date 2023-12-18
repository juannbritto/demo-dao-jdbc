package model_entities;

import java.io.Serializable;
import java.util.Objects;

public class Usuarios implements Serializable {

    private int id;
    private String nome;
    private String senha;
    private String email;
    private String telefone;
    private int vida;

    public Usuarios(Integer o, String nome, String number, String mail, String telefone, int vida) {

    }

    public Usuarios() {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.vida = vida;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getVida() {
        return vida;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", vida=" + vida +
                '}';
    }
}
