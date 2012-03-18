/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import java.util.HashMap;



/**
 *
 * @author josebermeo
 */
public class MeasuresList {
    
    private static MeasuresList measuresList = null;
    private static HashMap<String,Measure>  centralTendencyMeasures = null ;
    private static HashMap<String,Measure>  spreadMeasures = null;
    
    public MeasuresList() {}
    
    public  static MeasuresList getInstance(){
        if(measuresList == null){
            centralTendencyMeasures = new HashMap();
            centralTendencyMeasures.put("Mean", new Mean());
            centralTendencyMeasures.put("Median", new Median());
            centralTendencyMeasures.put("Mode", new Mode());
            spreadMeasures = new HashMap();
            spreadMeasures.put("Variance", new Variance());
            spreadMeasures.put("StandardDeviation", new StandardDeviation());
            spreadMeasures.put("InterquartileRange", new InterquartileRange());
            return measuresList;
        }
        return measuresList;
    }

    public Measure getCentralTendencyMeasure(String key) {
        return centralTendencyMeasures.get(key);
    }

    public Measure getSpreadMeasure(String key) {
        return spreadMeasures.get(key);
    }
    
    public ArrayList<Measure> getCentralTendencyMeasures() {
        ArrayList<Measure> list = new ArrayList<Measure>();
        for(Object measure : centralTendencyMeasures.values().toArray())
           list.add((Measure)measure);
        return list;
    }

    public ArrayList<Measure> getSpreadMeasures() {
        ArrayList<Measure> list = new ArrayList<Measure>();
        for(Object measure : spreadMeasures.values().toArray())
           list.add((Measure)measure);
        return list;
    }

    public ArrayList<String> getCentralTendencyMeasuresKeys() {
        ArrayList<String> list = new ArrayList<String>();
        for(Object measure : centralTendencyMeasures.keySet().toArray())
           list.add((String)measure);
        return list;
    }

    public ArrayList<String> getSpreadMeasuresKeys() {
        ArrayList<String> list = new ArrayList<String>();
        for(Object measure : spreadMeasures.keySet().toArray())
           list.add((String)measure);
        return list;
    }

}