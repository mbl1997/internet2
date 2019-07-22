/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import model.Cinema;
import repositorio.RepositorioCinema;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author marib
 */
@Path("Cinema")
public class CinemaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CinemaWS
     */
    public CinemaWS() {
    }

    /**
     * Retrieves representation of an instance of ws.CinemaWS
     * @return an instance of model.Cinema
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public List<Cinema> getProdutos(){
         return RepositorioCinema.getInstance().listar();
    }
     
     @GET
       @Path("/{codigo}")
     @Produces(MediaType.APPLICATION_JSON)
            public Cinema getProduto(@PathParam("codigo") int cod){
                return RepositorioCinema.getInstance().buscarPorCodigo(cod);
            }

    /**
     * PUT method for updating or creating an instance of ProdutoWS
     * @param content representation for the resource
     */
            
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
        public void adicionarCinema(Cinema c, @Context final HttpServletResponse response){
                RepositorioCinema.getInstance().inserir(c);
                //Alterar o codigo para 201(Created)
          response.setStatus(HttpServletResponse.SC_CREATED);  
          try{
              response.flushBuffer();
          }catch (IOException e){
              //Erro 500
              throw new InternalServerErrorException();
          }
        }
        
    @PUT     
        @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarCinema(@PathParam("codigo") int cod, Cinema  cinema){
         
         Cinema c = RepositorioCinema.getInstance().buscarPorCodigo(cod);
         c.setNome(cinema.getNome());
         c.setGenero(cinema.getGenero());
         RepositorioCinema.getInstance().atualizar(c);
    }
        
  @DELETE
   @Path("/{codigo}")
        @Produces(MediaType.APPLICATION_JSON)
  public Cinema removerCinema(@PathParam("codigo") int cod){
      Cinema c = RepositorioCinema.getInstance().buscarPorCodigo(cod);
      RepositorioCinema.getInstance().excluir(c);
      return c;
  }     
}