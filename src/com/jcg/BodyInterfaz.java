/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcg;

/**
 *
 * @author administrator
 */
public class BodyInterfaz {
    
  String tipo_doc;
    String dni;
    String fuente_financ;
    String ind;
    String codigo;
    String descripcion;
    Double monto;
    String planilla;

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFuente_financ() {
        return fuente_financ;
    }

    public void setFuente_financ(String fuente_financ) {
        this.fuente_financ = fuente_financ;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descri) {
        this.descripcion = descri;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlnailla(String planilla) {
        this.planilla = planilla;
    }

    @Override
    public String toString() {
        //return  "tipo_doc=" + tipo_doc + ", dni=" + dni + ", fuente_financ=" + fuente_financ + ", ind=" + ind + ", codigo=" + codigo + ", monto=" + monto;
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%.2f",tipo_doc , dni, fuente_financ,ind,codigo,descripcion,monto);
    }

    
    
}
