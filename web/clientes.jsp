<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>

        <%@ include file="header.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">

                        <%
                            Producto producto;
                            
                            for (int numTarjeta = 0; numTarjeta < ((ArrayList<Producto>) request.getAttribute("productos")).size(); numTarjeta++) {

                                producto = ((ArrayList<Producto>) request.getAttribute("productos")).get(numTarjeta);
                        %>

                        <div class="col-md-4">

                            <div class="card">

                                <img class="card-img-top" alt="Bootstrap Thumbnail First" src="https://www.layoutit.com/img/<%= producto.getImagen()%>" />

                                <div class="card-block">

                                    <h5 class="card-title">
                                        <%= producto.getNombre()%>
                                    </h5>

                                    <p class="card-text">
                                        <%= producto.getPrecio()%>
                                    </p>

                                    <p>
                                        <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#"><%= producto.getCategoria().getNombre()  %></a>
                                    </p>
                                </div>

                            </div>
                        </div>

                        <% }%>

                    </div>
                </div>
            </div>
        </div>




























        <%= request.getAttribute("name")%>

        <%= request.getAttribute("apellido")%>

        <table>

            <%
                int i;

                for (i = 0; i < 100; i++) {
            %>

            <tr>
                <td>Item <%= i%></td>
                <td>Item <%= i + 1%></td>
            </tr>
            <%
                }
            %>

        </table>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
