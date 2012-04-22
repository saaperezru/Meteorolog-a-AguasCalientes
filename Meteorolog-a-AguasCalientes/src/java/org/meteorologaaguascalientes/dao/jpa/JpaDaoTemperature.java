package org.meteorologaaguascalientes.dao.jpa;

import org.meteorologaaguascalientes.entity.TemperatureEntity;
import org.meteorologaaguascalientes.vo.TemperatureVo;

/**
 *
 * @author Administrator
 */
public class JpaDaoTemperature extends JpaDaoVariable<TemperatureVo, TemperatureEntity> {

    public JpaDaoTemperature(String entityName, String voId) {
        super(entityName, voId);
    }

    @Override
    public TemperatureEntity voToEntity(TemperatureVo vo) {
        TemperatureEntity temperatureEntity = new TemperatureEntity();
        temperatureEntity.setTime(vo.getTime());
        temperatureEntity.setValue(vo.getValue());
        return temperatureEntity;
    }
}
