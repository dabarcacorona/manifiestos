package cl.corona.manifiestos.util;

import cl.corona.manifiestos.model.Manifiesto;
import cl.corona.manifiestos.model.ManifiestoDay;
import cl.corona.manifiestos.model.ManifiestoWeek;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Utility {

    private static final Logger LOG = LoggerFactory.getLogger(Utility.class);

    private static final String dmySlashFormat = "dd/MM/yyyy";



    private Utility() {
        throw new IllegalStateException("This is an Utility class. Is not meant to be instantiated");
    }

    public static Integer convertToInt(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).intValue();
        } else if (obj instanceof String) {
            return Integer.valueOf((String) obj);
        }
        return 0;
    }

    public static void writeInFileFull(List<Manifiesto> reportes, String path) {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String monthReport = df.format(new Date());

        try {
            FileWriter fileWriter1 = new FileWriter(path + "MANIFIESTOS_TDA_TDA_" + monthReport + ".csv");
            fileWriter1.write("ID_ORIGEN;LISTA_CARGA;FECHA_INGRESO;FECHA_EMISION;TOT_LPN;TOT_UNI;FECHA_RECEPCION;DESTINO;DESC_ZONA;ESTADO;MNFST\n");
            for (Manifiesto report : reportes) {
                fileWriter1.write(
                        report.getId_origen() + ";" +  report.getLista_carga() + ";" +  report.getFecha_ingreso() + ";" +  report.getFecha_emision() + ";" +  report.getTot_lpn() + ";" +  report.getTot_uni() +
                                ";" +  report.getFecha_recepcion() + ";" +  report.getDestino() + ";" +  report.getDesc_zona() + ";" +  report.getEstado() + ";" +  report.getMnfst() + "\n");
            }
            fileWriter1.close();

        } catch (IOException e) {
            LOG.error("Problems when writing full file. " + e.getMessage());
        }
    }

    public static void writeInFileWeek(List<ManifiestoWeek> reportes, String path) {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String monthReport = df.format(new Date());

        try {
            FileWriter fileWriter2 = new FileWriter(path + "MANIFIESTOS_SEMANAL_CD_TIENDA_" + monthReport + ".csv");
            fileWriter2.write("ID_ORIGEN;LISTA_CARGA;FECHA_INGRESO;FECHA_EMISION;TOT_LPN;TOT_UNI;FECHA_RECEPCION;DESTINO;DESC_ZONA;ESTADO;MNFST\n");
            for (ManifiestoWeek report : reportes) {
                fileWriter2.write(
                        report.getId_origen() + ";" +  report.getLista_carga() + ";" +  report.getFecha_ingreso() + ";" +  report.getFecha_emision() + ";" +  report.getTot_lpn() + ";" +  report.getTot_uni() +
                                ";" +  report.getFecha_recepcion() + ";" +  report.getDestino() + ";" +  report.getDesc_zona() + ";" +  report.getEstado() + ";" +  report.getMnfst() + "\n");
            }
            fileWriter2.close();

        } catch (IOException e) {
            LOG.error("Problems when writing full file. " + e.getMessage());
        }
    }

    public static void writeInFileDay(List<ManifiestoDay> reportes, String path) {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String monthReport = df.format(new Date());

        try {
            FileWriter fileWriter3 = new FileWriter(path + "MANIFIESTOS_SEMANAL_TIENDA_TIENDA_" + monthReport + ".csv");
            fileWriter3.write("ID_ORIGEN;LISTA_CARGA;FECHA_INGRESO;FECHA_EMISION;TOT_LPN;TOT_UNI;FECHA_RECEPCION;DESTINO;DESC_ZONA;ESTADO;MNFST\n");
            for (ManifiestoDay report : reportes) {
                fileWriter3.write(
                        report.getId_origen() + ";" +  report.getLista_carga() + ";" +  report.getFecha_ingreso() + ";" +  report.getFecha_emision() + ";" +  report.getTot_lpn() + ";" +  report.getTot_uni() +
                                ";" +  report.getFecha_recepcion() + ";" +  report.getDestino() + ";" +  report.getDesc_zona() + ";" +  report.getEstado() + ";" +  report.getMnfst() + "\n");
            }
            fileWriter3.close();

        } catch (IOException e) {
            LOG.error("Problems when writing full file. " + e.getMessage());
        }
    }


}
