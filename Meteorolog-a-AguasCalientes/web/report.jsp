<%@page import="org.meteorologaaguascalientes.dao.AbstractVariableDao"%>
<%@page import="org.meteorologaaguascalientes.control.measure.Measure"%>
<%@page import="org.meteorologaaguascalientes.control.measure.MeasuresList"%>
<%@page import="org.meteorologaaguascalientes.control.report.ReportsControl"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json" %>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%!    Map<String, Double> report;
%>
<%
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
    
%>
<json:array var="entry" items="<%= report.entrySet()%>">
    <json:object>
        <json:property name="name" value="${entry.getKey()}"/>
        <json:property name="value" value="${entry.getValue()}"/>
    </json:object>
</json:array>
<%
        }
    }
%>