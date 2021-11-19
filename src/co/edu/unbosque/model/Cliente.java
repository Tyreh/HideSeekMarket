package co.edu.unbosque.model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String usuario;

    private String clave;

    private String nombres;

    private String apellidos;

    private String correo;

    private String genero;

    private String fechaNacimiento;

    private long saldo;

    public Cliente(String usuario, String clave, String nombres, String apellidos, String correo, String genero, String fechaNacimiento, long saldo) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}
