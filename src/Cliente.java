import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			Socket socket = new Socket("localhost", 5555);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			HiloOrejudo hiloOreja = new HiloOrejudo(bf);
			hiloOreja.start();
			while(true) {
				String mensaje = sc.nextLine();
				bw.write(mensaje);
				bw.newLine();
				bw.flush();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
