package it.aesys.kafkaTest.messages;

import it.aesys.kafkaTest.pojo.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.logging.Logger;

public class MessageSender {

    @Value("message.topic.name=baeldung")
    private String topicName;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    KafkaTemplate<String, Greetings> greetTemplate;

    public void sendMessage(String msg) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("wiki", msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                Logger.getLogger("Unable to send message = [" + msg + "] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                Logger.getLogger("Sent message=[" + msg +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
        });
    }

    public void sendGreetings() {
        greetTemplate.send(topicName, new Greetings("Hello", "World"));
    }
}
