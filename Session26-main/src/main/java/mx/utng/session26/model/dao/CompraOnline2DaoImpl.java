package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.CompraOnline2;

@Repository
public class CompraOnline2DaoImpl implements ICompraOnline2Dao {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<CompraOnline2> list() {
        return em.createQuery("from CompraOnline2").getResultList();
    }

    @Override
    public void save(CompraOnline2 compraOnline2) {
        if (compraOnline2.getId() != null && compraOnline2.getId() > 0) {
            em.merge(compraOnline2);
        } else {
            em.persist(compraOnline2);
        }
    }

    @Override
    public CompraOnline2 getById(Long id) {
        return em.find(CompraOnline2.class, id);
    }

    @Override
    public void delete(Long id) {
        CompraOnline2 compraOnline2 = getById(id);
        em.remove(compraOnline2);
    }
}
