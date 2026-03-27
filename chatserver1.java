package project11;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class chatserver1 {
   private static final List<ClientHandler1> clients = new ArrayList();

   public chatserver1() {
   }

   public static void main(String[] var0) throws Exception {
      ServerSocket var1 = new ServerSocket(5000);
      Throwable var2 = null;

      try {
         System.out.println("server started.waiting for clients..");

         while(true) {
            Socket var3 = var1.accept();
            System.out.println("client connected:" + var3);
            ClientHandler1 var4 = new ClientHandler1(var3, clients);
            clients.add(var4);
            (new Thread(var4)).start();
         }
      } catch (Throwable var11) {
         var2 = var11;
         throw var11;
      } finally {
         if (var1 != null) {
            if (var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var10) {
                  var2.addSuppressed(var10);
               }
            } else {
               var1.close();
            }
         }

      }
   }
}
