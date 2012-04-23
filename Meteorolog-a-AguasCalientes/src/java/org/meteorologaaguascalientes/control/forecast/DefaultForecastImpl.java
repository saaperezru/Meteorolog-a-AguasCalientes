package org.meteorologaaguascalientes.control.forecast;

import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.math3.stat.regression.RegressionResults;
import org.apache.commons.math3.stat.regression.SimpleRegression;

/**
 *
 * @author juan
 */
public class DefaultForecastImpl implements Forecast {

    @Override
    public SortedMap<Long, Double> forecast(int numberOfPoints, SortedMap<Long, Double> actualPoints) {

        SortedMap<Long, Double> forecast = new TreeMap<Long, Double>();
        if (actualPoints.size() < 3) {
            return forecast;
        }
        double nextValue, coefficients[];

        RegressionResults result;

        SimpleRegression regression = new SimpleRegression();

        Long timeDelta = (actualPoints.lastKey() - actualPoints.firstKey()) / (actualPoints.size() - 1);
        Long nextPoint = actualPoints.lastKey();

        int counter = 0, threshold = actualPoints.size() - numberOfPoints;

        if (threshold < 0) {
            threshold = 0;
        }

        for (Long i : actualPoints.keySet()) {
            counter++;
            if (counter >= threshold) {
                try {
                    regression.addData(i, actualPoints.get(i));
                } catch (NullPointerException e) {
                    regression.addData(i, 0.0);
                }
            }
        }

        result = regression.regress();

        coefficients = result.getParameterEstimates();

        for (int i = 0; i < numberOfPoints; i++) {
            nextPoint += timeDelta;
            nextValue = coefficients[0] + coefficients[1] * nextPoint;

            forecast.put(nextPoint, nextValue);
        }

        return forecast;
    }
}
