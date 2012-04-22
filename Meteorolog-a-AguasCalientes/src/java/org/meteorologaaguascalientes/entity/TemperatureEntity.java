package org.meteorologaaguascalientes.entity;

import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.TemperatureVo;

/**
 *
 * @author jdbermeol
 */
@javax.persistence.Entity(name = "Temperature")
public class TemperatureEntity extends VariableMappedSuperclass<TemperatureVo> {

    @Override
    public TemperatureVo getVo() {
        return (TemperatureVo)VariablesVoFactory.getVo(VariablesVoFactory.TEMPERATURE);
    }
}
