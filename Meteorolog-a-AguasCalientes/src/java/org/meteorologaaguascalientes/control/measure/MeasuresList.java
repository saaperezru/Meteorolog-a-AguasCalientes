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
    
    private HashMap<String, HashMap> measuresLists = null;
    
    private HashMap<String, Measure> centralTendencyMeasures = null;
    private HashMap<String, Measure> spreadMeasures = null;

    private MeasuresList() {
        centralTendencyMeasures = new HashMap();
        Mean mean = new Mean();
        centralTendencyMeasures.put(mean.getClass().getSimpleName(), mean);
        Median median = new Median();
        centralTendencyMeasures.put(median.getClass().getSimpleName(), median);
        Mode mode = new Mode();
        centralTendencyMeasures.put(mode.getClass().getSimpleName(), mode);
        
        spreadMeasures = new HashMap();
        Variance variance = new Variance();
        spreadMeasures.put(variance.getClass().getSimpleName(), variance);
        StandardDeviation standardDeviation = new StandardDeviation();
        spreadMeasures.put(standardDeviation.getClass().getSimpleName(),standardDeviation);
        InterquartileRange interquartileRange = new InterquartileRange();
        spreadMeasures.put(interquartileRange.getClass().getSimpleName(), interquartileRange );
    }

    public static MeasuresList getInstance() {
        if (measuresList == null) {
            measuresList = new MeasuresList();
        }
        return measuresList;
    }

    public Measure getCentralTendencyMeasure(String key) {
        return centralTendencyMeasures.get(key);
    }

    public Measure getSpreadMeasure(String key) {
        return spreadMeasures.get(key);
    }

    public static List<Measure> getCentralTendencyMeasures() {
        return MeasuresList.getInstance().centralTendencyMeasuresList();
    }

    private ArrayList<Measure> centralTendencyMeasuresList() {
        return new ArrayList<Measure>(centralTendencyMeasures.values());
    }

    public static List<Measure> getSpreadMeasures() {
        return MeasuresList.getInstance().spreadMeasuresList();
    }

    private List<Measure> spreadMeasuresList() {
        return new ArrayList<Measure>(spreadMeasures.values());
    }

    public ArrayList<String> getCentralTendencyMeasuresKeys() {
        ArrayList<String> list = new ArrayList<String>();
        for (Object measure : centralTendencyMeasures.keySet().toArray()) {
            list.add((String) measure);
        }
        return list;
    }

    public ArrayList<String> getSpreadMeasuresKeys() {
        ArrayList<String> list = new ArrayList<String>();
        for (Object measure : spreadMeasures.keySet().toArray()) {
            list.add((String) measure);
        }
        return list;
    }
}
