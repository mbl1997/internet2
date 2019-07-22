/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.List;
import model.Produto;
import java.util.ArrayList;

/**
 *
 * @author marib
 */
public class RepositorioProdutos {
    
    private static RepositorioProdutos instancia;
    private List<Produto>listaProdutos;
    //Variavel que simula o autoincrement
    private int autoIncrement;
    
    
    private RepositorioProdutos (){
       listaProdutos = new ArrayList();
       listaProdutos.add(new Produto(1,"Arroz", 2.50));
       listaProdutos.add(new Produto(2,"Feijao", 5.25));
       listaProdutos.add(new Produto(3,"Massa", 3.20));
       // Inicia com 4 devido aos registros já inseridos
       autoIncrement = 4; 
    }
    
    public static synchronized RepositorioProdutos getInstance(){
        if(instancia == null){
            instancia = new RepositorioProdutos();
        }
        return instancia;
    }
    
    public void inserir (Produto p){
        // Se o código for zero (não passar o código)
        // Simula um autoincrement
     if (p.getCodigo()==0){
         p.setCodigo(autoIncrement++);
     }   
     listaProdutos.add(p);
    }
    
    public List<Produto> listar(){
        return listaProdutos;
    }
    
    public Produto buscarPorCodigo (int cod){
        for(Produto p: listaProdutos){
            if(p.getCodigo() == cod)
                //Clonando objetivo -> só para leitura
          return new Produto(p.getCodigo(),
              p.getNome(), p.getPreco());
        }
        return null;
    }
    
    
    private int getIndice (int codigo){
        for(int i=0; i<listaProdutos.size(); i++)
            if(listaProdutos.get(i).getCodigo() == codigo)
                return i; 
        return -1;
    }
    
   public void atualizar (Produto prod){
        listaProdutos.set(this.getIndice(prod.getCodigo()),prod);
   } 
    
    public void excluir(Produto prod){
        listaProdutos.set(this.getIndice(prod.getCodigo()), prod);
    }   
}

