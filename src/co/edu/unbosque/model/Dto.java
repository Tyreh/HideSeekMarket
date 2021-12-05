package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.DaoCliente;
import co.edu.unbosque.model.persistence.DaoProducto;
import co.edu.unbosque.model.persistence.DaoTienda;

import java.io.File;
import java.util.ArrayList;

public class Dto {

    private ArrayList<Cliente> arrayClientes;

    private ArrayList<Producto> arrayProductos;

    private ArrayList<Producto> arrayProductosCarrito;

    private ArrayList<Tienda> arrayTiendas;

    private DaoCliente daoCliente;

    private DaoProducto daoProducto;

    private DaoTienda daoTienda;

    private File fileClientes;

    private File fileProductos;

    private File fileTiendas;

    private Archivo archivo;

    private GeneradorTarjetas generadorTarjetas;

    public Dto() {
        fileClientes = new File("data/clientes.dat");
        fileProductos = new File("data/productos.dat");
        fileTiendas = new File("data/tiendas.dat");

        arrayClientes = new ArrayList<>();
        arrayTiendas = new ArrayList<>();
        arrayProductosCarrito = new ArrayList<>();
        arrayProductos = new ArrayList<>();

        archivo = new Archivo(fileClientes, fileProductos, fileTiendas);

        daoCliente = new DaoCliente(archivo);
        daoProducto = new DaoProducto(archivo);
        daoTienda = new DaoTienda(archivo);

        arrayClientes = archivo.leerArchivoCliente(fileClientes);
        arrayProductos = archivo.leerArchivoProducto(fileProductos);
        arrayTiendas = archivo.leerArchivoTienda(fileTiendas);

/*        int[] test = new int[arrayProductos.size()];

        for (int i = 0; i < arrayProductos.size(); i++) {
            Producto producto = arrayProductos.get(i);
            test[i] = producto.getIdProducto();
        }

        quicksort(test, 0, arrayClientes.size() - 1);*/

        generadorTarjetas = new GeneradorTarjetas(this);
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

    public ArrayList<Cliente> getArrayClientes() {
        return arrayClientes;
    }

    public void setArrayClientes(ArrayList<Cliente> arrayClientes) {
        this.arrayClientes = arrayClientes;
    }

    public ArrayList<Producto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(ArrayList<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    public ArrayList<Tienda> getArrayTiendas() {
        return arrayTiendas;
    }

    public void setArrayTiendas(ArrayList<Tienda> arrayTiendas) {
        this.arrayTiendas = arrayTiendas;
    }

    public DaoCliente getDaoCliente() {
        return daoCliente;
    }

    public void setDaoCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public DaoProducto getDaoProducto() {
        return daoProducto;
    }

    public void setDaoProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public DaoTienda getDaoTienda() {
        return daoTienda;
    }

    public void setDaoTienda(DaoTienda daoTienda) {
        this.daoTienda = daoTienda;
    }

    public File getFileClientes() {
        return fileClientes;
    }

    public void setFileClientes(File fileClientes) {
        this.fileClientes = fileClientes;
    }

    public File getFileProductos() {
        return fileProductos;
    }

    public void setFileProductos(File fileProductos) {
        this.fileProductos = fileProductos;
    }

    public File getFileTiendas() {
        return fileTiendas;
    }

    public void setFileTiendas(File fileTiendas) {
        this.fileTiendas = fileTiendas;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public GeneradorTarjetas getGeneradorTarjetas() {
        return generadorTarjetas;
    }

    public void setGeneradorTarjetas(GeneradorTarjetas generadorTarjetas) {
        this.generadorTarjetas = generadorTarjetas;
    }

    public ArrayList<Producto> getArrayProductosCarrito() {
        return arrayProductosCarrito;
    }
}
