package co.edu.unbosque.model;

import java.io.Serializable;

public class Tienda implements Serializable {

    private int idTienda;

    private String ciudadTienda;

    private String direccionTienda;

    public Tienda(int idTienda, String ciudadTienda, String direccionTienda)  {
        this.idTienda = idTienda;
        this.ciudadTienda = ciudadTienda;
        this.direccionTienda = direccionTienda;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getCiudadTienda() {
        return ciudadTienda;
    }

    public void setCiudadTienda(String ciudadTienda) {
        this.ciudadTienda = ciudadTienda;
    }

    public String getDireccionTienda() {
        return direccionTienda;
    }

    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }
}
