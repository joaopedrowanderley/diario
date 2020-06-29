/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.model;

import java.util.Date;

/**
 *
 * @author joão pedro
 */
public class Anotacao {
    private Date data;
    private String texto;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(data)
                .append(" - ")
                .append(texto);
        return sb.toString();
    }
    
}
