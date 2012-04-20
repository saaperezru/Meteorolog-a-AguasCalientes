/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import org.meteorologaaguascalientes.model.vo.Sample;

/**
 *
 * @author tuareg
 */
public class SampleDao implements Dao<Sample> {

    private ArrayList<Sample> samples = new ArrayList<Sample>();
    private static SampleDao instance;

    @Override
    public boolean createRecord(Sample record) {
        for (Sample s : samples) {
            if (record.getTime().compareTo(s.getTime()) == 0) {
                return false;
            }
        }
        samples.add(record);
        return true;
    }

    public synchronized static SampleDao getInstance() {
        if (instance == null) {
            instance = new SampleDao();
        }
        return instance;
    }
}
