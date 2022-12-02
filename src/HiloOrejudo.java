import java.io.BufferedReader;
import java.io.IOException;

public class HiloOrejudo extends Thread {
	BufferedReader bf;

	public HiloOrejudo(BufferedReader bf) {
		this.bf = bf;
	}

	@Override
	public void run() {
		String salida;
		while(true) {			
			try {
				while ((salida = bf.readLine()) != null) {
					System.out.println("Alguien:" + salida);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
