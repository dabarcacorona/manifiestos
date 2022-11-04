package cl.corona.manifiestos.scheduler;

import cl.corona.manifiestos.dao.ManifiestoDao;
import cl.corona.manifiestos.model.Manifiesto;
import cl.corona.manifiestos.model.ManifiestoDay;
import cl.corona.manifiestos.model.ManifiestoWeek;
import cl.corona.manifiestos.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Value("${carpeta.baja}")
    private String download;

    @Value("${separador.carpetas}")
    private String separador;

    @Autowired
    private ManifiestoDao dao;

    @Scheduled(cron = "${cron.expression}")
    public void scheduledLog() throws InterruptedException {
        LOG.info("Ejecución Manifiestos Diarios", dateTimeFormatter.format(LocalDateTime.now()));

        String strDir = System.getProperty("user.dir");
        LOG.info("strDir (user.dir) = ({})", strDir);

        final String path = strDir + separador + download + separador;

        // Date exceptions
        LocalDate today = LocalDate.now();
        int count = 0;

        try {

            List<Manifiesto> reporte = dao.getManifiesto();
            Utility.writeInFileFull(reporte, path);

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar los manifiestos diarios: ", e);
            return;
        }

        LOG.info("Fin ejecución", dateTimeFormatter.format(LocalDateTime.now()));

    }


    @Scheduled(cron = "${cron.expression2}")
    public void scheduledLog2() throws InterruptedException {
        LOG.info("Ejecución Manifiestos Semanales", dateTimeFormatter.format(LocalDateTime.now()));

        String strDir = System.getProperty("user.dir");
        LOG.info("strDir (user.dir) = ({})", strDir);

        final String path = strDir + separador + download + separador;

        // Date exceptions
        LocalDate today = LocalDate.now();
        int count = 0;

        try {

            List<ManifiestoWeek> reporteWeek = dao.getManifiestoWeek();
            Utility.writeInFileWeek(reporteWeek, path);

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar los manifiestos: ", e);
            return;
        }

        LOG.info("Fin ejecución", dateTimeFormatter.format(LocalDateTime.now()));

    }

    @Scheduled(cron = "${cron.expression2}")
    public void scheduledLog3() throws InterruptedException {
        LOG.info("Ejecución Manifiestos Semanales TxT", dateTimeFormatter.format(LocalDateTime.now()));

        String strDir = System.getProperty("user.dir");
        LOG.info("strDir (user.dir) = ({})", strDir);

        final String path = strDir + separador + download + separador;

        // Date exceptions
        LocalDate today = LocalDate.now();
        int count = 0;

        try {

            List<ManifiestoDay> reporteDay = dao.getManifiestoDay();
            Utility.writeInFileDay(reporteDay, path);

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar los manifiestos: ", e);
            return;
        }

        LOG.info("Fin ejecución", dateTimeFormatter.format(LocalDateTime.now()));

    }

}
