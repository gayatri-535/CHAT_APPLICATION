package project11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.List;


class ClientHandler1 implements Runnable {
   private final Socket clientSocket;
   private final List<ClientHandler1>clients;
   private final  PrintWriter out;
   private final BufferedReader in;  

    public ClientHandler1(Socket socket,List<ClientHandler1>clients)throws Exception
    {
        this.clientSocket=socket;
        this.clients=clients;
        this.out=new PrintWriter(clientSocket.getOutputStream(),true);
        this.in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }
    @Override
    public String toString(){
        return "Hi beautiful";
    }
   @Override
    public void run()
    {
        try {
            String inpString;
            while ((inpString=((BufferedReader) in).readLine())!=null) {
                for (ClientHandler1 aclient:clients) {
                    aclient.out.println(inpString);
                    
                } 
                
            }
        } catch (IOException e)
        {
        System.out.println("an error occured:"+e.getMessage());
        }
        finally{
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e)
             {
            }
        }
    }
}
