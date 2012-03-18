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
    private HashMap<String, Measure> centralTendencyMeasures = null;
    private HashMap<String, Measure> spreadMeasures = null;

    private MeasuresList() {
        centralTendencyMeasures = new HashMap();
        centralTendencyMeasures.put("mean", new Mean());
        centralTendencyMeasures.put("median", new Median());
        centralTendencyMeasures.put("mode", new Mode());
        spreadMeasures = new HashMap();
        spreadMeasures.put("variance", new Variance());
        spreadMeasures.put("standardDeviation", new StandardDeviation());
        spreadMeasures.put("interquartileRange", new InterquartileRange());
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

    public static ArrayList<Measure> getCentralTendencyMeasures() {
        return MeasuresList.getInstance().centralTendencyMeasuresList();
    }

    public ArrayList<Measure> centralTendencyMeasuresList() {
        ArrayList<Measure> list = new ArrayList<Measure>();
        for (Object measure : centralTendencyMeasures.values().toArray()) {
            list.add((Measure) measure);
        }
        return list;
    }

    public static ArrayList<Measure> getSpreadMeasures() {
        return MeasuresList.getInstance().spreadMeasuresList();
    }

    public ArrayList<Measure> spreadMeasuresList() {
        ArrayList<Measure> list = new ArrayList<Measure>();
        for (Object measure : spreadMeasures.values().toArray()) {
            list.add((Measure) measure);
        }
        return list;
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
