package br.ufrn.programacaoreativa.user.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.ufrn.programacaoreativa.user.config.RabbitMQConfig;

@Component
public class NewContentPublishedListener {
	
	@KafkaListener(
			topics = "newcontentpublish",
			groupId = "groupId")
	public void listener(String data) {
		System.out.println("Listener received: "+ data);
	}
	
	@RabbitListener(queues = 
			RabbitMQConfig.QUEUE)
	public void readNotifications(String data) {
		System.out.println("Nova notificação: " + data);
	}

}
