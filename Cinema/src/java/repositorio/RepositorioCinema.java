/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.List;
import model.Cinema;
import java.util.ArrayList;

/**
 *
 * @author marib
 */
public class RepositorioCinema {
    
private static RepositorioCinema instancia;
    private List<Cinema>listaCinema;
    //Variavel que simula o autoincrement
    private int autoIncrement;
    
    
    private RepositorioCinema (){
       listaCinema = new ArrayList();
       listaCinema.add(new Cinema(1,"MEU MALVADO FAVORITO","INFANTIL"));
       listaCinema.add(new Cinema(2,"50 TONS DE CINZA" ,"ROMANCE"));
       listaCinema.add(new Cinema(3,"X- MEN", "AÇÃO" ));
       listaCinema.add(new Cinema(4,"JURASSIC WORLD", "AVENTURA" ));
       listaCinema.add(new Cinema(5,"HOMEM FORMIGA E A MULHER VESPA", "FANTASIA" ));
       
       // Inicia com 4 devido aos registros já inseridos
       autoIncrement = 4; 
    }
    
    public static synchronized RepositorioCinema getInstance(){
        if(instancia == null){
            instancia = new RepositorioCinema();
        }
        return instancia;
    }
    
    public void inserir (Cinema c){
        // Se o código for zero (não passar o código)
        // Simula um autoincrement
     if (c.getCodigo()==0){
         c.setCodigo(autoIncrement++);
     }   
     listaCinema.add(c);
    }
    
    public List<Cinema> listar(){
        return listaCinema;
    }
    
    public Cinema buscarPorCodigo (int cod){
        for(Cinema c: listaCinema){
            if(c.getCodigo() == cod)
                //Clonando objetivo -> só para leitura
          return new Cinema(c.getCodigo(),
              c.getNome(), c.getGenero());
        }
        return null;
    }
    
    
    private int getIndice (int codigo){
        for(int i=0; i<listaCinema.size(); i++)
            if(listaCinema.get(i).getCodigo() == codigo)
                return i; 
        return -1;
    }
    
   public void atualizar (Cinema cine){
        listaCinema.set(this.getIndice(cine.getCodigo()),cine);
   } 
    
    public void excluir(Cinema cine){
        listaCinema.set(this.getIndice(cine.getCodigo()), cine);
    }   
}
