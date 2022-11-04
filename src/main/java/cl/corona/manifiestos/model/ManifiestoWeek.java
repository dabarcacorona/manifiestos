package cl.corona.manifiestos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "MNFST_PEND_WEEK", procedureName = "PMM_MNFST_PENDIENTES_SEMANAL", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "C1", type = Class.class)})})

public class ManifiestoWeek {

    @Id
    @JsonIgnore

    private int id;

    public int id_origen;

    private int lista_carga;

    private Date fecha_ingreso;

    private Date fecha_emision;

    private int tot_lpn;

    private int tot_uni;

    private Date fecha_recepcion;

    private int destino;

    private String desc_zona;

    private String estado;

    private String mnfst;

    public ManifiestoWeek()  {
        super();
    }

    public ManifiestoWeek(int id, int id_origen, int lista_carga, Date fecha_ingreso, Date fecha_emision, int tot_lpn, int tot_uni, Date fecha_recepcion, int destino, String desc_zona, String estado, String mnfst) {
        this.id = id;
        this.id_origen = id_origen;
        this.lista_carga = lista_carga;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_emision = fecha_emision;
        this.tot_lpn = tot_lpn;
        this.tot_uni = tot_uni;
        this.fecha_recepcion = fecha_recepcion;
        this.destino = destino;
        this.desc_zona = desc_zona;
        this.estado = estado;
        this.mnfst = mnfst;
    }

    @Override
    public String toString() {
        return "ManifiestoWeek{" +
                "id=" + id +
                ", id_origen=" + id_origen +
                ", lista_carga=" + lista_carga +
                ", fecha_ingreso=" + fecha_ingreso +
                ", fecha_emision=" + fecha_emision +
                ", tot_lpn=" + tot_lpn +
                ", tot_uni=" + tot_uni +
                ", fecha_recepcion=" + fecha_recepcion +
                ", destino=" + destino +
                ", desc_zona='" + desc_zona + '\'' +
                ", estado='" + estado + '\'' +
                ", mnfst='" + mnfst + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_origen() {
        return id_origen;
    }

    public void setId_origen(int id_origen) {
        this.id_origen = id_origen;
    }

    public int getLista_carga() {
        return lista_carga;
    }

    public void setLista_carga(int lista_carga) {
        this.lista_carga = lista_carga;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public int getTot_lpn() {
        return tot_lpn;
    }

    public void setTot_lpn(int tot_lpn) {
        this.tot_lpn = tot_lpn;
    }

    public int getTot_uni() {
        return tot_uni;
    }

    public void setTot_uni(int tot_uni) {
        this.tot_uni = tot_uni;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public String getDesc_zona() {
        return desc_zona;
    }

    public void setDesc_zona(String desc_zona) {
        this.desc_zona = desc_zona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMnfst() {
        return mnfst;
    }

    public void setMnfst(String mnfst) {
        this.mnfst = mnfst;
    }
}
