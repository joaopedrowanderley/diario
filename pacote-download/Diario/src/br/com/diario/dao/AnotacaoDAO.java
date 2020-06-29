/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.dao;

import br.com.diario.model.Anotacao;
import br.com.diario.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joão pedro
 */
public class AnotacaoDAO {
    private Connection con;
    private String sql;
    private PreparedStatement st;
    private ResultSet rs;
    
    public void inserir(Anotacao anotacao) throws Exception{
        con = ConnectionFactory.getConnection();
        
        sql = "insert into anotacao ( texto, data) values (?,?)";
        
        st = con.prepareStatement(sql);
        
        
        st.setString(1,anotacao.getTexto());
        
        java.sql.Date dataSql = new java.sql.Date(anotacao.getData().getTime());
        
        st.setDate(2, dataSql);
 
        
        st.executeUpdate();
        
        con.close();
    }
    
    public void editar(Anotacao anotacao) throws Exception{
        con = ConnectionFactory.getConnection();
        
        sql = "update anotacao set  texto = ?  where data = ?";
        
        st = con.prepareStatement(sql);
        
        
        st.setString(1, anotacao.getTexto());
        java.sql.Date dataSql = new java.sql.Date(anotacao.getData().getTime());
        st.setDate(2, dataSql);
        
        st.executeUpdate();
        
        con.close();
    }
    public void remover(Anotacao anotacao) throws Exception{
        con = ConnectionFactory.getConnection();
        
        sql = "delete from anotacao where data = ?";
        
        st = con.prepareStatement(sql);
        java.sql.Date dataSql = new java.sql.Date(anotacao.getData().getTime());
        st.setDate(1, dataSql);
        
        st.executeUpdate();
        
        con.close();
    }
    
    public List<Anotacao> listar() throws Exception{
        List<Anotacao> anotacao = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        sql = "select * from anotacao";
        st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Date data = rs.getDate("data");
            String texto = rs.getString("texto");
            
            Anotacao a = new Anotacao();

            a.setTexto(texto);
            a.setData(data);
            
            
           anotacao.add(a);
        }
        con.close();
        return anotacao;
    }
    
    public Anotacao buscar(Date data) throws Exception{
        Anotacao a = null;
        con = ConnectionFactory.getConnection();
        sql = "select * from anotacao where data = ?";
        st = con.prepareStatement(sql);
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        st.setDate(1, dataSql);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            String texto = rs.getString("texto");
            a = new Anotacao();
            a.setTexto(texto);
            a.setData(dataSql);
        }
        con.close();
        return a;
    }
}
