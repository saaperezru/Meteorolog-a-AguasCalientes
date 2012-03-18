/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control;

import java.util.ArrayList;
import org.meteorologaaguascalientes.dao.DaoList;
import org.meteorologaaguascalientes.model.Sample;
import org.meteorologaaguascalientes.model.Variable;

/**
 *
 * @author josebermeo
 */
public class InsertControl {

    private DaoList daoList;
    
    public InsertControl(DaoList daoList) {
        this.daoList = daoList;
    }
    public String insertValues(ArrayList<Variable> variables, Sample sample){
        if(variables == null || sample == null)
            return "Null parameters";
        if(sample.getTime()== null)
            return "Null time";
        for(int i = 0; i<variables.size() ; i++){
            Variable variable = variables.get(i);
            if(variable!= null){
                variable.setTime(sample.getTime());
                daoList.getVariablesDaoMap().get(variable.getClass().getSimpleName()).createRecord(variable);
            }
        }
        return "Correct";
    }
    
}
