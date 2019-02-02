import java.net.ServerSocket;
import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class Servidor {
  public static void main(String[] args) throws IOException {
    ServerSocket servidor = new ServerSocket(12345);
    System.out.println("Porta 12345 aberta!");
	
	
    Socket cliente = servidor.accept();
    System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());
    //Scanner entrada = new Scanner(cliente.getInputStream());
	InputStream is = cliente.getInputStream();
	
	FileOutputStream fos = new FileOutputStream(new File("c:\\Trabalho\\Transferido.txt"));
	System.out.println("Criou arquivo");
	byte[] cbuffer = new byte[1024];
    int bytesRead;
	 while ((bytesRead = is.read(cbuffer)) != -1) {
                fos.write(cbuffer, 0, bytesRead);
                fos.flush();
            }



    //entrada.close();
    servidor.close();
  }
}
