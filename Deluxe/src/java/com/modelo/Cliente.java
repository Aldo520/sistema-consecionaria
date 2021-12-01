/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author Jonathan Alvarado
 */
public class Cliente {
    private int ID;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String documento;
    private String sexo;
    private int ID_Us;
    private String nombre_usuario;
    private int ID_Cat;
    private String cat_cliente;

    public Cliente() {
    }

    public Cliente(int ID, String nombres, String apellidos, String telefono, String direccion, String documento, String sexo, int ID_Us, String nombre_usuario, int ID_Cat, String cat_cliente) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.documento = documento;
        this.sexo = sexo;
        this.ID_Us = ID_Us;
        this.nombre_usuario = nombre_usuario;
        this.ID_Cat = ID_Cat;
        this.cat_cliente = cat_cliente;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getID_Us() {
        return ID_Us;
    }

    public void setID_Us(int ID_Us) {
        this.ID_Us = ID_Us;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getID_Cat() {
        return ID_Cat;
    }

    public void setID_Cat(int ID_Cat) {
        this.ID_Cat = ID_Cat;
    }

    public String getCat_cliente() {
        return cat_cliente;
    }

    public void setCat_cliente(String cat_cliente) {
        this.cat_cliente = cat_cliente;
    }
    
    
    
}
