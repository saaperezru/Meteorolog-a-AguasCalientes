package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DaoList {

    private final static List<Dao> dao;
    private final static List<AbstractVariableDao> variables;

    static {
        dao = new ArrayList<Dao>();
        variables = new ArrayList<AbstractVariableDao>();
        dao.add(new Dao() {

            {
                setVisibleName("sample");
            }
        });
        AbstractVariableDao vd = new AbstractVariableDao() {

            {
                setVisibleName("temperature");
            }
        };
        dao.add(vd);
        variables.add(vd);
        vd = new AbstractVariableDao() {

            {
                setVisibleName("atmosphericPressure");
            }
        };
        dao.add(vd);
        variables.add(vd);
        vd = new AbstractVariableDao() {

            {
                setVisibleName("pluviosity");
            }
        };
        dao.add(vd);
        variables.add(vd);
    }

    private DaoList() {
    }

    public static List<Dao> getDao() {
        return Collections.unmodifiableList(dao);
    }

    public static List<AbstractVariableDao> getVariables() {
        return Collections.unmodifiableList(variables);
    }
}
