package mx.utng.session26.model.dao;

import java.util.List;
import mx.utng.session26.model.entity.DocumentoLegal1;

public interface IDocumentoLegal1Dao {
    List<DocumentoLegal1> list();
    void save(DocumentoLegal1 documentoLegal1);
    DocumentoLegal1 getById(String id);
    void delete(String id);
}
