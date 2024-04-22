package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.calendarioactividades1;

@Repository
public class calendarioactividades1DaoImpl implements Icalendarioactividades1Dao {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<calendarioactividades1> list() {
        return em.createQuery("from calendarioactividades1").getResultList();
    }

    @Override
    public void save(calendarioactividades1 calendarioactividades1) {
        if (calendarioactividades1.getId() != null && calendarioactividades1.getId() > 0) {
            em.merge(calendarioactividades1);
        } else {
            em.persist(calendarioactividades1);
        }
    }

    @Override
    public calendarioactividades1 getById(Long id) {
        return em.find(calendarioactividades1.class, id);
    }

    @Override
    public void delete(Long id) {
        calendarioactividades1 calendarioactividades1 = getById(id);
        em.remove(calendarioactividades1);
    }
}
