package ro.tuc.ds2020;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ro.tuc.ds2020.entities.SensorData;

public class TemaTrd extends Thread {
    private final static String QUEUE_NAME = "hello";
    public void run() {
        Gson gson= new Gson();
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUri("amqps://wbkdujjt:kX0ig9q645oKElIq2NYQEpX7KzyDdYZm@crow.rmq.cloudamqp.com/wbkdujjt");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            JSONParser parser = new JSONParser();
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                JSONObject obj;
                try {

                    obj = (JSONObject) parser.parse(message);
                    SensorData ss = gson.fromJson(obj.toString(), SensorData.class);

                    long tstart = Long.parseLong(ss.getStart());
                    long tend = Long.parseLong(ss.getEnd());
                    long diff = tend - tstart;
                    if (ss.getActivity().equals("Sleeping")) {
                        diff = diff / (1000 * 60 * 60);
                        if (diff >= 7)
                            System.out.println("R1 sleep activity longer than 7 hours");
                    }

                    if (ss.getActivity().equals("Leaving")) {
                        diff = diff / (1000 * 60 * 60);
                        if (diff >= 5)
                            System.out.println("R2 leaving activity longer than 5 hours");
                    }

                    if (ss.getActivity().equals("Toileting")) {
                        long diff2 = diff / (1000 * 60);
                        if (diff2 >= 30)
                            System.out.println("R3 time spend in bathroom longer than 30 minutes");
                    }
                    if (ss.getActivity().equals("Showering")) {
                        long diff2 = diff / (1000 * 60);
                        if (diff2 >= 30)
                            System.out.println("R3 time spend in bathroom longer than 30 minutes");
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        }
        catch (Exception e){System.out.println("Exceptie");}
    }
}
