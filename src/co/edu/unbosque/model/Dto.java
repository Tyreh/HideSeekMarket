package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.Dao;

import java.io.File;
import java.util.ArrayList;

public class Dto {

    private ArrayList<Cliente> arrayClientes;

    private Dao dao;

    private File file;

    private Archivo archivo;

    public Dto() {
        file = new File("data/clientes.dat");
        arrayClientes = new ArrayList<>();
        archivo = new Archivo(file);
        dao = new Dao(archivo);
    }

    public ArrayList<Cliente> getArrayClientes() {
        return arrayClientes;
    }

    public void setArrayClientes(ArrayList<Cliente> arrayClientes) {
        this.arrayClientes = arrayClientes;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
}
