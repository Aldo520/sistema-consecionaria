/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author Aldo
 */
public class Automovil {

    /**
     * @return the Codigo_Motor
     */
    public String getCodigo_Motor() {
        return Codigo_Motor;
    }

    /**
     * @param Codigo_Motor the Codigo_Motor to set
     */
    public void setCodigo_Motor(String Codigo_Motor) {
        this.Codigo_Motor = Codigo_Motor;
    }

    /**
     * @return the Especificacion
     */
    public int getEspecificacion() {
        return Especificacion;
    }

    /**
     * @param Especificacion the Especificacion to set
     */
    public void setEspecificacion(int Especificacion) {
        this.Especificacion = Especificacion;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * @return the Version
     */
    public String getVersion() {
        return Version;
    }

    /**
     * @param Version the Version to set
     */
    public void setVersion(String Version) {
        this.Version = Version;
    }

    /**
     * @return the Transmision
     */
    public String getTransmision() {
        return Transmision;
    }

    /**
     * @param Transmision the Transmision to set
     */
    public void setTransmision(String Transmision) {
        this.Transmision = Transmision;
    }

   
    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
   private String Codigo_Motor;
   private int Especificacion;
   private int color;
   private String Version;
   private String Transmision;
   private double precio;
   private String modelo;
   private String Estado;

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
