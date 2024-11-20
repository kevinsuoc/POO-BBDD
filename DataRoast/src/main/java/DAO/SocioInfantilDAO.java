package DAO;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import modelo.SocioInfantil;
import org.hibernate.SessionFactory;
import util.DataErrorException;
import util.HibernateUtil;
import util.MysqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocioInfantilDAO extends SocioDAO implements DAOInterface<SocioInfantil, Integer> {

    @Override
    public SocioInfantil insert(SocioInfantil socio) {
        try {
            HibernateUtil.getSessionFactory().inTransaction(session -> {
                session.persist(socio);
            });
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            throw new DataErrorException("Error agregando socio");
        }
        return socio;
    }

    @Override
    public SocioInfantil find(Integer id) {
        try {
            return HibernateUtil.getSessionFactory().fromTransaction(session -> {
                return session.find(SocioInfantil.class, id);
            });
        } catch (Exception e){
            throw new DataErrorException("Error buscando socio");
        }

    }

    @Override
    public List<SocioInfantil> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            return sessionFactory.fromTransaction(session -> {
                var builder = sessionFactory.getCriteriaBuilder();
                CriteriaQuery<SocioInfantil> query = builder.createQuery(SocioInfantil.class);
                Root<SocioInfantil> socioInfantil = query.from(SocioInfantil.class);
                query.select(socioInfantil);
                return session.createSelectionQuery(query).getResultList();
            });
        } catch (Exception e) {
            throw new DataErrorException("Error buscando socios");
        }
    }

    @Override
    public SocioInfantil update(SocioInfantil socio) {
        try {
            return HibernateUtil.getSessionFactory().fromTransaction(session -> {
                return session.merge(socio);
            });
        } catch (Exception e){
            throw new DataErrorException("Error actualizando socio");
        }
    }
}
