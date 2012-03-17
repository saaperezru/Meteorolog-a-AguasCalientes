package org.meteorologaaguascalientes.control.measure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MeasuresList {

    private static final List<Measure> centralTendencyMeasures;
    private static final List<Measure> spreadMeasures;

    static {
        centralTendencyMeasures = new ArrayList<Measure>();
        centralTendencyMeasures.add(new Mean());
        centralTendencyMeasures.add(new Median());
        centralTendencyMeasures.add(new Mode());

        spreadMeasures = new ArrayList<Measure>();
        spreadMeasures.add(new StandardDeviation());
        spreadMeasures.add(new Variance());
        spreadMeasures.add(new InterquartileRange());
    }

    private MeasuresList() {
    }

    public static List<Measure> getCentralTendencyMeasures() {
        return Collections.unmodifiableList(centralTendencyMeasures);
    }

    public static List<Measure> getSpreadMeasures() {
        return Collections.unmodifiableList(spreadMeasures);
    }
}
