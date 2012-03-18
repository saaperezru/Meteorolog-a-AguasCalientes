<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="org.meteorologaaguascalientes.control.measure.MeasuresList"%>
<%@page import="org.meteorologaaguascalientes.control.measure.Measure"%>
<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.AbstractVariableDao"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Properties prop = new Properties();
    prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
    DaoList daoList = DaoList.getInstance();
    Map<String,Dao> daoMap = DaoList.getInstance().getDaoMap();
    Map<String,AbstractVariableDao> variableList = daoList.getVariablesDaoMap();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Central Meteorológica Aguas Calientes</title>
        <link href='http://fonts.googleapis.com/css?family=Didact+Gothic' rel='stylesheet' type='text/css'>
        <link href="css/smoothness/jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css" />
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js" ></script>
        <script type="text/javascript" src="js/dygraph-combined.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function(){
                var g = new Dygraph(document.getElementById("dygraph"), "", {animatedZooms: true});
                jQuery("input:submit").button();
                jQuery("#tabs").tabs();
                jQuery("#variable").buttonset();
                jQuery("#variable input[type=radio]").click(function(){
                    var j = jQuery(this);
                    g.updateOptions({file: "history?variable=" + j.val()});
                });
                jQuery("#variable input[type=radio]:first").click();
                jQuery("#centralTendency").change(function(){
                    getReport(jQuery(this), "CentralTendency");
                });
                jQuery("#spread").change(function(){
                    getReport(jQuery(this), "Spread");
                });
                var f = jQuery("#insertForm");
                f.submit(function(){
                    jQuery.post(f.attr("action"), f.serialize(), function(data){
                        var m = jQuery("#message");
                        m.removeClass("success");
                        m.removeClass("error");
                        if(data.success){
                            m.html("Inserción exitosa");
                            m.addClass("success");
                            getLastValues();
                        } else {
                            m.html("Error en la inserción");
                            m.addClass("error");
                        }
                    });
                    return false;
                });
                getLastValues();
            });
            
            function getLastValues() {
                jQuery.get("lastValues.jsp", function(data){
                    for(var i in data){
                        jQuery("#" + data[i].name + "LastValue").html(data[i].value);
                    }
                });
            }
            
            function getReport(j, suffix){
                var measure = j.val();
                if("" == measure){
                    jQuery("td[id$='" + suffix + "']").html("-");
                } else {
                    jQuery.get("report.jsp?measure=" + measure, function(data){
                        for(var i in data){
                            jQuery("#" + data[i].name + suffix).html(data[i].value);
                        }
                    });
                }
            }
        </script>
    </head>
    <body>
        <div style="width: 80%; margin-left: auto; margin-right: auto;">
            <h1>Central Meteorológica Aguas Calientes</h1>
            <form id="insertForm" action="insert.jsp" method="post">
                <table class="main-table">
                    <thead>
                        <tr>
                            <th>&nbsp;</th>
                            <%
                                for (Entry<String,Dao> entry : daoMap.entrySet()) {
                            %>
                            <th><%= prop.getProperty("dao." + entry.getKey())%> [<%= prop.getProperty("dao." + entry.getKey() + ".extra")%>]</th>
                            <%}%>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Último valor</td>
                            <%
                                for (Entry<String,Dao> entry : daoMap.entrySet()) {
                            %>
                            <td id="<%= entry.getKey()%>LastValue">-</td>
                            <%}%>
                        </tr>
                        <tr>
                            <td>Nuevo valor</td>
                            <%
                                for (Entry<String,Dao> entry : daoMap.entrySet()) {
                            %>
                            <td>        
                                <input type="text" name="<%= entry.getKey()%>" required="required" />
                            </td>
                            <%}%>
                        </tr>
                        <tr>
                            <td colspan="<%= daoMap.size()%>" id="message" style="text-align: right;"></td>
                            <td style="text-align: right;"><input type="submit" value="Enviar"/></td>
                        </tr>
                    </tbody>
                </table>
                <br/><br/>
            </form>
            <div id="tabs">
                <ul>
                    <li><a href="#tab-1">Histórico</a></li>
                    <li><a href="#tab-2">Reportes</a></li>
                </ul>
                <div id="tab-1">
                    <form id="historyForm" action="history.jsp" method="get">
                        <div id="variable">
                            <%
                                for (Entry<String,AbstractVariableDao> entry : variableList.entrySet()) {
                            %>
                            <input type="radio" name="variable" id="variable<%= entry.getKey()%>" value="<%= entry.getKey()%>"><label for="variable<%= entry.getKey()%>"><%= prop.getProperty("dao." + entry.getKey())%></label></input>
                            <%        }
                            %>
                        </div>
                        <div id="dygraph">
                        </div>
                    </form>
                </div>
                <div id="tab-2">
                    <table>
                        <thead>
                            <tr>
                                <th>Medida</th>
                                <%
                                    for (Entry<String,AbstractVariableDao> entry : variableList.entrySet()) {
                                %>
                                <th><%= prop.getProperty("dao." + entry.getKey())%> [<%= prop.getProperty("dao." + entry.getKey() + ".extra")%>]</th>
                                <%        }
                                %>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <select id="centralTendency">
                                        <option value=""></option>
                                        <%
                                            for (String key : MeasuresList.getInstance().getCentralTendencyMeasuresKeys()) {
                                        %>
                                        <option value="<%=key%>"><%= prop.getProperty("measure." + key)%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                        <div id="variable">
                            <%
                                for (Entry<String,AbstractVariableDao> entry : variableList.entrySet()) {
                            %>
                            <td id="<%= entry.getKey()%>CentralTendency">-</td>
                            <%        }
                            %>
                            </tr>
                            <tr>
                                <td>
                                    <select id="spread">
                                        <option value=""></option>
                                        <%
                                            for (String key : MeasuresList.getInstance().getSpreadMeasuresKeys()) {
                                        %>
                                        <option value="<%=key%>"><%= prop.getProperty("measure." + key)%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                                <%
                                    for (Entry<String,AbstractVariableDao> entry : variableList.entrySet()) {
                                %>
                                <td id="<%= entry.getKey()%>Spread">-</td>
                                <%        }
                                %>
                            </tr>
                            </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
