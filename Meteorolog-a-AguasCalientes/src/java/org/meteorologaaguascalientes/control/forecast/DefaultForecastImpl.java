/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.forecast;

import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.regression.RegressionResults;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 *
 * @author juan
 */
public class DefaultForecastImpl implements Forecast {

    @Override
    public SortedMap<Long, Double> forecast(int numberOfPoints, SortedMap<Long, Double> actualPoints) {

        double nextValue, meanSquareError, coefficients[];

        RegressionResults result;
        NormalDistribution distribution = new NormalDistribution();
        SortedMap<Long, Double> forecast = new TreeMap<Long, Double>();
        SimpleRegression regression = new SimpleRegression();

        Long timeDelta = (actualPoints.lastKey() - actualPoints.firstKey()) / (actualPoints.size() - 1);
        Long nextPoint = actualPoints.lastKey();

        for (Long i : actualPoints.keySet()) {
            try {
                regression.addData(i, actualPoints.get(i));
            } catch (NullPointerException e) {
                regression.addData(i, 0.0);
            }
        }

        result = regression.regress();

        coefficients = result.getParameterEstimates();
        meanSquareError = result.getMeanSquareError();

        for (int i = 0; i < numberOfPoints; i++) {
            nextPoint += timeDelta;
            nextValue = coefficients[0] + coefficients[1] * nextPoint;
            forecast.put(nextPoint, (new NormalDistribution(nextValue, meanSquareError)).sample());
        }

        return forecast;
    }
}
