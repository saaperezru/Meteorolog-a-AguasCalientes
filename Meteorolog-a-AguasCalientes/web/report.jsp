<%@page import="org.meteorologaaguascalientes.dao.AbstractVariableDao"%>
<%@page import="org.meteorologaaguascalientes.control.measure.Measure"%>
<%@page import="org.meteorologaaguascalientes.control.measure.MeasuresList"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json" %>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%!    Map<AbstractVariableDao, Double> report;

    private Measure findMeasure(String measureName, List<Measure> measures) {
        for (Measure m : measures) {
            if (m.getClass().getSimpleName().equals(measureName)) {
                return m;
            }
        }
        return null;
    }
%>
<%
    String measureName = request.getParameter("measure");
    if (measureName != null) {
        measureName = measureName.substring(0, 1).toUpperCase() + measureName.substring(1);
        Measure measure = findMeasure(measureName, MeasuresList.getCentralTendencyMeasures());
        if (measure == null) {
            measure = findMeasure(measureName, MeasuresList.getSpreadMeasures());
        }
        if (measure != null) {
%>
<%--
    // ReportsControl invocation
    ReportsControl reportsControl = new ReportsControl();
    report = reportsControl.getReport(measure);
--%>
<%
    report = new HashMap<AbstractVariableDao, Double>();
    List<AbstractVariableDao> daoList = DaoList.getVariables();
    report.put(daoList.get(0), Math.random());
    report.put(daoList.get(1), Math.random());
    report.put(daoList.get(2), Math.random());
%>
<json:array var="entry" items="<%= report.entrySet()%>">
    <json:object>
        <json:property name="name" value="${entry.getKey().getVisibleName()}"/>
        <json:property name="value" value="${entry.getValue()}"/>
    </json:object>
</json:array>
<%
        }
    }
%>