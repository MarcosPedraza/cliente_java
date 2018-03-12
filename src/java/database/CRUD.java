/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author root
 */
public class CRUD {
    
    public void InsertarDatos(Datos to) throws Exception
    {
        Connection connection = cnMySQL.getInstance().getConnection();
        String operacion = "insert into tbusuarios(nombre,monto,estado) values"
                            + "('"+ to.getNombre()+"','"+to.getMonto()+"','"+ to.getEstado()+" ')";
        PreparedStatement query = connection.prepareStatement(operacion);
        query.execute();
        
    }
    public ResultSet cargarDatos() throws Exception
    {
        Connection connection = cnMySQL.getInstance().getConnection();
        PreparedStatement query2 = connection.prepareStatement("select * from tbusuarios");
        ResultSet rs = query2.executeQuery();
        return rs;
    }
    
     public ResultSet buscarDatos(String id) throws Exception
    {
        int mId = Integer.valueOf(id);
        Connection connection = cnMySQL.getInstance().getConnection();
        PreparedStatement query2 = connection.prepareStatement("select * from tbusuarios where id="+mId);
        ResultSet rs = query2.executeQuery();
        return rs;
    }
    
    
     public void modificarDatos(Datos to) throws Exception
    {
        Connection connection = cnMySQL.getInstance().getConnection();
        String operacion = "update tbusuarios set nombre ='"+ to.getNombre()+"', monto ="+to.getMonto()+", estado ='"+to.getEstado()+"'"
                            + "where id ="+to.getId();
        PreparedStatement query = connection.prepareStatement(operacion);
        query.execute();
        
    }
      public void borrarDatos(Datos to) throws Exception
    {
        Connection connection = cnMySQL.getInstance().getConnection();
        String operacion = "delete from tbusuarios where id ="+to.getId();
        PreparedStatement query = connection.prepareStatement(operacion);
        query.execute();
        
    }
    
}
