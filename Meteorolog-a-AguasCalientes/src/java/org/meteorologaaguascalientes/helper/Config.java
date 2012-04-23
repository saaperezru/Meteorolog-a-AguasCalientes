package org.meteorologaaguascalientes.helper;

import org.meteorologaaguascalientes.da.AbstractDataAccessFactory;
import org.meteorologaaguascalientes.da.JpaDataAccessFactory;

public class Config {

    private static Config instance = null;
    private static final String PERSISTENCE_UNIT = "Meteorolog-a-AguasCalientesPU";
    private AbstractDataAccessFactory daF;

    private Config(AbstractDataAccessFactory daF) {
        this.daF = daF;
    }

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config(new JpaDataAccessFactory(PERSISTENCE_UNIT));
        }
        return instance;
    }

    public AbstractDataAccessFactory getDataAccessFactory() {
        return daF;
    }
}
