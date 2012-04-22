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
import org.meteorologaaguascalientes.entity.AtmosphericPressureEntity;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;

/**
 *
 * @author Administrator
 */
public class JpaDaoAtmosphericPressure extends JpaDaoVariable<AtmosphericPressureVo, AtmosphericPressureEntity>{

    @Override
    public AtmosphericPressureEntity voToEntity(AtmosphericPressureVo vo) {
        AtmosphericPressureEntity atmosphericPressureEntity = new AtmosphericPressureEntity();
        atmosphericPressureEntity.setTime(vo.getTime());
        atmosphericPressureEntity.setValue(vo.getValue());
        return atmosphericPressureEntity;
    }

    @Override
    public AtmosphericPressureVo getLastValue(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        List<AtmosphericPressureVo> list = getLastNValues(adapter, 1);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<AtmosphericPressureVo> getLastNValues(DataAccessAdapter<EntityManager> adapter, int n) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        return adapter.getDataAccess().createQuery("SELECT result FROM AtmosphericPressure result ORDER BY result.time DESC").setMaxResults(n).getResultList(); 
    }

    @Override
    public List<AtmosphericPressureVo> getAllValues(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter cannot be null");
        }
        if (adapter.getDataAccess() == null) {
            throw new IllegalArgumentException("EntityManager cannot be null");
        }
        return adapter.getDataAccess().createQuery("SELECT result FROM AtmosphericPressure result").getResultList();
    }
    
}
