package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Producto;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DaoProducto {

    private final Archivo archivo;

    public DaoProducto(Archivo archivo) {
        this.archivo = archivo;
    }

    public boolean agregarProducto(ArrayList<Producto> arrayProductos, File file, int idProducto, String nombreProducto, String loreProducto, long precioProducto, ImageIcon imagenProducto) {
        Producto producto = new Producto(idProducto, nombreProducto, loreProducto, precioProducto, imagenProducto);

        if (buscarProducto(arrayProductos, idProducto) == null) {
            arrayProductos.add(producto);
            archivo.escribirArchivoProducto(arrayProductos, file);
            return true;
        } else {
            return false;
        }
    }

    public Producto buscarProducto(ArrayList<Producto> arrayProductos, int idProducto) {
        Producto existente = null;

        if (!arrayProductos.isEmpty()) {
            for (Producto producto : arrayProductos) {
                if (producto.getIdProducto() == idProducto) {
                    existente = producto;
                }
            }
        }
        return existente;
    }

    public boolean eliminarProducto(ArrayList<Producto> arrayProductos, File file, int idProducto) {
        try {
            Producto producto = buscarProducto(arrayProductos, idProducto);
            if (producto == null) {
                return false;
            } else {
                arrayProductos.remove(producto);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivoProducto(arrayProductos, file);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarProducto(ArrayList<Producto> arrayProductos, File file, int idProducto, String nombreProducto, String loreProducto, long precioProducto, ImageIcon imagenProducto) {
        try {
            Producto producto = buscarProducto(arrayProductos, idProducto);
            if (producto != null) {
                eliminarProducto(arrayProductos, file, idProducto);
                producto.setNombreProducto(nombreProducto);
                producto.setLoreProducto(loreProducto);
                producto.setPrecioProducto(precioProducto);
                producto.setImagenProducto(imagenProducto);
                arrayProductos.add(producto);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivoProducto(arrayProductos, file);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
