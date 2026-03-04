package servidor;

import java.io.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.ArrayList;

public class PruebaServidor extends JFrame{
    public JTextArea areaTexto;
    
    public static PruebaServidor main; 
    
    public PruebaServidor(){
        super("Servidor");

        areaTexto = new JTextArea(); //Crear displayArea
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        areaTexto.setBackground(Color.white);
        areaTexto.setForeground(Color.BLACK);
 
        setSize(450, 400); 
        setVisible(true); 
    }
    
    public void mostrarMensaje(String mensaje) {
        areaTexto.append(mensaje + "\n");
    } 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<InetAddress> clients = new ArrayList<InetAddress>();
        String conversacion="";
        PruebaServidor main = new PruebaServidor(); 
        main.setLocationRelativeTo(null); 
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            int puertoServidor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese puerto para servidor"));
            main.mostrarMensaje("El puerto del servidor es: "+ puertoServidor);
            System.out.println(puertoServidor);
		try{
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			MiSocketDatagramaServidor miSocket = new MiSocketDatagramaServidor(puertoServidor);
                        main.mostrarMensaje("Servidor Listo");
			while (true) {
				MensajeDatagrama peticion = miSocket.recibeMensajeYEmisor();
				System.out.println("Peticion Realizada");				
				String mensaje = peticion.obtieneMensaje();
				conversacion+= "\n"+mensaje.trim();
				main.mostrarMensaje("---------------------------");
                                main.mostrarMensaje(conversacion);
				if(clients.contains(peticion.obtieneDireccion())==false){
					clients.add(peticion.obtieneDireccion());
				}
				for(int i=0;i<clients.size();i++){
					miSocket.enviaMensaje(clients.get(i),peticion.obtienePuerto(),conversacion);
				}
			}
		}catch (Exception ex) {
			ex.printStackTrace();			
		}    
    }
}
    