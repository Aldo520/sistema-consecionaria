/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.InputStream;

/**
 *
 * @author Jonathan Alvarado
 */
public class Usuario {
    private int id;
    private String correo;
    private String nombre_usuario;
    private String contrasenia;
    private String tipo_usuario;
    private String estado_usuario;
    private byte[] foto_perfil;
    private InputStream foto;

    public Usuario() {
    }

    public Usuario(int id, String correo, String nombre_usuario, String contrasenia, String tipo_usuario, String estado_usuario, byte[] foto_perfil, InputStream foto) {
        this.id = id;
        this.correo = correo;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.tipo_usuario = tipo_usuario;
        this.estado_usuario = estado_usuario;
        this.foto_perfil = foto_perfil;
        this.foto = foto;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public byte[] getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(byte[] foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

   
    
}
