package mx.utng.session26.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.IDocumentoLegal1Dao;
import mx.utng.session26.model.entity.DocumentoLegal1;

@Service
public class DocumentoLegal1ServiceImpl implements IDocumentoLegal1Service {

    @Autowired
    private IDocumentoLegal1Dao dao;

    @Transactional(readOnly = true)
    @Override
    public List<DocumentoLegal1> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(DocumentoLegal1 documentoLegal1) {
        dao.save(documentoLegal1);
    }

    @Transactional(readOnly = true)
    @Override
    public DocumentoLegal1 getById(String id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}
