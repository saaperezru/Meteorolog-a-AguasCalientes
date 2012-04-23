package org.meteorologaaguascalientes.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.entity.VariableMappedSuperclass;
import org.meteorologaaguascalientes.vo.VariableVo;

public abstract class JpaDaoVariable<E extends VariableVo, F extends VariableMappedSuperclass> implements VariableDao<EntityManager, E> {

    String entityName;
    String voId;

    public JpaDaoVariable(String entityName, String voId) {
        this.entityName = entityName;
        this.voId = voId;
    }

    @Override
    public E insert(DataAccessAdapter<EntityManager> adapter, E vo) throws DataAccessException {
        checkNullParameters(adapter, "Adapter cannot be null");
        checkNullParameters(adapter.getDataAccess(), "EntityManager cannot be null");

        adapter.getDataAccess().persist(voToEntity(vo));
        return vo;
    }

    @Override
    public E update(DataAccessAdapter<EntityManager> adapter, E vo) throws DataAccessException {
        checkNullParameters(adapter, "Adapter cannot be null");
        checkNullParameters(adapter.getDataAccess(), "EntityManager cannot be null");

        adapter.getDataAccess().merge(voToEntity(vo));
        return vo;
    }

    @Override
    public void delete(DataAccessAdapter<EntityManager> adapter, Object id) throws DataAccessException {
        adapter.getDataAccess().remove(findById(adapter, id));
    }

    @Override
    public E findById(DataAccessAdapter<EntityManager> adapter, Object id) throws DataAccessException {
        checkNullParameters(adapter, "Adapter cannot be null");
        checkNullParameters(adapter.getDataAccess(), "EntityManager cannot be null");

        return (E) adapter.getDataAccess().find(((F) new Object()).getClass(), id).toVo();
    }

    public abstract F voToEntity(E vo);

    private void checkNullParameters(Object o, String message) {
        if (o == null) {
            throw new NullPointerException(message);
        }
    }

    @Override
    public E getLastValue(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        List<E> list = getLastNValues(adapter, 1);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<E> getLastNValues(DataAccessAdapter<EntityManager> adapter, int n) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        ArrayList<E> array = new ArrayList<E>();
        List<F> resultList = adapter.getDataAccess().createQuery("SELECT result FROM " + entityName + " result ORDER BY result.time DESC").setMaxResults(n).getResultList();
        for (F entity : resultList) {
            array.add((E) entity.toVo());
        }
        return array;
    }

    @Override
    public List<E> getAllValues(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        ArrayList<E> array = new ArrayList<E>();
        List<F> resultList = adapter.getDataAccess().createQuery("SELECT result FROM " + entityName + " result").getResultList();
        for (F entity : resultList) {
            array.add((E) entity.toVo());
        }
        return array;
    }
}
