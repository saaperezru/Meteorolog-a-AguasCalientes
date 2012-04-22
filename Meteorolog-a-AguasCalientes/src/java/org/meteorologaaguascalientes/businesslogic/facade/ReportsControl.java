package org.meteorologaaguascalientes.businesslogic.facade;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.meteorologaaguascalientes.businesslogic.service.AbstractVariableService;
import org.meteorologaaguascalientes.businesslogic.service.ServicesFactory;
import org.meteorologaaguascalientes.control.measure.MeasuresFactory;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.helper.Config;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class ReportsControl {

    public ReportsControl() {
    }

    public Map<String, Double> getReport(String measure) {

        Map<String, Double> Values = new HashMap<String, Double>(); // Will store the value returned by measure.calculate() for each variable in the list
        HashMap<String, AbstractVariableService> VariablesList = ServicesFactory.getInstance().getVariablesServicesMap(); // Stores the list of variables returned by the ServicesFactory
        double result; // Will store the result returned by measure.calculate()
        /*
         * Go through the VariableList, getting all the values of each Dao, Then
         * calculate the measure and add it to the map
         */
        for (String i : VariablesList.keySet()) {
            try {
                DataAccessAdapter da = Config.getInstance().getDataAccessFactory().createDataAccess();
                VariablesList.get(i).setMeasure(MeasuresFactory.getInstance().getMeasure(measure));
                result = VariablesList.get(i).getReport(da);
                Values.put(i, result);
            } catch (DataAccessException ex) {
                Logger.getLogger(ReportsControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return Values;

    }
}
