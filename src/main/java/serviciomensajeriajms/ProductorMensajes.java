package serviciomensajeriajms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ProductorMensajes implements ExceptionListener {

    void processProducer() {

        try {
            //create a connectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    "tcp://localhost:61616");

            //create a connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            //create a session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //create the destination (topic o queue)
            Destination destination = session.createQueue("MYQUEUE");
            //Destination destination = session.createTopic("MYTOPIC");

            //create a messageProducer from the session to the topic o queue
            MessageProducer producer = session.createProducer(destination);

            //create a messages
            String Json = "{\n"
                    + "\"nombre\":\"Tom\",\n"
                    + "\"apellido\":\"Jackson\",\n"
                    + "\"género\":\"masculino\"\n"
                    + "}";

            TextMessage message = session.createTextMessage(Json);

            //tell the producer to send message
            // System.out.println("Mensaje enviado"+ text);
            producer.send(message);

            //clean up
            session.close();
            connection.close();
        } catch (Exception e) {

            System.out.println("Caught: " + e);
            e.printStackTrace();
        }

    }

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occurred. Shutting down client.");

    }

    public static void main(String[] args) throws Exception {
        ProductorMensajes p = new ProductorMensajes();
        System.out.println("Running Producer Process...");
        p.processProducer();

    }
}
