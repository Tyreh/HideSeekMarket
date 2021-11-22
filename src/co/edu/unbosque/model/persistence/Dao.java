package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Pareja;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Dao {

    private final Archivo archivo;

    public Dao(Archivo archivo) {
        this.archivo = archivo;
    }

    public boolean agregarCliente(ArrayList<Cliente> arrayClientes, File file, String usuario, String clave, String nombres, String apellidos, String correo, String genero, String fechaNacimiento, long saldo, ArrayList<Pareja> parejas, int binTarjeta, int mesCaducidadTarjeta, int anioCaducidadTarjeta, int codigoTarjeta) {
        Cliente nuevoCliente = new Cliente(usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento, saldo, parejas, binTarjeta, mesCaducidadTarjeta, anioCaducidadTarjeta, codigoTarjeta);

        if (buscarCliente(arrayClientes, usuario) == null) {
            arrayClientes.add(nuevoCliente);
            archivo.escribirArchivo(arrayClientes, file);
            return true;
        } else {
            return false;
        }
    }

    public Cliente buscarCliente(ArrayList<Cliente> arrayClientes, String usuario) {
        Cliente existente = null;

        if (!arrayClientes.isEmpty()) {
            for (Cliente cliente : arrayClientes) {
                if (cliente.getUsuario().equals(usuario)) {
                    existente = cliente;
                }
            }
        }
        return existente;
    }

    public boolean eliminarCliente(ArrayList<Cliente> arrayClientes, File file, String usuario) {
        try {
            Cliente cliente = buscarCliente(arrayClientes, usuario);
            if (cliente == null) {
                return false;
            } else {
                arrayClientes.remove(cliente);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivo(arrayClientes, file);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarCliente(ArrayList<Cliente> arrayClientes, File file, String usuario, String clave, String nombres, String apellidos, String correo, String genero, String fechaNacimiento, long saldo, ArrayList<Pareja> parejas, int binTarjeta, int mesCaducidadTarjeta, int anioCaducidadTarjeta, int codigoTarjeta) {
        try {
            Cliente existente = buscarCliente(arrayClientes, usuario);
            if (existente != null) {
                eliminarCliente(arrayClientes, file, usuario);
                existente.setClave(clave);
                existente.setNombres(nombres);
                existente.setApellidos(apellidos);
                existente.setCorreo(correo);
                existente.setGenero(genero);
                existente.setFechaNacimiento(fechaNacimiento);
                existente.setSaldo(saldo);
                existente.setParejas(parejas);
                existente.setBinTarjeta(binTarjeta);
                existente.setMesCaducidadTarjeta(mesCaducidadTarjeta);
                existente.setAnioCaducidadTarjeta(anioCaducidadTarjeta);
                existente.setCodigoTarjeta(codigoTarjeta);
                arrayClientes.add(existente);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivo(arrayClientes, file);
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
