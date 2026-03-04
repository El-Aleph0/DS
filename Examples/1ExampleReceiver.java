import java.net.*;
import java.io.*;
public class ejemplo1Receptor{
	public static void main(String [] args){
		if(args.length != 1){
			System.out.println("necesita 1 argumentos de linea de mandato");
		}else{
			
				int puerto= Integer.parseInt(args[0]);
				final int MAX_LON=10;
			try{
				
				
				DatagramSocket miSocket= new DatagramSocket(puerto);
				byte [] almacen = new byte[MAX_LON];
				
				DatagramPacket datagrama= new DatagramPacket(almacen,MAX_LON);
				
				miSocket.receive(datagrama);
				
				String mensaje=new String (almacen);
				
				System.out.println(mensaje);
		
				miSocket.close();
				
			}catch(Exception ex){
				
				
			System.out.println(ex);
				
			}
		}
		
	}
	
	
}