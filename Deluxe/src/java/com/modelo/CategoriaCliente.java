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
public class CategoriaCliente {
    private int codigoCatCli;
    private String catClie;

    public CategoriaCliente() {
    }

    public CategoriaCliente(int codigoCatCli, String catClie) {
        this.codigoCatCli = codigoCatCli;
        this.catClie = catClie;
    }

    public String getCatClie() {
        return catClie;
    }

    public void setCatClie(String catClie) {
        this.catClie = catClie;
    }

    public int getCodigoCatCli() {
        return codigoCatCli;
    }

    public void setCodigoCatCli(int codigoCatCli) {
        this.codigoCatCli = codigoCatCli;
    }
    
    
    
}
