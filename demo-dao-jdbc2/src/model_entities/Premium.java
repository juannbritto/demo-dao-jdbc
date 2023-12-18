package model_entities;

import java.io.Serializable;

public class Premium extends Usuarios implements Serializable {

    private int vidaExtra;

    public Premium() {
        super();

    }

    public Premium(int id, String nome, String senha, String email, String telefone, int vida, int vidaExtra) {
        super();
        this.vidaExtra = 5;
    }

    public int getVidaExtra() {
        return vidaExtra;
    }

    @Override
    public String toString() {
        return "Premium{" +
                "vidaExtra=" + vidaExtra +
                '}';
    }
}
