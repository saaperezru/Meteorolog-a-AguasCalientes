<%@page import="org.meteorologaaguascalientes.businesslogic.facade.ServiceFacade"%>
<%@page import="org.meteorologaaguascalientes.businesslogic.service.ServicesFactory"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.*"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%! boolean success = false;
%>
<%
    Map<String, String> values = new HashMap<String, String>();
    String value;
    for (String key : ServicesFactory.VARIABLES_NAMES) {
        value = request.getParameter(key);
        if (value != null) {
            values.put(key, value);
        }
    }
%>
<%
    // InsertControl invocation
    ServiceFacade serviceFacade = new ServiceFacade();
    success = serviceFacade.insertValues(values, request.getParameter("sample"));
    
    Gson g = new Gson();
    JsonObject object = new JsonObject();
    object.addProperty("success", success);
%>
<%= g.toJson(object)%>