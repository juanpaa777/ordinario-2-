package mx.utng.session26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.Icalendarioactividades1Dao;
import mx.utng.session26.model.entity.calendarioactividades1;

@Service
public class calendarioactividades1ServiceImpl implements Icalendarioactividades1Service {

    @Autowired
    private Icalendarioactividades1Dao dao;

    @Transactional(readOnly = true)
    @Override
    public List<calendarioactividades1> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(calendarioactividades1 calendarioactividades1) {
        dao.save(calendarioactividades1);
    }

    @Transactional(readOnly = true)
    @Override
    public calendarioactividades1 getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
