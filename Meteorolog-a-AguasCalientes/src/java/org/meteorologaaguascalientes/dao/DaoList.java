package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DaoList {

    private final static List<Dao> dao;
    private final static List<VariableDao> variables;

    static {
        dao = new ArrayList<Dao>();
        variables = new ArrayList<VariableDao>();
        dao.add(new Dao() {

            {
                setVisibleName("sample");
            }
        });
        VariableDao vd = new VariableDao() {

            {
                setVisibleName("temperature");
            }
        };
        dao.add(vd);
        variables.add(vd);
        vd = new VariableDao() {

            {
                setVisibleName("atmosphericPressure");
            }
        };
        dao.add(vd);
        variables.add(vd);
        vd = new VariableDao() {

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

    public static List<VariableDao> getVariables() {
        return Collections.unmodifiableList(variables);
    }
}
