import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class smtp {
    public static void main(String argv[])
    {
        try{


            Socket socketClient= new Socket("smtp2.bhsi.xyz",2525);
            System.out.println("Client: "+"Connection Established");

            BufferedReader IN = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            BufferedWriter OUT= new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));



            String serverMsg;

            OUT.write("HELO Localhost\r\n");
            OUT.write("MAIL FROM:<cvin@dtu.dk>\r\n");
            OUT.write("RCPT TO:<s171242@student.dtu.dk>\r\n");
            OUT.write("DATA\r\n");
            OUT.write("\r\n");
            OUT.write("Subject: SMTP!\r\n");
            OUT.write("\r\n");
            OUT.write("\r\n");
            OUT.write("TestTest123\r\n");
            OUT.write("\r\n");
            OUT.write("\r\n");
            OUT.write(".\r\n");
            OUT.write("quit\r\n");
            OUT.flush();
            while((serverMsg = IN.readLine()) != null){
                System.out.println("Client: " + serverMsg);
            }
        }catch(Exception e){e.printStackTrace();}
    }
}


