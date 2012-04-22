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

    public static final String CENTRAL_TENDENCY = "centralTendency";
    public static final String SPREAD = "spread";
    
    public static final String MEAN = "Mean";
    public static final String MEDIAN = "Median";
    public static final String MODE = "Mode";
    public static final String STANDARD_DEVIATION = "StandardDeviation";
    public static final String VARIANCE = "Variance";
    public static final String INTERCUARTILE_RANGE = "InterquartileRange";
    
    private MeasuresList() {

        measuresMaps = new HashMap<String, HashMap<String, Measure>>();

        HashMap<String, Measure> centralTendency = new HashMap();
        
        centralTendency.put(MEAN, new Mean());
        centralTendency.put(MEDIAN, new Median());
        centralTendency.put(MODE, new Mode());

        measuresMaps.put(CENTRAL_TENDENCY, centralTendency);

        HashMap<String, Measure> spread = new HashMap();
        spread.put(VARIANCE, new Variance());
        spread.put(STANDARD_DEVIATION, new StandardDeviation());
        spread.put(INTERCUARTILE_RANGE, new InterquartileRange());

        measuresMaps.put(SPREAD, spread);
        
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
