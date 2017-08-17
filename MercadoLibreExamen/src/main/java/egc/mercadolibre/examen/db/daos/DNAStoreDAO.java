package egc.mercadolibre.examen.db.daos;

import egc.mercadolibre.examen.db.entities.DNASample;
import egc.mercadolibre.examen.db.entities.DNAStoreStats;
import egc.mercadolibre.examen.db.session.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

/**
 * Esta clase representa un Data Access Object para las operaciones de base de datos,
 * referentes a el ADN Humano o Mutante
 * @author Eduardo
 */
public class DNAStoreDAO {
    
    private Session session;
    
    /**
     *  El metodo inicializa el objeto obteniendo la session de la configuracion inicial de Hibernate
     */
    public void init() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * Este metodo guarda una muestra de ADN en la base
     * @param dnaSample
     */
    public void saveSample(DNASample dnaSample) {   
        session.beginTransaction();
        try {
            session.save(dnaSample);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        
    }
    
    /**
     * Este metodo obtiene los datos estadisticos de ADN de la base
     * @return
     */
    public DNAStoreStats getStoreStats() {
        DNAStoreStats storeStats = new DNAStoreStats();
        Query query = session.createSQLQuery("SELECT "
                + "SUM(CASE WHEN VALID = 1 THEN 1 ELSE 0 END) AS count_mutant_dna, "
                + "SUM(CASE WHEN VALID = 0 THEN 1 ELSE 0 END) AS count_human_dna, "
                + "SUM(CASE WHEN VALID = 1 THEN 1 ELSE 0 END) / "
                + "DECODE(SUM(CASE WHEN VALID = 0 THEN 1 ELSE 0 END),"
                + "0,"
                + "SUM(CASE WHEN VALID = 1 THEN 1 ELSE 0 END),"
                + "SUM(CASE WHEN VALID = 0 THEN 1 ELSE 0 END)) AS ratio "
                + "FROM DNASTORE");
        query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String,Object>> aliasToValueMapList = query.list();
        
        if (aliasToValueMapList.get(0).get("COUNT_MUTANT_DNA") != null) {
            storeStats.setMutantDNACount(((BigDecimal) aliasToValueMapList.get(0).get("COUNT_MUTANT_DNA")).toString());
            storeStats.setHumanDNACount(((BigDecimal) aliasToValueMapList.get(0).get("COUNT_HUMAN_DNA")).toString());
            storeStats.setRatio(((BigDecimal) aliasToValueMapList.get(0).get("RATIO")).toString());
        } else {
            storeStats.setMutantDNACount("empty");
            storeStats.setHumanDNACount("empty");
            storeStats.setRatio("empty");
        }
            
        return storeStats;
    }
        
    /**
     *  El metodo inicializa el objeto obteniendo la session de la configuracion inicial de Hibernate
     */
    public void destroy() {
        HibernateUtil.shutdown();
    }
}
