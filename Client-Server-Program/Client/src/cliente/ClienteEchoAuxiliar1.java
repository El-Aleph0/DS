package cliente;

import java.net.*;
import java.io.*;

public class ClienteEchoAuxiliar1
{
	private MiSocketDatagramaCliente miSocket;
	private InetAddress maquinaServidora;
	private int puertoServidor;

	ClienteEchoAuxiliar1(String nombreMaquina, String numPuerto)
	throws SocketException, UnknownHostException{
		this.maquinaServidora = InetAddress.getByName(nombreMaquina);
		this.puertoServidor = Integer.parseInt(numPuerto);
		this.miSocket = new MiSocketDatagramaCliente();
	}

	public String obtenerEco (String mensaje) throws SocketException, IOException{
		String eco="";
		//miSocket.enviaMensaje(maquinaServidora,puertoServidor,mensaje);
		eco = miSocket.recibeMensaje();
		return eco;		
	}
        public String getMsm() throws IOException{
            return miSocket.recibeMensaje();
        }
        
	public void hecho () throws SocketException{
		miSocket.close();
	}
}