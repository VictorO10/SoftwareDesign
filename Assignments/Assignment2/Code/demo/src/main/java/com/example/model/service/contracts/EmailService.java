package com.example.model.service.contracts;

public interface EmailService {

    public void sendSimpleMessage(String to, String subject, String text);
}
