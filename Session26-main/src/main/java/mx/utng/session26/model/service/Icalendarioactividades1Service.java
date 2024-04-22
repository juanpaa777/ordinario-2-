package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.calendarioactividades1;
import java.util.List;

public interface Icalendarioactividades1Service {
    List<calendarioactividades1> list();
    void save(calendarioactividades1 calendarioactividades1);
    calendarioactividades1 getById(Long id);
    void delete(Long id);
}
