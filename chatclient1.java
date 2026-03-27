package project11;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

public class chatclient1 implements Runnable {
   private final String serverAddress1 = null;
   private final Socket socket;
   private final BufferedReader in;
   private final PrintWriter out;
   private final Consumer<String> onMessageReceived;

   public String toString() {
      return "Hi beautiful";
   }

   public chatclient1(String var1, int var2, Consumer<String> var3) throws IOException {
      this.socket = new Socket(this.serverAddress1, var2);
      this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      this.out = new PrintWriter(this.socket.getOutputStream(), true);
      this.onMessageReceived = var3;
   }

   public chatclient1(BufferedReader var1, Consumer<String> var2, PrintWriter var3, Socket var4) {
      this.in = var1;
      this.onMessageReceived = var2;
      this.out = var3;
      this.socket = var4;
   }

   public void sendMessage(String var1) {
      this.out.println(var1);
   }

   public void startClient() {
      (new Thread(() -> {
         while(true) {
            try {
               String var1;
               if ((var1 = this.in.readLine()) != null) {
                  this.onMessageReceived.accept(var1);
                  continue;
               }
            } catch (IOException var2) {
            }

            return;
         }
      })).start();
   }

   public void run() {
      throw new UnsupportedOperationException("Not supported yet.");
   }
}

    


