<%@page import="org.meteorologaaguascalientes.control.measure.MeasuresFactory"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.meteorologaaguascalientes.businesslogic.facade.ServiceFacade"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.meteorologaaguascalientes.control.measure.Measure"%>
<%@page import="org.meteorologaaguascalientes.dao.CrudDao"%>
<%@page import="java.util.*"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%!    Map<String, Double> report;
%>
<%
    Gson g = new Gson();
    JsonArray array = new JsonArray();
    String measureName = request.getParameter("measure");
    if (measureName != null) {
        ServiceFacade serviceFacade = new ServiceFacade();
        report = serviceFacade.getReport(measureName);
        if (report.size() > 0) {
            JsonObject object;
            for (Map.Entry<String, Double> entry : report.entrySet()) {
                object = new JsonObject();
                object.addProperty("name", entry.getKey());
                object.addProperty("value", ((entry.getValue().toString().compareTo("NaN") == 0) ? "Datos insuficientes" : entry.getValue().toString()));
                array.add(object);
            }

        }
    }
%>
<%= g.toJson(array)%>