package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.List;

/**
 * @author GSR17
 */
public class DaoCliente implements DaoBasico{
    public DaoCliente(){
        String inst = "CREATE TABLE IF NOT EXISTS Cliente (\n" +
                      "  Codigo INT NOT NULL,\n" +
                      "  Nome VARCHAR(45) NOT NULL,\n" +
                      "  Telefone VARCHAR(12) NULL,\n" +
                      "  Celular VARCHAR(13) NULL,\n" +
                      "  PRIMARY KEY (Codigo));";
        System.out.println("Persistencia.DaoCliente.<init>()");
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public boolean incluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar(int iD1, int iD2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> carregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
