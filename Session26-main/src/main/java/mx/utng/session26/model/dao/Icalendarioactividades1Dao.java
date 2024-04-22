package mx.utng.session26.model.dao;

import java.util.List;
import mx.utng.session26.model.entity.calendarioactividades1;

public interface Icalendarioactividades1Dao {
    List<calendarioactividades1> list();
    void save(calendarioactividades1 calendarioactividades1);
    calendarioactividades1 getById(Long id);
    void delete(Long id);
}
