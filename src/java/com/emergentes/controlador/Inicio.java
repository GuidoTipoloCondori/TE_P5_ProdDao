
package com.emergentes.controlador;

import com.emergentes.dao.Dao;
import com.emergentes.dao.Daoimpl;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GUIDO
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	try {
	     Dao dao=new Daoimpl();
	    //para resibir el id
	    int id;
	    //getionar avisos
	    Producto prod=new Producto();
	    String action =(request.getParameter("action")!=null)?request.getParameter("action"):"view";
	    switch(action){
		case "add":
		      request.setAttribute("producto", prod);//hace referencia a un solo objeto
		      request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
			break;
		case "edit":
		      id=Integer.parseInt(request.getParameter("id"));
		      prod =dao.getById(id);
		      request.setAttribute("producto", prod);
		      request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
			break;
		case "delete":
		      id=Integer.parseInt(request.getParameter("id"));
		      dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/Inicio");
			break;
		 default:
		    //listar los registros
		    List<Producto> lista = dao.getAll();
		    request.setAttribute("productos", lista);
		    request.getRequestDispatcher("listado.jsp").forward(request, response);
		      break;
	    }
	    
	} catch (Exception e) {
	    System.out.print("ERROR"+e.getMessage());
	}
	
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	 int id=Integer.parseInt(request.getParameter("id"));
	 String descripcion =request.getParameter("descripcion");
	 int stock=Integer.parseInt(request.getParameter("stock"));
	 
	 Dao dao=new Daoimpl();
	 Producto prod= new Producto();
	 
	 prod.setId(id);
	 prod.setDescripcion(descripcion);
	 prod.setStock(stock);
	 
	 if(id==0){
	     //nuevo registro
	     try {
		 dao.insert(prod);
		 response.sendRedirect(request.getContextPath()+"/Inicio");
	     } catch (Exception e) {
		 System.out.println("error"+e.getMessage());
	     }
	     
	 }else{
	     //actualizacion de un registro
	       try {
		 dao.update(prod);
		  response.sendRedirect(request.getContextPath()+"/Inicio");
	     } catch (Exception e) {
		 System.out.println("error"+e.getMessage());
	     }
	 }
	
    }



}
