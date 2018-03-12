/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author root
 */
public class Datos {
    private int id;
    private String nombre;
    private float monto;
    private String estado;
    public Datos(int v_id, String v_nombre, float v_monto, String v_estado)
    {
        this.id = v_id;
        this.nombre = v_nombre;
        this.monto = v_monto;
        this.estado = v_estado;
    
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public float getMonto()
    {
        return monto;
    }
    public void setMonto(float monto)
    {
        this.monto = monto;
    }
    public String getEstado()
    {
        return estado;
    }
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
}
