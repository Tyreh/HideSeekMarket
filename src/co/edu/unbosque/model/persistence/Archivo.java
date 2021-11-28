package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Tienda;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    private ObjectInputStream entrada;

    private ObjectOutputStream salida;

    public Archivo(File fileClientes, File fileProductos, File fileTiendas) {
        if (!fileClientes.exists()) {
            try {
                fileClientes.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!fileProductos.exists()) {
            try {
                fileProductos.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!fileTiendas.exists()) {
            try {
                fileTiendas.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void escribirArchivoCliente(ArrayList<Cliente> array, File file) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(file));
            salida.writeObject(array);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void escribirArchivoProducto(ArrayList<Producto> array, File file) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(file));
            salida.writeObject(array);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void escribirArchivoTienda(ArrayList<Tienda> array, File file) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(file));
            salida.writeObject(array);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public ArrayList<Cliente> leerArchivoCliente(File file) {
        ArrayList<Cliente> array = new ArrayList<>();
        if (file.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(file));
                array = (ArrayList<Cliente>) entrada.readObject();
                entrada.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    public ArrayList<Producto> leerArchivoProducto(File file) {
        ArrayList<Producto> array = new ArrayList<>();
        if (file.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(file));
                array = (ArrayList<Producto>) entrada.readObject();
                entrada.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    public ArrayList<Tienda> leerArchivoTienda(File file) {
        ArrayList<Tienda> array = new ArrayList<>();
        if (file.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(file));
                array = (ArrayList<Tienda>) entrada.readObject();
                entrada.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return array;
    }
}
