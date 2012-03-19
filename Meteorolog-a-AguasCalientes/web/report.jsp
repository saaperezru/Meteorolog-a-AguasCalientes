<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.meteorologaaguascalientes.dao.AbstractVariableDao"%>
<%@page import="org.meteorologaaguascalientes.control.measure.Measure"%>
<%@page import="org.meteorologaaguascalientes.control.measure.MeasuresList"%>
<%@page import="org.meteorologaaguascalientes.control.report.ReportsControl"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.*"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%!    Map<String, Double> report;
%>
<%
    Gson g = new Gson();
    JsonArray array = new JsonArray();
    String measureName = request.getParameter("measure");
    if (measureName != null) {
        MeasuresList measuresList = MeasuresList.getInstance();
        Measure measure = measuresList.getCentralTendencyMeasure(measureName);
        if (measure == null) {
            measure = measuresList.getSpreadMeasure(measureName);
        }
        if (measure != null) {
%>
<%

    
    ReportsControl reportsControl = new ReportsControl();
    report = reportsControl.getReport(measure);

    JsonObject object;

    for (Map.Entry<String,Double> entry : report.entrySet()){
	    object = new JsonObject();
	    object.addProperty("name", entry.getKey());
	    object.addProperty("value", entry.getValue());
	    array.add(object);
    }
    
        }
    }
%>
<%= g.toJson(array) %>