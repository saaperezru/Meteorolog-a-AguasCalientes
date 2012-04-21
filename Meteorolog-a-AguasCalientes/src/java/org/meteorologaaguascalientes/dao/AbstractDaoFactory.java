package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.dao.jpa.JpaDaoFactory;
import org.meteorologaaguascalientes.da.DataAccessAdapter;

public abstract class AbstractDaoFactory<E extends DataAccessAdapter> {

    public static enum DaoFactoryTypes {

        JPA
    }

    public static AbstractDaoFactory getDaoFactory(DataAccessAdapter da) {
        AbstractDaoFactory daoFactory = null;

        if (da.getType() == DaoFactoryTypes.JPA) {
            daoFactory = JpaDaoFactory.getInstance();
        }
        return daoFactory;
    }

    public abstract VariableDao getVariableDao(String VariableType);
}
