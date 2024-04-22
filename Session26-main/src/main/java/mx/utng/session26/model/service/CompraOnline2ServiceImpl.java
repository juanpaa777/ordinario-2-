package mx.utng.session26.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.session26.model.dao.ICompraOnline2Dao;
import mx.utng.session26.model.entity.CompraOnline2;

@Service
public class CompraOnline2ServiceImpl implements ICompraOnline2Service {

    @Autowired
    private ICompraOnline2Dao dao;

    @Transactional(readOnly = true)
    @Override
    public List<CompraOnline2> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(CompraOnline2 compraOnline2) {
        dao.save(compraOnline2);
    }

    @Transactional(readOnly = true)
    @Override
    public CompraOnline2 getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
