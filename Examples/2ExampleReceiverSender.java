import java.net.*;
public class Ejemplo2ReceptorEmisor{
	public static void main(String [] args){
		if(args.length != 4){
			System.out.println("necesita 4 argumentos de linea de mandato");
		}else{
			
			try{
				
				InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
				int puertoReceptor = Integer.parseInt(args[1]);
				int miPuerto = Integer.parseInt(args[2]);
				String mensaje =args[3];
				
				MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
				
				System.out.println(miSocket.recibeMensaje());
				
				miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
				
				
				
				miSocket.close();
				
			}catch(Exception ex){
				
				
			System.out.println(ex);
				
			}
		}
		
	}
	
	
}