<%@page import="java.util.Map.Entry"%>
<%@page import="org.meteorologaaguascalientes.businesslogic.facade.ServiceFacade"%>
<%@page import="org.meteorologaaguascalientes.vo.VariableVo"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<% Map<String, Object> lastValues;
%>
<%

    ServiceFacade serviceFacade = new ServiceFacade();
    HashMap<String, VariableVo> lastVariablesVo= serviceFacade.getLastValues();
    // Expected data model
    lastValues = new HashMap<String, Object>();
    Date timestamp = null;
    for (Entry<String,VariableVo> entry: lastVariablesVo.entrySet()) {
        if (entry.getValue() == null) {
            lastValues.put(entry.getKey(), "-");
        } else {
            timestamp = entry.getValue().getTime();
            lastValues.put(entry.getKey(), entry.getValue().getValue());
        }
    }
    if (timestamp == null) {
        lastValues.put("sample", "-");
    } else {
        lastValues.put("sample", timestamp);
    }
%>
<%
    Properties prop = new Properties();
    prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));

    Gson g = new Gson();
    JsonArray array = new JsonArray();
    JsonObject object;

    // Date formatting
    for (Map.Entry<String, Object> entry : lastValues.entrySet()) {
        if (entry.getValue() instanceof Date) {
            SimpleDateFormat formatter = new SimpleDateFormat(prop.getProperty(entry.getKey() + ".extra"));
            entry.setValue(formatter.format(entry.getValue()));
        }
        object = new JsonObject();
        object.addProperty("name", entry.getKey());
        object.addProperty("value", entry.getValue().toString());
        array.add(object);
    }
%>
<%= g.toJson(array)%>
