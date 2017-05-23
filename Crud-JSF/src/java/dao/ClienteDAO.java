/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ClienteBean;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class ClienteDAO {
    private Connection conexao;
    public ClienteDAO(){
        try {
            this.conexao= ConnectionFactory.getConnection();
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }
    }
    
    
    
    
    //cada ação no BD terá um metódo específico 
    
    //método para listar todos os clientes
    public List todosClientes() throws SQLException {
        
        try {
            //criar o preparedStatment para a consulta
            
            PreparedStatement pstm = conexao.prepareStatement("Select * from clientes");
            
            //criar o ResultSet e armazenar os dados retornados pela consulta 
            
            ResultSet rs = pstm.executeQuery();
            
            List<ClienteBean> listaDeClientes = new ArrayList<ClienteBean>();
            
            while(rs.next()){
                //criar um novo objeto do tipo cliente
                ClienteBean cliente = new ClienteBean();
                cliente.setCodigo(rs.getInt("codigo"));
                 cliente.setNome(rs.getString("nome"));
                  cliente.setNascimento(rs.getString("nascimento"));
                  cliente.setEndereco(rs.getString("endereco"));
                  cliente.setCidade(rs.getString("cidade"));
                  cliente.setStatus(rs.getInt("status"));
                  
                  
                  //add o objeto cliente na listaCliente
                  
                  listaDeClientes.add(cliente);
            }
                  pstm.close();
                  rs.close();
                  return listaDeClientes;
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
             return null;
        }  
       
    }
    public void Inserir(ClienteBean c) throws SQLException{
        String sql = ("INSERT INTO clientes VALUES (?,?,?,?,?,?)");
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        pstm.setInt(1,c.getCodigo());
        pstm.setString(2,c.getNome());
        pstm.setString(3,c.getNascimento());
        pstm.setString(4,c.getEndereco());
        pstm.setString(5,c.getCidade());
        pstm.setInt(6,c.getStatus());
        pstm.executeUpdate();
        pstm.close();
        conexao.close();
     
               
    }
    
    
}
