/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.entity.PluviosityEntity;
import org.meteorologaaguascalientes.vo.PluviosityVo;

/**
 *
 * @author Administrator
 */
public class JpaDaoPluviosity extends JpaDaoVariable<PluviosityVo, PluviosityEntity> {

    @Override
    public PluviosityEntity voToEntity(PluviosityVo vo) {
        PluviosityEntity pluviosityEntity = new PluviosityEntity();
        pluviosityEntity.setTime(vo.getTime());
        pluviosityEntity.setValue(vo.getValue());
        return pluviosityEntity;
    }

    @Override
    public PluviosityVo getLastValue(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        List<PluviosityVo> list = getLastNValues(adapter, 1);
        if (list.isEmpty()) {
            throw new NoResultException("Empty Pluviosity table");
        }
        return list.get(0);
    }

    @Override
    public List<PluviosityVo> getLastNValues(DataAccessAdapter<EntityManager> adapter, int n) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        return adapter.getDataAccess().createQuery("SELECT result FROM Pluviosity result ORDER BY result.time DESC").setMaxResults(n).getResultList();
    }

    @Override
    public List<PluviosityVo> getAllValues(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        return adapter.getDataAccess().createQuery("SELECT result FROM Pluviosity result").getResultList();
    }
}
