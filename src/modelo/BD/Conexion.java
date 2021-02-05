package modelo.BD;

import java.sql.*;

public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/sistemaventas";
    private static final String USER="root";    
    private static final String PASS="root23";
    private static final String CONTROLER="com.mysql.jdbc.Driver";
    
    private static Connection conn;
    private static PreparedStatement pstmt = null;

    public static Connection getConnection() {
        if(conn==null)
            Conectar();
        return conn;
    }
    
    public static boolean Conectar(){
        if(conn==null)
        {
            try {
                Class.forName(CONTROLER).newInstance();
                conn = DriverManager.getConnection(URL, 
                                                   USER,
                                                   PASS);            
                System.out.println("Conexion Establecida");
                return true;
            } catch (Exception e) { }     
        }
        return false;
    }
    //-------------------------------------------------------------------------
    public static boolean EjecutarSQL(String sql)
    {
        Conectar();
        try
        {
            Statement st =  conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            return true;            
        }
        catch(Exception e){}
        return false;       
    }
    //-------------------------------------------------------------------------
    public static ResultSet ConsultarSQL(String sql)
    {
        Conectar();
        try {
            Statement st =  conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            return res;
        } catch (Exception e) {}
        return null;
    }
    //------------------------------------------------------------------------
    public static PreparedStatement PrepararSentencia(String sql)
    {
        Conectar();
        try {
            pstmt = conn.prepareStatement(sql);                    
            return  pstmt;
        } catch (Exception e) {}
        return null;
    }    
    //-------------------------------------------------------------------------
    public static void Cerrar()
    {       
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (Exception e) {}
        }
    }      
    
    public static void main(String[] args) {
        Conexion.Conectar();
    }
}
