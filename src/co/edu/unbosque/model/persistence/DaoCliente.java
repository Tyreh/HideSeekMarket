package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Pareja;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DaoCliente {

    private final Archivo archivo;

    public DaoCliente(Archivo archivo) {
        this.archivo = archivo;
    }

    public boolean agregarCliente(ArrayList<Cliente> arrayClientes, File file, String usuario, String clave, String nombres, String apellidos, String correo, String genero, String fechaNacimiento, long saldo, ArrayList<Pareja> parejas, String binTarjeta, int codigoTarjeta) {
        Cliente nuevoCliente = new Cliente(usuario, clave, nombres, apellidos, correo, genero, fechaNacimiento, saldo, parejas, binTarjeta, codigoTarjeta);

        if (buscarCliente(arrayClientes, usuario) == null) {
            arrayClientes.add(nuevoCliente);
            archivo.escribirArchivoCliente(arrayClientes, file);
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
                archivo.escribirArchivoCliente(arrayClientes, file);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarCliente(ArrayList<Cliente> arrayClientes, File file, String usuario, String clave, String nombres, String apellidos, String correo, String genero, String fechaNacimiento, long saldo, int codigoTarjeta) {
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
                existente.setCodigoTarjeta(codigoTarjeta);
                arrayClientes.add(existente);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivoCliente(arrayClientes, file);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarCliente(ArrayList<Cliente> arrayClientes, File file, String usuario, ArrayList<Pareja> arrayParejas) {
        try {
            Cliente existente = buscarCliente(arrayClientes, usuario);
            if (existente != null) {
                eliminarCliente(arrayClientes, file, usuario);
                existente.setParejas(arrayParejas);
                arrayClientes.add(existente);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivoCliente(arrayClientes, file);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean agregarPareja(ArrayList<Cliente> arrayClientes, File file, ArrayList<Pareja> arrayParejas, String usuario, int id, String nombres, String apellidos, String genero, String fechaNacimiento, long saldo) {
        Pareja nuevaPareja = new Pareja(id, nombres, apellidos, genero, fechaNacimiento, saldo);

        if (buscarPareja(arrayParejas, id) == null) {
            arrayParejas.add(nuevaPareja);
            modificarCliente(arrayClientes, file, usuario, arrayParejas);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarPareja(ArrayList<Cliente> arrayClientes, File file, ArrayList<Pareja> arrayParejas, String usuario, int id) {
        try {
            Cliente cliente = buscarCliente(arrayClientes, usuario);
            if (cliente == null) {
                return false;
            } else {
                Pareja pareja = buscarPareja(arrayParejas, id);
                if (pareja == null) {
                    return false;
                } else {
                    arrayParejas.remove(pareja);
                    file.delete();
                    file.createNewFile();
                    archivo.escribirArchivoCliente(arrayClientes, file);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarPareja(ArrayList<Cliente> arrayClientes, File file, ArrayList<Pareja> arrayParejas, String usuario, int id, String nombres, String apellidos, String genero, String fechaNacimiento, long saldo) {
        try {
            Cliente cliente = buscarCliente(arrayClientes, usuario);
            if (cliente != null) {
                Pareja pareja = buscarPareja(arrayParejas, id);
                if (pareja != null) {
                    eliminarPareja(arrayClientes, file, arrayParejas, usuario, id);
                    pareja.setNombres(nombres);
                    pareja.setApellidos(apellidos);
                    pareja.setGenero(genero);
                    pareja.setFechaNacimiento(fechaNacimiento);
                    pareja.setSaldo(saldo);
                    arrayParejas.add(pareja);
                    file.delete();
                    file.createNewFile();
                    archivo.escribirArchivoCliente(arrayClientes, file);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pareja buscarPareja(ArrayList<Pareja> arrayParejas, int id) {
        Pareja existente = null;

        if (!arrayParejas.isEmpty()) {
            for (Pareja pareja : arrayParejas) {
                if (pareja.getId() == id) {
                    existente = pareja;
                }
            }
        }
        return existente;
    }
}
