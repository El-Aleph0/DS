import java.net.*;
public class Ejemplo3Emisor{
	public static void main(String [] args){
		if(args.length != 4){
			System.out.println("necesita 4 argumentos de linea de mandato");
		}else{
			
			try{
				
				InetAddress maquinaReceptora = InetAddress.getByName(args[0]);//saco la ip de la otra pc
				int puertoReceptor = Integer.parseInt(args[1]);//nombro el otro puerto
				int miPuerto = Integer.parseInt(args[2]);//nombro mi puerto
				String mensaje =args[3];
				
				MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);//abre una conexion en mi pc en x puerto
				
				miSocket.connect(maquinaReceptora,puertoReceptor);//conecta con x maquina en x puerto
				
				for(int x=0; x<10; x++){
					
					miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
				
				
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
					System.out.println(miSocket.recibeMensaje());
				
					miSocket.disconnect();
				}
				miSocket.close();
				
			}catch(Exception ex){
				
				System.out.println(ex);
				
			}
		}
		
	}
	
	
}