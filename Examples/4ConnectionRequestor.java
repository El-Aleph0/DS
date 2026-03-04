import java.net.*;
import java.io.*;

public class Ejemplo4SolicitanteConexion
{
	public static void main(String[]args)
	{
		if(args.length!=2)
			System.out.println("Este programa requiere dos argumentos de linea de mandato");
		else
		{
			try
			{
				InetAddress maquinaAceptadora = InetAddress.getByName(args[0]);
				int puertoAceptador = Integer.parseInt(args[1]);
				Socket miSocket = new Socket(maquinaAceptadora, puertoAceptador);
				System.out.println("Solicitud de conexion concedida");
				InputStream flujoEntrada = miSocket.getInputStream();
				BufferedReader socketInput = new BufferedReader(new InputStreamReader(flujoEntrada));
				System.out.println("esperando leer");
				String mensaje = socketInput.readLine();
				System.out.println("\t"+mensaje);
				miSocket.close();
				System.out.println("socket de datos cerrado");
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}