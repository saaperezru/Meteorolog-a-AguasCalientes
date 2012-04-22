<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="org.meteorologaaguascalientes.businesslogic.facade.HistoricControl"%>
<%@page import="org.meteorologaaguascalientes.helper.VariablesVoFactory"%>
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
	JsonObject object = new JsonObject();
	Gson g = new Gson();
	try {
		Map<String, String> values = new HashMap<String, String>();
		String value;
		for (String key : VariablesVoFactory.getVariableTypes()) {
			value = request.getParameter(key);
			if (value != null) {
				values.put(key, value);
			}
		}
		ServiceFacade serviceFacade = new ServiceFacade();
		success = serviceFacade.insertValues(values, request.getParameter("sample"));

		object.addProperty("success", success);

	} catch (Exception e) {
		Logger.getLogger(HistoricControl.class.getName()).log(Level.SEVERE, null, e);
	}
%>
<% // InsertControl invocation
%>
<%= g.toJson(object)%>