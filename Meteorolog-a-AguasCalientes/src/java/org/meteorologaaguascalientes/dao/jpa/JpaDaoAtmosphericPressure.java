package org.meteorologaaguascalientes.dao.jpa;

import org.meteorologaaguascalientes.entity.AtmosphericPressureEntity;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;

/**
 *
 * @author Administrator
 */
public class JpaDaoAtmosphericPressure extends JpaDaoVariable<AtmosphericPressureVo, AtmosphericPressureEntity> {

    public JpaDaoAtmosphericPressure(String entityName, String voId) {
        super(entityName, voId);
    }

    @Override
    public AtmosphericPressureEntity voToEntity(AtmosphericPressureVo vo) {
        AtmosphericPressureEntity atmosphericPressureEntity = new AtmosphericPressureEntity();
        atmosphericPressureEntity.setTime(vo.getTime());
        atmosphericPressureEntity.setValue(vo.getValue());
        return atmosphericPressureEntity;
    }
}
