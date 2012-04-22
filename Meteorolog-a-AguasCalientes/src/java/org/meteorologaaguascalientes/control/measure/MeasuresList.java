/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author josebermeo
 */
public class MeasuresList {

    private static MeasuresList measuresList = null;
    private HashMap<String, HashMap<String, Measure>> measuresMaps = null;

    private MeasuresList() {

        measuresMaps = new HashMap<String, HashMap<String, Measure>>();

        HashMap<String, Measure> centralTendency = new HashMap();
        Mean mean = new Mean();
        centralTendency.put(mean.getClass().getSimpleName(), mean);
        Median median = new Median();
        centralTendency.put(median.getClass().getSimpleName(), median);
        Mode mode = new Mode();
        centralTendency.put(mode.getClass().getSimpleName(), mode);

        measuresMaps.put("centralTendency", centralTendency);

        HashMap<String, Measure> spread = new HashMap();
        Variance variance = new Variance();
        spread.put(variance.getClass().getSimpleName(), variance);
        StandardDeviation standardDeviation = new StandardDeviation();
        spread.put(standardDeviation.getClass().getSimpleName(), standardDeviation);
        InterquartileRange interquartileRange = new InterquartileRange();
        spread.put(interquartileRange.getClass().getSimpleName(), interquartileRange);

        measuresMaps.put("spread", spread);
        
    }

    public static MeasuresList getInstance() {
        if (measuresList == null) {
            measuresList = new MeasuresList();
        }
        return measuresList;
    }

    public Measure getMeasure(String key) {
        for (String typeKey : measuresMaps.keySet()) {
            Measure measure = measuresMaps.get(typeKey).get(key);
            if (measure != null) {
                return measure;
            }
        }
        return null;
    }

    public static List<Measure> getMeasures(String typeKey) {
        return MeasuresList.getInstance().measuresList(typeKey);
    }

    private List<Measure> measuresList(String typeKey) {
        return new ArrayList<Measure>(measuresMaps.get(typeKey).values());
    }

    public ArrayList<String> getMeasuresKeys(String typeKey) {
        ArrayList<String> list = new ArrayList<String>();

        for (Object measure : measuresMaps.get(typeKey).keySet().toArray()) {
            list.add((String) measure);
        }
        return list;
    }
    
    public ArrayList<String> getMeasuresTypes(){
        
        ArrayList<String> list = new ArrayList<String>();
        
        for (Object type:measuresMaps.keySet().toArray()){
            list.add((String)type);
        }
        
        return list;
    }
}
