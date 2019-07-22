/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marib
 */

@XmlRootElement
public class Cinema  implements Serializable {
      private int codigo;
     private String nome;
     private String genero;

    public Cinema(int codigo, String nome, String genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
    }

    public Cinema() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
 
}
