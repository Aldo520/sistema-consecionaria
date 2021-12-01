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
public class Mispedidos extends Pedidos{

    /**
     * @return the detalle
     */
    public int getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }

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
     * @return the nombrecliente
     */
    public String getNombrecliente() {
        return nombrecliente;
    }

    /**
     * @param nombrecliente the nombrecliente to set
     */
    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }
    
    private int detalle;
    private String modelo;
    private String nombrecliente;
}
