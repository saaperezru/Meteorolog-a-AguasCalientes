<%@page import="java.util.Map.Entry"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json" %>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%! boolean success = false;
%>
<%
    Map<Dao, String> values = new HashMap<Dao, String>();
    String value;
    for (Entry<String,Dao> entry : DaoList.getInstance().getDaoMap().entrySet()) {
        value = request.getParameter(entry.getKey());
        if (value != null) {
            values.put(entry.getValue(), value);
        }
    }
%>
<%--
    // InsertControl invocation
    InsertControl insertControl = new InsertControl();
    success = insertControl.insert(values);
--%>
<%
    success = true;
%>
<json:object>
    <json:property name="success" value="<%= success %>"/>
</json:object>