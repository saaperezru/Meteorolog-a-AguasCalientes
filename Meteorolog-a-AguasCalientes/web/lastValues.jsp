<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<% Map<String, Object> lastValues;    
%>
<%--
    // LastValueControl invocation
    LastValueControl lastValueControl = new LastValueControl();
    lastValues = lastValueControl.getAllLastValues();
--%>
<%
    // Expected data model
    lastValues = new HashMap<String,Object>();
    lastValues.put("sample", new Date());
    lastValues.put("temperature", Math.random());
    lastValues.put("atmosphericPressure", Math.random());
    lastValues.put("pluviosity", Math.random());
%>
<%
    Properties prop = new Properties();
    prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));

    Gson g = new Gson();
    JsonArray array = new JsonArray();
    JsonObject object;
    
    // Date formatting
    for (Map.Entry<String,Object> entry : lastValues.entrySet()) {
        if(entry.getValue() instanceof Date){
            SimpleDateFormat formatter = new SimpleDateFormat(prop.getProperty("dao." + entry.getKey() + ".extra"));
            entry.setValue(formatter.format(entry.getValue()));
        }
        object = new JsonObject();
        object.addProperty("name", entry.getKey());
        object.addProperty("value", entry.getValue().toString());
        array.add(object);
    }
%>
<%= g.toJson(array) %>
