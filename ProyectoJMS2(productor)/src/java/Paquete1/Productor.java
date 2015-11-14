package Paquete1;

import javax.jms.*;

public class Productor {

    public static void main(String[] args) throws JMSException {
        int i;                                  // Para enviar varios mensajes
        MsgConexion mc;                         // Conexion propia a cola
        QueueSender emisor;                     // Emisor
        TextMessage m;                          // Mensaje a enviar
        boolean ok;                             // Para comprobar retorno de metodo
        mc = new MsgConexion();                 // Crea objeto MsgConexion
        ok = mc.inicializaCola();               // Prepara los parametros
        if (ok) {
                                                // Prepara emisor
            emisor = mc.sesionCola.createSender(mc.cola);
                                                // Prepara mensaje
            m = mc.sesionCola.createTextMessage(); // Crea mensaje
                                                // Hace varios envios
            for (i = 0; i < 5; i++) {
                m.setText("Hola Mundo distante" + i);     // Contenido mensaje
                emisor.send(m);                  // ENVIO MENSAJE
            }
        }
    }
}
