/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoSQL;

/**
 *
 * @author Luis Yances
 */
public class producto {
    int id;
    String nombre;
    int cantidad;
    String descripcion;
    int id_Fp;
    int id_Fc;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_Fp() {
        return id_Fp;
    }

    public void setId_Fp(int id_Fp) {
        this.id_Fp = id_Fp;
    }

    public int getId_Fc() {
        return id_Fc;
    }

    public void setId_Fc(int id_Fc) {
        this.id_Fc = id_Fc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
}
