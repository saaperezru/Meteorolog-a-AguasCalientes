/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.forecast;

import java.util.SortedMap;

/**
 *
 * @author juan
 */
public interface Forecast {
    public SortedMap<Long, Double> forecast(int numberOfPoints, SortedMap<Long, Double> actualPoints);
}
