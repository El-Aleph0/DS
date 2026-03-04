import java.net.*;
import java.io.*;
public class MiSocketDatagrama extends DatagramSocket{
	static final int MAX_LON=10;
	MiSocketDatagrama(int numPuerto) throws SocketException{
		super(numPuerto);
	}
	
	
	
	public void enviaMensaje(InetAddress maquinaReceptora/*manda la ip*/,int puertoReceptor/*puerto que lo recibe */, String mensaje)throws IOException{
		
		
		try{
			
				byte[] almacenEnvio = mensaje.getBytes();
		
		
		
		
		DatagramPacket datagrama= new DatagramPacket(almacenEnvio,almacenEnvio.length,maquinaReceptora, puertoReceptor);
		
		this.send(datagrama);
		
			}catch(Exception ex){
				
				
			System.out.println(ex);
				
			}
		
		
		
		
	}
	
	
	public String recibeMensaje (){
		String mensaje="";
		try{
		byte [] almacenRecepcion = new byte[MAX_LON];
		
		DatagramPacket datagrama= new DatagramPacket(almacenRecepcion,MAX_LON);
		this.receive(datagrama);
		mensaje= new String (almacenRecepcion);
		
			}catch(Exception ex){
				
				
			System.out.println(ex);
				
			}
			return mensaje;
		
		
	}
	
	
}