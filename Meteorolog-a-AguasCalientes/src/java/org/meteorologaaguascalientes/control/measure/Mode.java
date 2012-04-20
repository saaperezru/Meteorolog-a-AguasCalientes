/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.meteorologaaguascalientes.model.vo.Variable;

/**
 *
 * @author josebermeo
 */
public class Mode implements Measure{

    @Override
    public double calculate(ArrayList<Variable> data) {
        if(data.isEmpty())
            return java.lang.Double.NaN;
        Map<Double,Integer> counter=new HashMap<Double, Integer>();
        for(int i = 0; i< data.size(); i++)
            if(counter.containsKey(data.get(i).getValue()))
                counter.put(data.get(i).getValue(), counter.get(data.get(i).getValue())+1);
            else
                counter.put(data.get(i).getValue(), 1);
        Iterator it = counter.keySet().iterator();
        double mode = (Double)it.next();
        int amount = counter.get(mode);
        while(it.hasNext()){
            double next = (Double)it.next();
            if(amount<counter.get(next)){
                 mode = next;
                 amount = counter.get(next);
            }else{
                if(amount==counter.get(next) && mode<next){
                    mode = next;
                    amount = counter.get(next);
                }
            }
        }
        return mode;
        
    }
    
}
