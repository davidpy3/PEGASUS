package xample2;

import com.jcg.*;


public class Encabezado {
    
//    public static final String EJECUTORA = "001102";
//    public static final String ANO_EJE = "2015";
   String ejecutora="001102";
   String ano_eje;
   String tipo_planilla;
   String clase_planilla;
   String correlativo_planilla;
   String n_registros;
   Double total_ingreso;
   Double total_Descuento;
   Double total_aporte;
   Double total_reintegro;
   Double total_encargatura;
   Double otros_ingresos;

    public Encabezado(String ano_eje, String tipo_planilla, String clase_planilla, String correlativo_planilla, String n_registros, Double total_ingreso, Double total_Descuento, Double total_aporte, Double total_reintegro, Double total_encargatura, Double otros_ingresos) {
        this.ano_eje = ano_eje;
        this.tipo_planilla = tipo_planilla;
        this.clase_planilla = clase_planilla;
        this.correlativo_planilla = correlativo_planilla;
        this.n_registros = n_registros;
        this.total_ingreso = total_ingreso;
        this.total_Descuento = total_Descuento;
        this.total_aporte = total_aporte;
        this.total_reintegro = total_reintegro;
        this.total_encargatura = total_encargatura;
        this.otros_ingresos = otros_ingresos;
    }

    public String getEjecutora() {
        return ejecutora;
    }

    public void setEjecutora(String ejecutora) {
        this.ejecutora = ejecutora;
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getTipo_planilla() {
        return tipo_planilla;
    }

    public void setTipo_planilla(String tipo_planilla) {
        this.tipo_planilla = tipo_planilla;
    }

    public String getClase_planilla() {
        return clase_planilla;
    }

    public void setClase_planilla(String clase_planilla) {
        this.clase_planilla = clase_planilla;
    }

    public String getCorrelativo_planilla() {
        return correlativo_planilla;
    }

    public void setCorrelativo_planilla(String correlativo_planilla) {
        this.correlativo_planilla = correlativo_planilla;
    }

    public String getN_registros() {
        return n_registros;
    }

    public void setN_registros(String n_registros) {
        this.n_registros = n_registros;
    }

    public Double getTotal_ingreso() {
        return total_ingreso;
    }

    public void setTotal_ingreso(Double total_ingreso) {
        this.total_ingreso = total_ingreso;
    }

    public Double getTotal_Descuento() {
        return total_Descuento;
    }

    public void setTotal_Descuento(Double total_Descuento) {
        this.total_Descuento = total_Descuento;
    }

    public Double getTotal_aporte() {
        return total_aporte;
    }

    public void setTotal_aporte(Double total_aporte) {
        this.total_aporte = total_aporte;
    }

    public Double getTotal_reintegro() {
        return total_reintegro;
    }

    public void setTotal_reintegro(Double total_reintegro) {
        this.total_reintegro = total_reintegro;
    }

    public Double getTotal_encargatura() {
        return total_encargatura;
    }

    public void setTotal_encargatura(Double total_encargatura) {
        this.total_encargatura = total_encargatura;
    }

    public Double getOtros_ingresos() {
        return otros_ingresos;
    }

    public void setOtros_ingresos(Double otros_ingresos) {
        this.otros_ingresos = otros_ingresos;
    }

    @Override
    public String toString() {
        return "Encabezado{" + "ejecutora=" + ejecutora + ", ano_eje=" + ano_eje + ", tipo_planilla=" + tipo_planilla + ", clase_planilla=" + clase_planilla + ", correlativo_planilla=" + correlativo_planilla + ", n_registros=" + n_registros + ", total_ingreso=" + total_ingreso + ", total_Descuento=" + total_Descuento + ", total_aporte=" + total_aporte + ", total_reintegro=" + total_reintegro + ", total_encargatura=" + total_encargatura + ", otros_ingresos=" + otros_ingresos + '}';
    }
    
    
    
}
