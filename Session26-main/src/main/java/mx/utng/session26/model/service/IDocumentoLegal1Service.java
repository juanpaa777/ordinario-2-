package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.DocumentoLegal1;
import java.util.List;

public interface IDocumentoLegal1Service {
    List<DocumentoLegal1> list();
    void save(DocumentoLegal1 documentoLegal1);
    DocumentoLegal1 getById(String id);
    void delete(String id);
}
