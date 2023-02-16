package it.aesys.kafkaTest.messages;

import it.aesys.kafkaTest.pojo.Greetings;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.logging.Logger;

public class MessageListener {

    @KafkaListener(topics = "topicName", groupId = "foo")
    public void listenGroupFoo(String message) {
        Logger.getLogger("Received message in group foo : " + message);
    }

    @KafkaListener(topics = "topicName")
    public void listenWithHeader(
            @Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        Logger.getLogger("Received message: " + message + " from partition: " + partition);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "topicName", partitionOffsets = {
            @PartitionOffset(partition = "0", initialOffset = "0"),
            @PartitionOffset(partition = "3", initialOffset = "0")
    }), containerFactory = "partitionsKafkaListenerContainerFactory")
    public void listenPartition(
        @Payload String message,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        Logger.getLogger("Received message: " + message + " from partition: " + partition);
    }

    @KafkaListener( topics = "topicName", containerFactory = "filterKafkaListenerContainerFactory")
    public void listenWithFilter(String message) {
        Logger.getLogger("Received message in filtered listener: " + message);
    }

    @KafkaListener( topics = "topicName", containerFactory = "stringGreetingsConcurrentKafkaListenerContainerFactory")
    public void greetingListener(Greetings greetings) {
        Logger.getLogger("Received message: " + greetings.getMsg());
    }
}
