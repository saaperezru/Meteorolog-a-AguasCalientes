package org.meteorologaaguascalientes.businesslogic.facade;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.meteorologaaguascalientes.control.measure.Measure;
import org.meteorologaaguascalientes.businesslogic.service.AbstractVariableService;
import org.meteorologaaguascalientes.businesslogic.service.ServicesFactory;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.da.JpaDataAccess;
import org.meteorologaaguascalientes.da.JpaDataAccessFactory;
import org.meteorologaaguascalientes.helper.Config;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class ReportsControl {

    public ReportsControl() {
    }
    
    
    
    public Map<String,Double> getReport(Measure measure){
        
        Map<String,Double> Values = new HashMap<String,Double>(); // Will store the value returned by measure.calculate() for each variable in the list
        HashMap<String,AbstractVariableService> VariablesList = ServicesFactory.getInstance().getVariablesServicesMap(); // Stores the list of variables returned by the ServicesFactory
        ArrayList<VariableVo> DaoData; // Will store the data returned by each Dao with the method getAllValues();
        double result; // Will store the result returned by measure.calculate()
        
        
        /* Go through the VariableList, getting all the values of each Dao, 
         * Then calculate the measure
         * and add it to the map
         */
        for(String i : VariablesList.keySet()){
			try {
				DataAccessAdapter da = Config.getInstance().getDataAccessFactory().createDataAccess();
				DaoData = (ArrayList<VariableVo>) VariablesList.get(i).getAllValues(da);
				result = measure.calculate(DaoData);
				Values.put(i , result);
			} catch (DataAccessException ex) {
				Logger.getLogger(ReportsControl.class.getName()).log(Level.SEVERE, null, ex);
			}
        }
        
        return Values;
        
    }
    
}
