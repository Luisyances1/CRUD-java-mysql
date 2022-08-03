/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoSQL;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Yances
 */
public class Controlador {
    
    public ArrayList<Proveedor> getProveedor(){
        
        
            Connection con = Conexion.getConexion();
            Statement stmt;
            ResultSet rs;
            ArrayList<Proveedor> listaP = new ArrayList<>();
        try {    
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM proveedor");
            
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setId_proveedor(rs.getInt("id_proveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getInt("telefono"));
                
                listaP.add(prov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaP;
    }
    
    public ArrayList<Categoria> getCategoria(){
        
        
            Connection con = Conexion.getConexion();
            Statement stmt;
            ResultSet rs;
            ArrayList<Categoria> listaC = new ArrayList<>();
        try {    
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM categoria");
            
            while(rs.next()){
                Categoria ctg = new Categoria();
                ctg.setId_categoria(rs.getInt("id_categoria"));
                ctg.setTipo_c(rs.getString("tipo_c"));
                ctg.setClase_c(rs.getString("clase_c"));
                
                listaC.add(ctg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaC;
    }
    
    public void insertar(int id_p, String nomb, int cant, String descr,int fp,int fc){
        PreparedStatement ps;
        String sql;
        producto p = new producto();
        p.setId(id_p);
        p.setNombre(nomb);
        p.setCantidad(cant);
        p.setDescripcion(descr);
        p.setId_Fp(fp);
        p.setId_Fc(fc);
        
        try{
            Connection con = Conexion.getConexion();
            sql="insert into producto(id_producto,nombre,cantidad,descripcion,id_p,id_c) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getCantidad());
            ps.setString(4, p.getDescripcion());
            ps.setInt(5, p.getId_Fp());
            ps.setInt(6, p.getId_Fc());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public DefaultTableModel Read(){
        String []  ncolumnas = {"id_producto","Nombre","Cantidad","Descripcion","id_p","id_c"};
        String [] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null,ncolumnas);
        
        String sql = "SELECT * FROM producto";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConexion();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id_producto");                
                registros[1] = rs.getString("nombre");                
                registros[2] = rs.getString("cantidad");
                registros[3] = rs.getString("descripcion");
                registros[4] = rs.getString("id_p");
                registros[5] = rs.getString("id_c");
                
                modelo.addRow(registros);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error NO se puede conectar a la BD"+e);
        }finally
        {
            try
            {
                if (rs != null) rs.close();                
                if (pst != null) pst.close();                
                if (con != null) con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
    public int Delete(String identifier){
        String sql = "DELETE from producto WHERE id_producto="+identifier;
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        int r=0;
        
        try{
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if(r > 0){
                JOptionPane.showMessageDialog(null, "El registro a sido eliminado");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un ERROR "+e.getMessage());
        } finally {
            try {
                ps = null;
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
    
    public int update(String identifier, String n, int cant, String dscp){
        String sql ="UPDATE producto SET nombre = '"+n+"',cantidad='"+cant+"',descripcion='"+dscp+"'WHERE id_producto="+identifier;
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        int r=0;
        
        try{
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if(r > 0){
                JOptionPane.showMessageDialog(null, "El registro a sido MODIFICADO");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un ERROR "+e.getMessage());
        } finally {
            try {
                ps = null;
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
}
