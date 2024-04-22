package mx.utng.session26.model.dao;

import java.util.List;
import mx.utng.session26.model.entity.CompraOnline2;

public interface ICompraOnline2Dao {
    List<CompraOnline2> list();
    void save(CompraOnline2 compraOnline2);
    CompraOnline2 getById(Long id);
    void delete(Long id);
}
