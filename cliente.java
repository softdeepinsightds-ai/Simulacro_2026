import java.io.*;
import java.net.Socket;

public class cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5000;
        
        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor");
            
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            
            salida.println("Hola servidor");
            String respuesta = entrada.readLine();
            System.out.println("Respuesta: " + respuesta);
            
            socket.close();
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}