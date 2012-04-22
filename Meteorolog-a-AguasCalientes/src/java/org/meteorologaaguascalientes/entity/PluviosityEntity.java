package org.meteorologaaguascalientes.entity;

import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.PluviosityVo;

/**
 *
 * @author jdbermeol
 */
@javax.persistence.Entity(name = "Pluviosity")
public class PluviosityEntity extends VariableMappedSuperclass<PluviosityVo>{

    @Override
    public PluviosityVo getVo() {
        return (PluviosityVo)VariablesVoFactory.getVo(VariablesVoFactory.PLUVIOSITY);
    }
}