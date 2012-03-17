/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.forecast;

import java.util.List;

/**
 *
 * @author juan
 */
public interface Forecast {
    public List<Double> forecast(int numberOfPoints, List<Double> actualPoints);
}
