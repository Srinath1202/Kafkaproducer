package com.testproducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class KafkaProducer123 {
    public static void main(String[] args) throws InterruptedException {
        KafkaProducer producer;
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("client.id", "testclient");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
        ProducerRecord producerRecord=new ProducerRecord<>("testinput3","100000000","lakhMESSAGE");
        producer.send(producerRecord, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        System.out.println("COmpleted");
                        System.out.println(metadata);
                        System.out.println(metadata.partition());
                        System.out.println(metadata.offset());
                        System.out.println(exception);
                    }
                });
                Thread.sleep(10000l);
    }
}
