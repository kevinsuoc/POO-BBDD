package util;

import modelo.Federacion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.JdbcSettings.*;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;

public class HibernateUtil {
    private static SessionFactory sessionFactory = new Configuration().
            addAnnotatedClass(Federacion.class).
            setProperty("hibernate.hbm2ddl.auto", "validate").
            setProperty(URL, "jdbc:mysql://localhost:3306/senderosymontanas").
            setProperty(USER, "dataroast").
            setProperty(PASS, "dataroastpassword").
            setProperty(SHOW_SQL, true)
            .setProperty(FORMAT_SQL, true)
            .setProperty(HIGHLIGHT_SQL, true).
            buildSessionFactory();


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}