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
import org.meteorologaaguascalientes.entity.TemperatureEntity;
import org.meteorologaaguascalientes.vo.TemperatureVo;

/**
 *
 * @author Administrator
 */
public class JpaDaoTemperature extends JpaDaoVariable<TemperatureVo, TemperatureEntity> {

    @Override
    public TemperatureEntity voToEntity(TemperatureVo vo) {
        TemperatureEntity temperatureEntity = new TemperatureEntity();
        temperatureEntity.setTime(vo.getTime());
        temperatureEntity.setValue(vo.getValue());
        return temperatureEntity;
    }

    @Override
    public TemperatureVo getLastValue(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        List<TemperatureVo> list = getLastNValues(adapter, 1);
        if (list.isEmpty()) {
            throw new NoResultException("Empty Pluviosity table");
        }
        return list.get(0);
    }

    @Override
    public List<TemperatureVo> getLastNValues(DataAccessAdapter<EntityManager> adapter, int n) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        return adapter.getDataAccess().createQuery("SELECT result FROM Temperature result ORDER BY result.time DESC").setMaxResults(n).getResultList();
    }

    @Override
    public List<TemperatureVo> getAllValues(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        return adapter.getDataAccess().createQuery("SELECT result FROM Temperature result").getResultList();
    }
    
}
