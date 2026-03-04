package servidor;

import java.net.*;
import java.io.*;

public class MiSocketDatagramaCliente extends  DatagramSocket
{
	static final int MAX_LON=100;
	MiSocketDatagramaCliente()throws SocketException
	{
		super();
	}

	MiSocketDatagramaCliente(int numPuerto) throws SocketException
	{
		super(numPuerto);
	}

	public void enviaMensaje(String maquinaReceptora, int puertoReceptor, String mensaje) throws IOException
	{
                InetAddress maquinaReceptora1=InetAddress.getByName(maquinaReceptora);
		byte[] almacenEnvio = mensaje.getBytes();
		DatagramPacket datagrama = new DatagramPacket(almacenEnvio,almacenEnvio.length,maquinaReceptora1,puertoReceptor);
		this.send(datagrama);
	}	

	public String recibeMensaje () throws IOException
	{
		byte [] almacenRecepcion = new byte[MAX_LON];
		DatagramPacket datagram = new  DatagramPacket(almacenRecepcion, MAX_LON);
		this.receive(datagram);
		String mensaje = new String (almacenRecepcion);
		return mensaje;
	}
}