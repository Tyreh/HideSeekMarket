package co.edu.unbosque.model;

import javax.swing.*;
import java.io.Serializable;

public class Producto implements Serializable {

    private int idProducto;

    private String nombreProducto;

    private String loreProducto;

    private long precioProducto;

    private ImageIcon imagenProducto;

    public Producto(int idProducto, String nombreProducto, String loreProducto, long precioProducto, ImageIcon imagenProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.loreProducto = loreProducto;
        this.precioProducto = precioProducto;
        this.imagenProducto = imagenProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getLoreProducto() {
        return loreProducto;
    }

    public void setLoreProducto(String loreProducto) {
        this.loreProducto = loreProducto;
    }

    public long getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(long precioProducto) {
        this.precioProducto = precioProducto;
    }

    public ImageIcon getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(ImageIcon imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    @Override
    public String toString() {
        return "ID: " + idProducto +
                "\nNombre: " + nombreProducto +
                "\nDescripción: " + loreProducto +
                "\nPrecio: " + precioProducto;
    }
}
