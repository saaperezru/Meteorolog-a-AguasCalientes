package org.meteorologaaguascalientes.entity;

import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;

/**
 *
 * @author jdbermeol
 */
@javax.persistence.Entity(name = "AtmosphericPressure")
public class AtmosphericPressureEntity extends VariableMappedSuperclass<AtmosphericPressureVo> {

    @Override
    public AtmosphericPressureVo getVo() {
        return (AtmosphericPressureVo)VariablesVoFactory.getVo(VariablesVoFactory.ATMOSPHERIC_PRESSURE);
    }
}