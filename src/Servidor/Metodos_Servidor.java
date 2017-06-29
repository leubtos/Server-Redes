/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leour
 */
public class Metodos_Servidor {
    
    //static boolean estaSendoUsado = false;
    
    public void carregar_cliente(int i,OutputStream out,InputStream in){//caso 999 ou 6
        
        for(int j=0;j<6;j++){
                        
                        byte[] byteAux = new byte[50];
                        byte[] byteBuffer = new byte[50];
                        String nome =Candidato.candidatos[j].getNome();

                        byteAux=nome.getBytes();


                        try {
                            out.write(Candidato.candidatos[j].getCodigo());
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            in.read(byteBuffer);
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i = byteBuffer[0];

                        if(i==1){
                            try {
                                out.write(byteAux);
                            } catch (IOException ex) {
                                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        try {
                            in.read(byteBuffer);
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i = byteBuffer[0];

                        if(i==1){
                            nome =Candidato.candidatos[j].getPartido();
                            byteAux=nome.getBytes();
                            try {
                                out.write(byteAux);                                               
                            } catch (IOException ex) {
                                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
    
    
    }
    
    
    public void atualizarLista_servidor(OutputStream out,InputStream in, DataInputStream input){//caso 888 ou 5
       // while (estaSendoUsado) {
       //     try {
       //         TimeUnit.MILLISECONDS.sleep(500);
       //     }
       //     catch(InterruptedException e) {
       //         System.out.println(e.getMessage());
        //    }
       // }
        //estaSendoUsado = true;
    String votosaux;
                    int auxiliar;
                    int k = 0;
                    int num;
                
                        for(int j = 0; j < 6; j++){

                           byte[] codigo = new byte[50];
                           byte[] nome = new byte[50];
                           byte[] qtdVotos = new byte[4];
                           byte[] partido = new byte[50];

                        try {
                            ///------ PEGANDO CODIGO DO CANDIDATO
                            in.read(codigo);
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            auxiliar = codigo[0];
                        try {                            
                            out.write(1);
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {                            
                            k=input.readInt();
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            out.write(1);                            
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }

                           Candidato.candidatos[j].incremento_votos(k);
                        }
                        
                         for(int j = 0; j < 6; j++){
                            System.out.println(" nome: " + Candidato.candidatos[j].getNome() + "  codigo: " +Candidato.candidatos[j].getCodigo() +
                                    "  partido: " + Candidato.candidatos[j].getPartido() + "  quantidade votos: " +
                                    Candidato.candidatos[j].getQtd_votos() );
                            System.out.println("------------------------------------");
                         }
                        
                         //estaSendoUsado = false;
    }
    
    
    
}
