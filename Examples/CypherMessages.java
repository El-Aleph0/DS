import java.net.*;
import java.util.*;
public class JugandoEnviarMensajesCifrados{
	public static void main(String [] args){
		Scanner ent= new Scanner(System.in);
		
		System.out.println("Escribe lo que quieres hacer\n 1) Enviar mensaje \n 2) Esperar mensaje \n ");
		int opc = ent.nextInt();
		
		switch(opc){
			case 1://enviar mensaje
			
			System.out.println("Escribe tu mensaje: ");
			String mensaje = ent.nextLine();
			
			
			System.out.println("Escribe la IP del receptor: ");
			InetAddress maquinaEmisora = InetAddress.getByName(""+ent.nextLine());
			
			System.out.println("Escribe el puerto del receptor: ");
			int puertoReceptor = ent.nextInt();
			
			
			
			
			break;
			
			
			case 2://esperar mensaje
			
			
			
			
			break;
			
		}
		
		
		
		
		
		
		
		
		
		
	}
}