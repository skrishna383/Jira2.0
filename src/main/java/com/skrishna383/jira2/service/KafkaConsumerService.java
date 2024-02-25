package com.skrishna383.jira2.service;

import com.skrishna383.jira2.dao.JiraUserDao;
import com.skrishna383.jira2.model.JiraUser;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    JiraUserDao jiraUserDao;
    @KafkaListener(topics = "JiraUsers", groupId = "my-group")
    public void consumeMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        JiraUser js= new JiraUser();
        js.setName(record.value());
        jiraUserDao.save(js);
        // Add your logic to process the message here
    }
}
