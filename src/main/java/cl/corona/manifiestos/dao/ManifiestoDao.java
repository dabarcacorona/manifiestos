package cl.corona.manifiestos.dao;

import cl.corona.manifiestos.model.Manifiesto;
import cl.corona.manifiestos.model.ManifiestoDay;
import cl.corona.manifiestos.model.ManifiestoWeek;
import cl.corona.manifiestos.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class ManifiestoDao {

    private static final Logger logger = LoggerFactory.getLogger(ManifiestoDao.class);

    @Autowired
    private EntityManager em;

    public List<Manifiesto> getManifiesto() {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MNFST_PEND");
        if (spq == null) {
            logger.debug("Problems in the DB with the Stored Procedure");
            return Collections.emptyList();
        }
        List<Object[]> rows = spq.getResultList();

        List<Manifiesto> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(
                    new Manifiesto(0, Utility.convertToInt(row[0]), Utility.convertToInt(row[1]), (Date) row[2], (Date) row[3], Utility.convertToInt(row[4]),
                            Utility.convertToInt(row[5]), (Date) row[6], Utility.convertToInt(row[7]), (String) row[8], (String) row[9], (String) row[10]));
        }
        return result;
    }


    public List<ManifiestoWeek> getManifiestoWeek() {

    StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MNFST_PEND_WEEK");
        if(spq ==null)

    {
        logger.debug("Problems in the DB with the Stored Procedure");
        return Collections.emptyList();
    }

    List<Object[]> rows = spq.getResultList();

    List<ManifiestoWeek> result = new ArrayList<>(rows.size());
        for(
    Object[] row :rows)

    {
        result.add(
                new ManifiestoWeek(0, Utility.convertToInt(row[0]), Utility.convertToInt(row[1]), (Date) row[2], (Date) row[3], Utility.convertToInt(row[4]),
                        Utility.convertToInt(row[5]), (Date) row[6], Utility.convertToInt(row[7]), (String) row[8], (String) row[9], (String) row[10]));
    }
        return result;

    }

    public List<ManifiestoDay> getManifiestoDay() {

        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("MNFST_PEND_DAY");
        if(spq ==null)

        {
            logger.debug("Problems in the DB with the Stored Procedure");
            return Collections.emptyList();
        }

        List<Object[]> rows = spq.getResultList();

        List<ManifiestoDay> result = new ArrayList<>(rows.size());
        for(
                Object[] row :rows)

        {
            result.add(
                    new ManifiestoDay(0, Utility.convertToInt(row[0]), Utility.convertToInt(row[1]), (Date) row[2], (Date) row[3], Utility.convertToInt(row[4]),
                            Utility.convertToInt(row[5]), (Date) row[6], Utility.convertToInt(row[7]), (String) row[8], (String) row[9], (String) row[10]));
        }
        return result;

    }
}
