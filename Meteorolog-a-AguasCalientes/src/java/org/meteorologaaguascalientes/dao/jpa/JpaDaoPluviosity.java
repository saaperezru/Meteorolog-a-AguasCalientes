package org.meteorologaaguascalientes.dao.jpa;

import org.meteorologaaguascalientes.entity.PluviosityEntity;
import org.meteorologaaguascalientes.vo.PluviosityVo;

/**
 *
 * @author Administrator
 */
public class JpaDaoPluviosity extends JpaDaoVariable<PluviosityVo, PluviosityEntity> {

    public JpaDaoPluviosity(String entityName, String voId) {
        super(entityName, voId);
    }

    @Override
    public PluviosityEntity voToEntity(PluviosityVo vo) {
        PluviosityEntity pluviosityEntity = new PluviosityEntity();
        pluviosityEntity.setTime(vo.getTime());
        pluviosityEntity.setValue(vo.getValue());
        return pluviosityEntity;
    }
}
