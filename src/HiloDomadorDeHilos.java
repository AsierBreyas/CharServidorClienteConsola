import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HiloDomadorDeHilos extends Thread {
	public Socket socket;

	public HiloDomadorDeHilos(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Llego papá");
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String salida;
			while(true) {
				while ((salida = bf.readLine()) != null) {
					System.out.println("Un cliente dice que: " + salida);
					Servidor.enviarMensajes(salida, this);
				}				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enviarMensaje(String mensaje) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(mensaje);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}