package gov.co.handler;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
@EnableRabbit
public class RabbitHandler{
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public RabbitHandler(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        this.queue = new Queue("cola1", true);
    }

    public void send(String mensaje){
        rabbitTemplate.convertAndSend(queue.getName(),mensaje);
    }

    @RabbitListener(queues = "cola1")
    public void getOneMessage(String mensaje){
        System.out.println("Mensaje recibido: " + mensaje);
    }
    
    public int contarMensajes(String queueName) {
        return rabbitTemplate.execute(channel ->
            channel.messageCount(queueName)
        );
    }
}