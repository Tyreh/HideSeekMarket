package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.Tienda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DaoTienda {

    private final Archivo archivo;

    public DaoTienda(Archivo archivo) {
        this.archivo = archivo;
    }

    public boolean agregarTienda(ArrayList<Tienda> arrayTiendas, File file, int idTienda, String ciudadTienda, String direccionTienda) {
        Tienda nuevaTienda = new Tienda(idTienda, ciudadTienda, direccionTienda);

        if (buscarTienda(arrayTiendas, idTienda) == null) {
            arrayTiendas.add(nuevaTienda);
            archivo.escribirArchivoTienda(arrayTiendas, file);
            return true;
        } else {
            return false;
        }
    }

    public Tienda buscarTienda(ArrayList<Tienda> arrayClientes, int idTienda) {
        Tienda existente = null;

        if (!arrayClientes.isEmpty()) {
            for (Tienda tienda : arrayClientes) {
                if (tienda.getIdTienda() == idTienda) {
                    existente = tienda;
                }
            }
        }
        return existente;
    }

    public boolean eliminarTienda(ArrayList<Tienda> arrayTiendas, File file, int idTienda) {
        try {
            Tienda tienda = buscarTienda(arrayTiendas, idTienda);
            if (tienda == null) {
                return false;
            } else {
                arrayTiendas.remove(tienda);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivoTienda(arrayTiendas, file);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarCliente(ArrayList<Tienda> arrayTiendas, File file, int idTienda, String ciudadTienda, String direccionTienda) {
        try {
            Tienda existente = buscarTienda(arrayTiendas, idTienda);
            if (existente != null) {
                eliminarTienda(arrayTiendas, file, idTienda);
                existente.setCiudadTienda(ciudadTienda);
                existente.setDireccionTienda(direccionTienda);
                arrayTiendas.add(existente);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivoTienda(arrayTiendas, file);
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
