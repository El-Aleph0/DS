import java.net.*;
import java.io.*;

public class Ejemplo5AceptadorConexion
{
	public static void main(String[]args)
	{
		if(args.length != 2)
			System.out.println("Este programa requiere 2 lineas de argumento puños");
		else
		{
			try
			{
				int numPuerto = Integer.parseInt(args[0]);
				String mensaje = args [1];
				ServerSocket socketConexion = new ServerSocket(numPuerto);
				System.out.println("preparado para aceptadar una conexion");
				Misocketstream socketDatos = new Misocketstream(socketConexion.accept());
				System.out.println("conexion aceptada");
				socketDatos.enviaMensaje(mensaje);
				System.out.println("mensaje enviado");
				socketDatos.close();
				System.out.prinln("socket de datos cerrado");
				socketConexion.close();
				System.out.prinln("socket conexion cerrado");
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}