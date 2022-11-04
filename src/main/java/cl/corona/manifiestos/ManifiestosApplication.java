package cl.corona.manifiestos;

import cl.corona.manifiestos.dao.ManifiestoDao;
import cl.corona.manifiestos.model.Manifiesto;
import cl.corona.manifiestos.util.Utility;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Calendar;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class ManifiestosApplication {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ManifiestosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ManifiestosApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(ManifiestoDao dao) {
//		return (args) -> {
//
//			logger.info("Hora de inicio: " + Calendar.getInstance().getTime().toString());
//
//			List<Manifiesto> reporte = dao.getManifiesto();
//
//			logger.info("Hora de termino: " + Calendar.getInstance().getTime().toString());
//
//			Utility.writeInFileFull(reporte);
//		};
//	}
}
