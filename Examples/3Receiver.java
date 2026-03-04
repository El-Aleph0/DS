import java.net.*;
public class Ejemplo3Receptor{
	public static void main(String [] args){
		if(args.length != 4){
			System.out.println("necesita 4 argumentos de linea de mandato");
		}else{
			
			try{
				
				InetAddress maquinaEmisora = InetAddress.getByName(args[0]);//saco la ip 
				int puertoEmisor = Integer.parseInt(args[1]);// meto el puertoEmisor 
				int miPuerto = Integer.parseInt(args[2]);
				String mensaje =args[3];
				
				MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
				
				miSocket.connect(maquinaEmisora,puertoEmisor);
				
				for(int x=0; x<10; x++)
					
					System.out.println(miSocket.recibeMensaje());
					
				miSocket.enviaMensaje(maquinaEmisora, puertoEmisor, mensaje);
				
				
				miSocket.close();
				
			}catch(Exception ex){
				
				
			System.out.println(ex);
				
			}
		}
		
	}
}