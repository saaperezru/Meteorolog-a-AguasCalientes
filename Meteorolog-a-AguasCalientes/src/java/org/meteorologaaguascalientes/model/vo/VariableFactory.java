/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VariableFactory {
    
    public static List<String> getKeys(){
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(AtmosphericPressure.class.getName());
        arrayList.add(Pluviosity.class.getName());
        arrayList.add(Temperature.class.getName());
        return arrayList;
    }
    
    public static Variable getVariable(String id){
        if(AtmosphericPressure.class.getName().equals(id))
            return new AtmosphericPressure();
        if(Pluviosity.class.getName().equals(id))
            return new Pluviosity();
        if(Temperature.class.getName().equals(id))
            return new Temperature();
        return null;
    }
    
}
