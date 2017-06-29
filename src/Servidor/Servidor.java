/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.net.*; // Para Socket, ServerSocket
import java.io.*; // Para IOException e Input/OutputStream
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leour
 */
public class Servidor extends Thread  {

	private static final int BUFSIZE = 50; // Tamanho do buffer de recepcao
       
        @Override
       public void run () {
         
	 //if (args.length != 1)
 
 		//throw new IllegalArgumentException("Parametro(s): <Porta>");

	 //int servPort = Integer.parseInt(args[0]);

	 // Cria um server socket para aceitar conexoes do cliente
         //List candidatos = new ArrayList();
         Candidato[] candidato= new Candidato[6];
         Candidato[] auxCandidatos= new Candidato[6];
         Thread threadConexão;
         Metodos_Servidor serv = new Metodos_Servidor();
         
         
         //Candidato(int codigo, String nome, String partido)
         candidato[0] = new Candidato(1,"Roni","BSI");
         candidato[1] = new Candidato(2,"Brenda","Poliglota");
         candidato[2] = new Candidato(3,"Capitu","Obliquo");
         candidato[3] = new Candidato(4,"Angelica","TAXI");
         candidato[4] = new Candidato(5,"Faustao","Churrasqueira");
         candidato[5] = new Candidato(6,"Tales","Colombia");
         
         //candidatos.add(aux[0]);
         //candidatos.add(aux[1]);
         //candidatos.add(aux[2]);
        // candidatos.add(aux[3]);
         //candidatos.add(aux[4]);
        // candidatos.add(aux[5]);
         
         
         //byte[] byteBuffer = new byte[50]
         
         
        
   
    
  
         
	 ServerSocket servSock = null;
            try {
                servSock = new ServerSocket(2525);
                // servSock = new ServerSocket(40005);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
	 System.out.println("Servidor pronto para aceitar conexoes...");	
	 int recvMsgSize; // Tamanho da mensagem de recepÃ§Ã£o
	 byte[] byteBuffer = new byte[BUFSIZE]; // Buffer de recpcao
         
         Socket clntSock = null;
            try {
                clntSock = servSock.accept(); // Aceita a conexao com o cliente
                //System.out.println("Atendimento do cliente " + clntSock.getInetAddress().getHostAddress() + " na porta " + clntSock.getPort());
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
	
         //for (;;) { // Sempre em execucao, aceitando conexoes
            while(true){
             
		 InputStream in = null;
             try {
                 in = clntSock.getInputStream();
             } catch (IOException ex) {
                 Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
             }

		 OutputStream out = null;
             try {
                 out = clntSock.getOutputStream();
             } catch (IOException ex) {
                 Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
             }
                 DataInputStream input = null;
             try {
                 input = new DataInputStream(clntSock.getInputStream());
             } catch (IOException ex) {
                 Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
             }

             try {
                 // Recebe dados atÃ© que a conexao com o cliente seja finalizada, indicada pelo -1
                 
                 // while ((recvMsgSize = in.read(byteBuffer)) != -1){
       
                 //      out.write(byteBuffer, 0, recvMsgSize);
                 
                 // }
                 in.read(byteBuffer);
             } catch (IOException ex) {
                 Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
             }
                 int i = byteBuffer[0];
                 
                 System.out.println("Mensagem recebida número:  " + i);
      
                 if(i==6){//seria o 999
                     serv.carregar_cliente(i, out, in);
                    
                 }
                 
                  if(i== 5){//seria o 888                 
                    serv.atualizarLista_servidor(out, in, input);
                    break;    
            }
                 
                 else if(i== 7) 
                     break;
                  // Fecha o socket.
                  
	 } // Fim do For
            try {
                clntSock.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
         System.out.println("saiu co loop, fechou /n server");
         
      }
    }
//}
   //}.start();   

