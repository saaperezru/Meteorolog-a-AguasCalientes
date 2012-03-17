<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%--@page import="org.meteorologaaguascalientes.control.*" --%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json"%>
<%!    Map<String, Object> lastValues;
%>
<%--
    // LastValueControl invocation
    LastValueControl lastValueControl = new LastValueControl();
    lastValues = lastValueControl.getAllLastValues();
--%>
<%
    // Expected data model
    lastValues = new HashMap();
    lastValues.put("timestamp", new Date());
    lastValues.put("temperature", 25D);
    lastValues.put("atmosphericPressure", 100D);
    lastValues.put("pluviosity", 1D);
%>
<%
    // Date formatting
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
    lastValues.put("timestamp", formatter.format(lastValues.get("timestamp")));
%>
<json:array var="entry" items="<%= lastValues.entrySet()%>">
    <json:object>
        <json:property name="name" value="${entry.getKey()}" />
        <json:property name="value" value="${entry.getValue()}" />
    </json:object>
</json:array>