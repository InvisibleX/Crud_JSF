package controler;

import bean.ClienteBean;
import dao.ClienteDAO;
import java.sql.SQLException;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class Cliente_Controler {
    
    public Cliente_Controler() {}
    
    
    
    private ClienteBean cliente;

    //Variavel que armazdenará em um DataModel os clientes cadastrados
    private DataModel model;
    
    
    
    
    
//##############################################################################
    
    
    
    
    
    
    
    
    
        public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }
    
    
//##############################################################################
    
    
    
    //Este método chama o ClienteBean para limpar todos os dados existentes neste bean. O retorno deste método é uma String chamada nome, a qual será utilizada pelo faces config para chamar o formulário de cadastro.
    
    

    public String novoCliente(){
        this.cliente = new ClienteBean();
            return "Novo";
                
    }
    
    
    public DataModel getTodos()throws SQLException{
        ClienteDAO dao = new ClienteDAO();
/*Este método acessa o método TodosClientes()
  existente na classe DAO e armazena essas informações dentro de um DataModel, o retorno deste DataModel tem o propósito de criar uma tabela de dados JSF */
        model = new ListDataModel(dao.todosClientes());
        return model;
        
    }
    
    
    
    
}
