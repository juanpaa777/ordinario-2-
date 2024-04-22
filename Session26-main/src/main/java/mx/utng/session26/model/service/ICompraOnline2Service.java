package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.CompraOnline2;
import java.util.List;

public interface ICompraOnline2Service {
    List<CompraOnline2> list();
    void save(CompraOnline2 compraOnline2);
    CompraOnline2 getById(Long id);
    void delete(Long id);
}
