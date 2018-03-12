/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsDatos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import database.*;
import database.CRUD;
import static java.lang.Integer.parseInt;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
@WebService(serviceName = "WSDDatosSOAP")
public class WSDDatosSOAP {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consulta")
    public String consulta()
    {
      Gson gson = new Gson();
      ResultSet rs;
      CRUD db = new CRUD();
      try
      {
      rs = db.cargarDatos();
      ArrayList<Datos> usuarios = new ArrayList();
      Datos var_temp;
      while(rs.next())
      {
          var_temp = new Datos(parseInt(rs.getString(1)),rs.getString(2),parseInt(rs.getString(4)),rs.getString(3));
          usuarios.add(var_temp);
          
      }//termina while()
      String formatoJSON = gson.toJson(usuarios);
      return formatoJSON;
      //return "Holi crayoli!!";
      
      }catch(Exception ex)
      {
          return ex.getMessage();
      
      }//termina try catch()
     
    }//termina ----consulta---
    
     @WebMethod(operationName = "busqueda")
    public String busqueda(@WebParam(name="id")String id)
    {
        
        Gson gson = new Gson();
      ResultSet rs;
      CRUD db = new CRUD();
      try
      {
      rs = db.buscarDatos(id);
      ArrayList<Datos> usuarios = new ArrayList();
      Datos var_temp;
      while(rs.next())
      {
          var_temp = new Datos(parseInt(rs.getString(1)),rs.getString(2),parseInt(rs.getString(4)),rs.getString(3));
          usuarios.add(var_temp);
          
      }//termina while()
      String formatoJSON = gson.toJson(usuarios);
      return formatoJSON;
      //return "Holi crayoli!!";
      
      }catch(Exception ex)
      {
          return ex.getMessage();
      
      }//termina try catch()
     
     
    }//termina ----busqueda--
    
    
 @WebMethod(operationName = "insertar")
    public String insertar(@WebParam(name="json")String json)
    {
      Gson gson = new Gson();
     // ResultSet rs;
      CRUD db = new CRUD();
      Type tipoObjeto = new TypeToken<List <Datos>>(){}.getType();
      ArrayList<Datos> usuarios = gson.fromJson(json,tipoObjeto);
      Datos al = usuarios.get(0);
      try
      {
        db.InsertarDatos(al);
        return "registro...ok, este es el insert";
      
      }catch(Exception ex)
      {
          return ex.getMessage();
      
      }
    }//Aqui termina el Insert
    
    
     @WebMethod(operationName = "actualizar")
    public String actualizar(@WebParam(name="json")String json)
    {
          Gson gson = new Gson();
          CRUD db = new CRUD();
     Type tipoObjeto = new TypeToken<List <Datos>>(){}.getType();
      ArrayList<Datos> usuarios = gson.fromJson(json,tipoObjeto);
      Datos al = usuarios.get(0);
      try
      {
          
       db.modificarDatos(al);
        return "Modificación...ok, este es el update";
      
      
      }catch(Exception ex)
      {
          return "Error al hacer el update :(";
      
      }
    
    }//Aqui termina el Update
   
    
     @WebMethod(operationName = "borrar")
    public String borrar(@WebParam(name="json")String json)
    {
          Gson gson = new Gson();
          CRUD db = new CRUD();
     Type tipoObjeto = new TypeToken<List <Datos>>(){}.getType();
      ArrayList<Datos> usuarios = gson.fromJson(json,tipoObjeto);
      Datos al = usuarios.get(0);
      try
      {
          
       db.borrarDatos(al);
        return "Eliminación...ok, este es el delete";
      
      
      }catch(Exception ex)
      {
          return "Error al hacer el delete :(";
      
      }
    
    }//Aqui termina el Update
    
}//Y...aqui termina la clase principal 
