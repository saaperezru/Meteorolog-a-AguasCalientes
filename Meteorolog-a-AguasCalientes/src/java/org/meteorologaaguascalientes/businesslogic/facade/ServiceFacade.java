package org.meteorologaaguascalientes.businesslogic.facade;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.meteorologaaguascalientes.businesslogic.service.AbstractVariableService;
import org.meteorologaaguascalientes.businesslogic.service.ServicesFactory;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author jdbermeol
 */
public class ServiceFacade {

    public boolean insertValues(Map<String, String> data, String timestring) throws DataAccessException {
        if (data == null) {
            return false;
        }
        if (timestring == null) {
            return false;
        }
        //check for null keys or null values
        if (checkNullElements(data.keySet().toArray())) {
            return false;
        }
        if (checkNullElements(data.values().toArray())) {
            return false;
        }
        //checking time
        Date time;
        try {
            time = (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa")).parse(timestring);
            Calendar c = Calendar.getInstance();
            c.setTime(time);
        } catch (Exception e) {
            return false;
        }
        double val;
        for (Entry<String, String> entry : data.entrySet()) {
            try {
                val = Double.parseDouble(entry.getValue());
            } catch (NumberFormatException e) {
                return false;
            }
            VariableVo variableVo = new VariableVo();
            variableVo.setTime(time);
            variableVo.setValue(val);
            AbstractVariableService avs = ServicesFactory.getInstance().getVariableServiceByKey(entry.getKey());
            if (avs == null) {
                return false;
            }
            avs.createRecord(null, variableVo);
        }
        return true;
    }

    private boolean checkNullElements(Object[] list) {
        for (Object element : list) {
            if (element == null) {
                return true;
            }
        }
        return false;
    }
    
    public HashMap<String, VariableVo> getLastValues(){
        return null;
    }
}
