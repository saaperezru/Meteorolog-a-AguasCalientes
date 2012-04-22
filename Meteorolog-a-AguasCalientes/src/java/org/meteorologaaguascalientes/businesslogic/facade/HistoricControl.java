package org.meteorologaaguascalientes.businesslogic.facade;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.meteorologaaguascalientes.businesslogic.service.ServicesFactory;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.helper.Config;

/**
 *
 * @author juan
 */
public class HistoricControl {

    public List<SortedMap<Date, Double>> getData(String variable, String forecast) {
        List<SortedMap<Date, Double>> data = new ArrayList<SortedMap<Date, Double>>();
        try {
            DataAccessAdapter da = Config.getInstance().getDataAccessFactory().createDataAccess();
            data = ServicesFactory.getInstance().getVariableServiceByKey(variable).getData(da);
        } catch (DataAccessException ex) {
            Logger.getLogger(HistoricControl.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NoSuchElementException ex) {
            Logger.getLogger(HistoricControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
