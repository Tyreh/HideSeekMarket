package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.DaoCliente;
import co.edu.unbosque.model.persistence.DaoProducto;
import co.edu.unbosque.model.persistence.DaoTienda;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Dto {

    private final Random random;

    private final Date date;

    private final Calendar calendar;

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

        random = new Random();
        date = new Date();
        calendar = Calendar.getInstance();
    }

    public String generarBin() {
        int bin1 = 1000 + random.nextInt(9000);
        int bin2 = 1000 + random.nextInt(9000);
        int bin3 = 1000 + random.nextInt(9000);
        int bin4 = 1000 + random.nextInt(9000);
        String finalBin = "" + bin1 + bin2 + bin3 + bin4;

        for (Cliente cliente : arrayClientes) {
            if (cliente.getBinTarjeta().equals(finalBin)) {
                generarBin();
            }
        }

        return finalBin;
    }

    public int generarCodigo() {
        return (100 + random.nextInt(900));
    }

    public int generarMesCaducidad() {
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public int generarAnioCaducidad() {
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + 4;
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
