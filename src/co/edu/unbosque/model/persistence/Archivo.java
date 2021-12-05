package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Tienda;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
/*
        ArrayList<Producto> arrayFinal = new ArrayList<>();
        int[] test = new int[array.size()];

        for (int i = 0; i < array.size(); i++) {
            Producto producto = array.get(i);
            test[i] = producto.getIdProducto();
        }

        System.out.println(Arrays.toString(test));

        quicksort(test, 0, test.length - 1);

        System.out.println(Arrays.toString(test));

        for (int j : test) {
            for (Producto producto : array) {
                if (producto.getIdProducto() == j) {
                    arrayFinal.add(producto);
                    break;
                }
            }
        }

        System.out.println(arrayFinal);*/
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

    public void quicksort(int[] A, int izq, int der) {
        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq;         // i realiza la búsqueda de izquierda a derecha
        int j = der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {                          // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while (A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux = A[i];                      // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1)
            quicksort(A, izq, j - 1);          // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(A, j + 1, der);          // ordenamos subarray derecho
    }
}
