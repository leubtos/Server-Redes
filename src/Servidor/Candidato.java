/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author leour
 */
public class Candidato {
    
    int codigo_votacao;
    String nome_candidato;
    String partido;
    int num_votos;
    
    static Candidato[] candidatos = {
        new Candidato(1,"Roni","BSI"),
         new Candidato(2,"Brenda","Poliglota"),
         new Candidato(3,"Capitu","Obliquo"),
         new Candidato(4,"Angelica","TAXI"),
         new Candidato(5,"Faustao","Churrasqueira"),
         new Candidato(6,"Tales","Colombia")
    };
    
    
    public Candidato(int codigo, String nome, String partido){
        
        codigo_votacao=codigo;
        nome_candidato=nome;
        this.partido=partido;
        this.num_votos=0;
        
    }
    
    public Candidato(int codigo, String nome, String partido,int votos){
        
        codigo_votacao=codigo;
        nome_candidato=nome;
        this.partido=partido;
        this.num_votos=votos;
        
    }
    
    
    public int getCodigo(){
        
        return codigo_votacao;
        
    } 
    
    public String getNome(){
        
        return nome_candidato;
        
    } 
    
    
    public String getPartido(){
        
        return partido;
        
    } 
    
    public int getQtd_votos(){
        
        return num_votos;
        
    } 
    
    
    public void incremento_votos(){
        
        num_votos= num_votos + 1;
        
    }
    
    public void incremento_votos(int total ){
        
        num_votos= num_votos + total;
        
    } 
    
}
