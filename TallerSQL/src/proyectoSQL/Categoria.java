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
public class Categoria {
   private int id_categoria;
   private String tipo_c;
   private String clase_c;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getTipo_c() {
        return tipo_c;
    }

    public void setTipo_c(String tipo_c) {
        this.tipo_c = tipo_c;
    }

    public String getClase_c() {
        return clase_c;
    }

    public void setClase_c(String clase_c) {
        this.clase_c = clase_c;
    }
    
    
}
