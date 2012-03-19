package org.meteorologaaguascalientes.control.report;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.meteorologaaguascalientes.control.measure.Measure;
import org.meteorologaaguascalientes.dao.AbstractVariableDao;
import org.meteorologaaguascalientes.dao.DaoList;
import org.meteorologaaguascalientes.model.Variable;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class ReportsControl {

    public ReportsControl() {
    }
    
    
    
    public Map<String,Double> getReport(Measure measure){
        
        Map<String,Double> Values = new HashMap<String,Double>(); // Will store the value returned by measure.calculate() for each variable in the list
        HashMap<String,AbstractVariableDao> VariablesList = DaoList.getInstance().getVariablesDaoMap(); // Stores the list of variables returned by the DaoList
        ArrayList<Variable> DaoData; // Will store the data returned by each Dao with the method getAllValues();
        double result; // Will store the result returned by measure.calculate()
        
        
        /* Go through the VariableList, getting all the values of each Dao, 
         * Then calculate the measure
         * and add it to the map
         */
        for(String i : VariablesList.keySet()){
            DaoData = (ArrayList<Variable>) VariablesList.get(i).getAllValues();
            result = measure.calculate(DaoData);
            Values.put(i , result);
        }
        
        return Values;
        
    }
    
}
