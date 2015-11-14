package Paquete1;

import javax.jms.*;

public class Consumidor {

    public static void main(String[] args) {
        int i;                                                                     // Para recibir varios mensajes
        MsgConexion mc;                                                     // Conexion propia a cola
        QueueReceiver receptor;                                                    // Receptor
        TextMessage m;                                                             // Mensaje recibido
        boolean ok;                                                          // Comprobacion retorno
        mc = new MsgConexion();                                             // Crea su objeto MsgConexion
         ok = mc.inicializaCola();                                           // Inicializa parametros
        
        try {
            if (ok) {
                // Prepara receptor sobre cola
                receptor = mc.sesionCola.createReceiver(mc.cola);
                // Recibe los mensajes:
                for (i = 0; i < 5; i++) {
                    m = (TextMessage) receptor.receive(0);
                    System.out.println("Mensaje recibido:" + m.getText());
                }
            }
        } catch (JMSException ex) {
            mc.cerrarConexion();
        }
    }
}
