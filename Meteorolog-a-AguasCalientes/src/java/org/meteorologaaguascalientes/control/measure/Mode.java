/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author josebermeo
 */
public class Mode implements Measure{

    @Override
    public double calculate(double[] data) {
        if(data.length == 0)
            return -1;
    
        Map<Double,Integer> counter=new HashMap<Double, Integer>();
        for(int i = 0; i< data.length; i++)
            if(counter.containsKey(data[i]))
                counter.put(data[i], counter.get(data[i])+1);
            else
                counter.put(data[i], 1);
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
