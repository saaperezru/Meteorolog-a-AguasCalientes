/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import java.util.*;
import org.meteorologaaguascalientes.control.forecast.Forecast;
import org.meteorologaaguascalientes.control.measure.Measure;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.dao.AbstractDaoFactory;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.helper.VariablesVoFactory;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author tuareg
 */
public abstract class AbstractVariableService<E extends VariableVo> extends AbstractService<E> {

    Measure measure;
    Forecast forecast;

    public AbstractVariableService(Measure measure, Forecast forecast) {
        this.measure = measure;
        this.forecast = forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public E getLastValue(DataAccessAdapter dataAccess) throws DataAccessException {
        return getDao(dataAccess).getLastValue(dataAccess);
    }

    private List<E> getAllValues(DataAccessAdapter dataAccess) throws DataAccessException {
        return getDao(dataAccess).getAllValues(dataAccess);
    }

    @Override
    protected VariableDao<?, E> getDao(DataAccessAdapter dataAccess) {
        return AbstractDaoFactory.getDaoFactory(dataAccess).getVariableDao(getVariableId());
    }

    public VariableVo getNewVo() {
        return VariablesVoFactory.getVo(getVariableId());
    }

    public abstract String getVariableId();

    public double getReport(DataAccessAdapter dataAccess) throws DataAccessException {
        if (measure == null) {
            throw new NullPointerException("Measure cannot be Null");
        }
        return measure.calculate((List<VariableVo>) getAllValues(dataAccess));
    }

    public List<SortedMap<Date, Double>> getData(DataAccessAdapter dataAccess) throws DataAccessException, NoSuchElementException {

        List<SortedMap<Date, Double>> data = new ArrayList<SortedMap<Date, Double>>();
        SortedMap<Date, Double> actualValues = new TreeMap<Date, Double>();
        SortedMap<Date, Double> prediction = new TreeMap<Date, Double>();
        SortedMap<Long, Double> timeSpacedActualValues = new TreeMap<Long, Double>();
        SortedMap<Long, Double> timeSpacedForecast;

        data.add(actualValues);
        ArrayList<VariableVo> variables = (ArrayList<VariableVo>) getAllValues(dataAccess);

        for (VariableVo v : variables) {
            actualValues.put(v.getTime(), v.getValue());
        }

        Long firstSampleTime = actualValues.firstKey().getTime();
        for (Date d : actualValues.keySet()) {
            timeSpacedActualValues.put(d.getTime() - firstSampleTime, actualValues.get(d));
        }
        timeSpacedForecast = forecast.forecast(10, timeSpacedActualValues);
        if (timeSpacedForecast != null) {
            for (Long l : timeSpacedForecast.keySet()) {
                prediction.put(new Date(l + firstSampleTime), timeSpacedForecast.get(l));
            }
        }


        data.add(prediction);

        return data;
    }
}
