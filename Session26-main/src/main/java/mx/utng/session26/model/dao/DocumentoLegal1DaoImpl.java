package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.DocumentoLegal1;

@Repository
public class DocumentoLegal1DaoImpl implements IDocumentoLegal1Dao {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<DocumentoLegal1> list() {
        return em.createQuery("from DocumentoLegal1").getResultList();
    }

    @Override
    public void save(DocumentoLegal1 documentoLegal1) {
        if (documentoLegal1.getId() != null && !documentoLegal1.getId().isEmpty()) {
            em.merge(documentoLegal1);
        } else {
            em.persist(documentoLegal1);
        }
    }

    @Override
    public DocumentoLegal1 getById(String id) {
        return em.find(DocumentoLegal1.class, id);
    }

    @Override
    public void delete(String id) {
        DocumentoLegal1 documentoLegal1 = getById(id);
        em.remove(documentoLegal1);
    }
}
