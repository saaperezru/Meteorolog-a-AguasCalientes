<%@page import="org.meteorologaaguascalientes.control.ServiceFacade"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.meteorologaaguascalientes.control.InsertControl"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.*"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%! boolean success = false;
%>
<%
    Map<String, String> values = new HashMap<String, String>();
    String value;
    for (Entry<String,Dao> entry : DaoList.getInstance().getDaoMap().entrySet()) {
        value = request.getParameter(entry.getKey());
        if (value != null) {
            values.put(entry.getKey(), value);
        }
    }
%>
<%
    // InsertControl invocation
    ServiceFacade serviceFacade = new ServiceFacade();
    success = serviceFacade.insertValues(values);
    
    Gson g = new Gson();
    JsonObject object = new JsonObject();
    object.addProperty("success", success);
%>
<%= g.toJson(object)%>