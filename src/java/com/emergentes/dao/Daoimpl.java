
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GUIDO
 */
public class Daoimpl extends ConexionBD implements Dao{

    @Override
    public void insert(Producto producto) throws Exception {
	 try {
	    this.conectar();
	    String sql ="insert into productos(descripcion,stock)values(?,?)";
	     PreparedStatement ps = this .conn.prepareStatement(sql);
	     ps.setString(1, producto.getDescripcion());
	     ps.setInt(2, producto.getStock());
	     ///ejecutamos la consulta
	     ps.executeUpdate();
	} catch (Exception e) {
	    throw e;
	} finally{
		this.desconectar();
	        }
    }

    @Override
    public void update(Producto producto) throws Exception {
	 try {
	    this.conectar();
	    String sql ="UPDATE  productos set descripcion=?,stock=? where id=?";
	     PreparedStatement ps = this .conn.prepareStatement(sql);
	     ps.setString(1, producto.getDescripcion());
	     ps.setInt(2, producto.getStock());
	     ps.setInt(3, producto.getId());
	     ///ejecutamos la consulta
	     ps.executeUpdate();
	} catch (Exception e) {
	    throw e;
	} finally{
		this.desconectar();
	        }
    }

    @Override
    public void delete(int id) throws Exception {
		 try {
	    this.conectar();
	    String sql ="DELETE from  productos  where id=?";
	     PreparedStatement ps = this .conn.prepareStatement(sql);
	     ps.setInt(1, id);
	     ///ejecutamos la consulta
	     ps.executeUpdate();
	} catch (Exception e) {
	    throw e;
	} finally{
		this.desconectar();
	        }
    }

    @Override
    public Producto getById(int id) throws Exception {
	Producto prod=new Producto();
	try {
	    this.conectar();
	    String sql="select * from productos where id=?";
	    PreparedStatement ps = this .conn.prepareStatement(sql);
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if(rs.next()){
		prod.setId(rs.getInt("id"));
		prod.setDescripcion(rs.getString("descripcion"));
		prod.setStock(rs.getInt("stock"));
		
	    }
	} catch (Exception e) {
	    throw e;
	}finally{
	this.desconectar();
    }
	return prod;
    }

    @Override
    public List<Producto> getAll() throws Exception {
	
	List<Producto> lista = null;
	
	try {
	    this.conectar();
	    String sql="select * from productos";
	    PreparedStatement ps = this .conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    
	    //inicializar lista
	    
	    lista = new ArrayList<Producto>();
	    //bucle para trabajar con el registro enlsta
	    while(rs.next()){
		Producto prod = new Producto();
		prod.setId(rs.getInt("id"));
		prod.setDescripcion(rs.getString("descripcion"));
		prod.setStock(rs.getInt("stock"));
		
		//ADICIONAR AL LA COLECCION
		
		lista.add(prod);
	    }
	    rs.close();
	    ps.close();
	    
	} catch (Exception e) {
	    throw e;
	}finally{
	this.desconectar();
    }
	return lista;
	
    }
    
}
