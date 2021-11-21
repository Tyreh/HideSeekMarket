package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Cliente;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    private ObjectInputStream entrada;

    private ObjectOutputStream salida;

    public Archivo(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void escribirArchivo(ArrayList<Cliente> array, File file) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(file));
            salida.writeObject(array);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public ArrayList<Cliente> leerArchivo(File file) {
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
}
