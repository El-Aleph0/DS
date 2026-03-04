import java.net.*;
import java.io.*;
public class MiSocketStream extends Socket 
{
	private Socket socket;
	private BufferReader entrada;
	private PrintWriter salida;
	
	Misocketstream(String maquinaAceptadora, int puertoAceptador) throws SocketException, IOException
	{
	socket = new Socket(maquinaAceptadora, puertoAceptador);
	establecerFlujos();
	}
	Misocketstream(Socket socket) throws IOException 
	{
		this.socket = socket;
		establecerFlujos();
	}
	private void establecerFlujos() throws IOException
	{
		InputStream flujoEntrada = socket.getInputStream();
		entrada = new BufferReader(new OutputStreamWriter(flujoEntrada));
		OutputStream flujoSalida = socket.getOutStream();
		salida = new PrintWriter(new OutputStreamWriter(flujoSalida));
	}
	public void enviaMensaje(String mensaje) throws IOException
	{
		salida.println(mensaje);
		salida.flush();
	}
	public void recibeMensaje(String mensaje) throws IOException 
	{
		String mensaje = entrada.readLine();
		return mensaje;
	}
	public void close() throws IOException
	{
		socket.close();
	}
}