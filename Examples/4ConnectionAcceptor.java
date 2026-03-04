import java.net.*;
import java.io.*;

public class Ejemplo4AceptadorConexion
{
	public static void main(String[]args)
	{
		if(args.length!=2)
			System.out.println("Este programa requiere dos argumentos de linea de mandato");
		else
		{
			try
			{
				int numPuerto=Integer.parseInt(args[0]);
				String mensaje = args[1];
				ServerSocket socketConexion = new ServerSocket(numPuerto);
				System.out.println("preparando para aceptar una conexion");
				Socket socketDatos = socketConexion.accept();
				System.out.println("conexion aceptada");
				OutputStream flujoSalida = socketDatos.getOutputStream();
				PrintWriter salidaSocket = new PrintWriter(new OutputStreamWriter(flujoSalida));
				salidaSocket.println(mensaje);
				salidaSocket.flush();
				System.out.println("mensaje enviado");
				socketDatos.close();
				System.out.println("Socket de datos cerrado");
				socketConexion.close();
				System.out.println("Socket de conexion cerrado");
			
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}