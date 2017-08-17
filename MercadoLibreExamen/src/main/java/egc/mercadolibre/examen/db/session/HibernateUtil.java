package egc.mercadolibre.examen.db.session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase Utilitaria empleada para crear y destruir la Session con la base utilizando la configuracion
 * existente en el archivo hibernate.cfg.xml dentro de src/main/resources
 * @author Eduardo
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

    /**
     * Obtiene la Session luego de invocar buildSessionFactory para generarla
     * @return
     */
    public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

    /**
     * Cierra la Session para liberar la cache y el pool de conexiones
     */
    public static void shutdown() {
		getSessionFactory().close();
	}

}