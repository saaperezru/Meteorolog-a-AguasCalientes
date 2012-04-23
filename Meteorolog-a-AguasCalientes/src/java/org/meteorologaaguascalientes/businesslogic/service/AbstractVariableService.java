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
public abstract class AbstractVariableService<E extends VariableVo> {

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

    public abstract void checkVo(E vo) throws IllegalArgumentException;

    public abstract String getVariableId();

    private VariableDao<?, E> getDao(DataAccessAdapter dataAccess) {
        return AbstractDaoFactory.getDaoFactory(dataAccess).getVariableDao(getVariableId());
    }

    public VariableVo getNewVo() {
        return VariablesVoFactory.getVo(getVariableId());
    }

    public E createRecord(DataAccessAdapter dataAccess, E record) throws DataAccessException,IllegalArgumentException {
        checkVo(record);
        return getDao(dataAccess).insert(dataAccess, record);
    }

    public E getLastValue(DataAccessAdapter dataAccess) throws DataAccessException {
        return getDao(dataAccess).getLastValue(dataAccess);
    }

    private List<E> getAllValues(DataAccessAdapter dataAccess) throws DataAccessException {
        return getDao(dataAccess).getAllValues(dataAccess);
    }

    public double getReport(DataAccessAdapter dataAccess) throws DataAccessException, NullPointerException {
        if (measure == null) {
            throw new NullPointerException("Measure cannot be Null");
        }
        return measure.calculate((List<VariableVo>) getAllValues(dataAccess));
    }

    public List<SortedMap<Date, Double>> getDataAndPrediction(DataAccessAdapter dataAccess)
            throws DataAccessException, NoSuchElementException, NullPointerException {

        if (forecast == null) {
            throw new NullPointerException("Forecast cannot be Null");
        }
        ArrayList<VariableVo> variables = (ArrayList<VariableVo>) getAllValues(dataAccess);
        List<SortedMap<Date, Double>> data = new ArrayList<SortedMap<Date, Double>>();
        if(variables.isEmpty()){
            return data;
        }
        
        SortedMap<Date, Double> actualValues = new TreeMap<Date, Double>();
        data.add(actualValues);
        for (VariableVo v : variables) {
            actualValues.put(v.getTime(), v.getValue());
        }
        
        SortedMap<Long, Double> timeSpacedActualValues = new TreeMap<Long, Double>();
        Long firstSampleTime = actualValues.firstKey().getTime();
        for (Date d : actualValues.keySet()) {
            timeSpacedActualValues.put(d.getTime() - firstSampleTime, actualValues.get(d));
        }
        
        SortedMap<Long, Double> timeSpacedForecast;
        timeSpacedForecast = forecast.forecast(10, timeSpacedActualValues);
        
        SortedMap<Date, Double> prediction = new TreeMap<Date, Double>();
        if (timeSpacedForecast != null) {
            for (Long l : timeSpacedForecast.keySet()) {
                prediction.put(new Date(l + firstSampleTime), timeSpacedForecast.get(l));
            }
        }
        data.add(prediction);
        return data;
    }
}
