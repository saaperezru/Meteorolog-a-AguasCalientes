<%@page import="org.meteorologaaguascalientes.control.InsertControl"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json" %>
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
    InsertControl insertControl = new InsertControl();
    success = insertControl.insertValues(values);
%>
<json:object>
    <json:property name="success" value="<%= success %>"/>
</json:object>