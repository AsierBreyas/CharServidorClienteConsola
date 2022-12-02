import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	private static List<HiloDomadorDeHilos> hilosDomadores;

	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(5555);
			System.out.println("Servidor corriendo");
			hilosDomadores = new ArrayList<>();
			while (true) {
				HiloDomadorDeHilos hilo = new HiloDomadorDeHilos(socket.accept());
				hilo.start();
				hilosDomadores.add(hilo);
//				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void enviarMensajes(String mensaje, HiloDomadorDeHilos hiloPadre) {
		hilosDomadores.forEach((hilo) -> {
			if(hilo != hiloPadre) {
				hilo.enviarMensaje(mensaje);
			}
		});
	}

}
