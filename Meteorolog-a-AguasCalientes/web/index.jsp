<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script type="text/javascript">
            jQuery(document).ready(function(){
                jQuery("input:submit").button();
                jQuery("#tabs").tabs();
                jQuery("#variable").buttonset();                
            });
        </script>
    </head>
    <body>
        <div style="width: 80%; margin-left: auto; margin-right: auto;">
            <h1>Central Meteorológica Aguas Calientes</h1>
            <form action="" method="post">
                <table class="main-table">
                    <thead>
                        <tr>
                            <th>&nbsp;</th>
                            <th>Tiempo (dd/MM/yyyy hh:mm:ss aa)</th>
                            <th>Temperatura [ºC]</th>
                            <th>Presión atmosférica [kPa]</th>
                            <th>Pluviosidad [l/m<sup>2</sup>]</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Último valor</td>
                            <td id="last-value-ts">-</td>
                            <td id="last-value-t">-</td>
                            <td id="last-value-ap">-</td>
                            <td id="last-value-p">-</td>
                        </tr>
                        <tr>
                            <td>Nuevo valor</td>
                            <td><input type="text" name="timestamp" required="required" title="Tiempo de la muestra en formato dd/MM/yyyy hh:mm:ss aa, como 28/01/2012 10:45:14 AM"/></td>
                            <td><input type="text" name="temperature" required="required" title="Temperatura en grados centígrados"/></td>
                            <td><input type="text" name="atmosphericPressure" required="required" title="Presión atmosférica en kilopascales"/></td>
                            <td><input type="text" name="pluviosity" required="required" title="Pluviosidad en litros sobre metro cuadrado" /></td>
                        </tr>
                        <tr>
                            <td colspan="5" style="text-align: right;"><input type="submit" value="Enviar"/></td>
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
                    <div id="variable">
                        <input type="radio" id="variable-t" name="variable" checked="checked"><label for="variable-t">Temperatura</label></input>
                        <input type="radio" id="variable-ap" name="variable"><label for="variable-ap">Presión atmosférica</label></input>
                        <input type="radio" id="variable-p" name="variable"><label for="variable-p">Pluviosidad</label></input>
                    </div>
                </div>
                <div id="tab-2">
                    <table>
                        <thead>
                            <tr>
                                <th>Medida</th>
                                <th>Temperatura [ºC]</th>
                                <th>Presión atmosférica [kPa]</th>
                                <th>Pluviosidad [l/m<sup>2</sup>]</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <select id="central-tendency-measure">
                                        <option value=""></option>
                                        <option value="mean">Media</option>
                                        <option value="median">Mediana</option>
                                        <option value="mode">Moda</option>
                                    </select>
                                </td>
                                <td id="report-ct-temperature">-</td>
                                <td id="report-ct-atmosphericPressure">-</td>
                                <td id="report-ct-pluviosity">-</td>
                            </tr>
                            <tr>
                                <td>
                                    <select id="spread-measure">
                                        <option value=""></option>
                                        <option value="standardDeviation">Desviación estándar</option>
                                        <option value="variance">Varianza</option>
                                        <option value="interquartileRange">Rango intercuartílico</option>
                                    </select>
                                </td>
                                <td id="report-s-temperature">-</td>
                                <td id="report-s-atmosphericPressure">-</td>
                                <td id="report-s-pluviosity">-</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
