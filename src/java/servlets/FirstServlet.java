package servlets;

import entidades.Categoria;
import entidades.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String color = request.getParameter("color");
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");

        out.println(
                "<!DOCTYPE html>\n"
                + "<html> \n"
                + "<head> \n"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n"
                + "<title> Java WEB  </title> \n"
                + "</head> \n"
                + "<body> \n"
                + "<font size=\"12px\" color=\"" + color + "\">" + nombre + " (" + dni + ")"
                + "</font> \n"
        );

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String user = "root";
        String password = "";

        String url = "jdbc:mysql://localhost:3306/proyecto2?user=" + user
                + "&password=" + password;

        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url);

            stm = con.createStatement();

            String sql;
            
            sql = "SELECT productos.*, categorias.categoria AS nombreCategoria";
            
            sql += " FROM productos, categorias";
            
            sql += " WHERE productos.idCategoria = categorias.idCategoria";

            rs = stm.executeQuery(sql);

            

            while (rs.next()) {

                Producto producto = new Producto();

                producto.setId(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setImagen(rs.getString("imagen"));
                
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNombre( rs.getString("nombreCategoria") );
                
                producto.setCategoria(categoria);
                
                listaProductos.add(producto);
            }

            stm.close();
            rs.close();

            con.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontro el Driver de MySQL");
        } catch (SQLException e) {
            out.println(e.getMessage());

        }

        out.println("</body> \n"
                + "</html>");

       


        request.setAttribute("productos", listaProductos);
        /*request.setAttribute("descripcion", "Mouse Logitech MX280");
         request.setAttribute("precio", 1200);*/

        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
