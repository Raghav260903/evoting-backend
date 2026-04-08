package com.evoting.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private JavaMailSender mailSender;

    private final Map<String, String> otpStorage = new HashMap<>();

    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public void sendOtp(String email) {
        String otp = generateOtp();
        otpStorage.put(email, otp);

        try {
            System.out.println("=== OTP SERVICE START ===");
            System.out.println("Sending OTP to: " + email);
            System.out.println("Generated OTP: " + otp);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("raghavsoundararajan@gmail.com");
            message.setTo(email);
            message.setSubject("SecureVote OTP Verification");
            message.setText("Your OTP for SecureVote login is: " + otp);

            mailSender.send(message);

            System.out.println("Mail sent successfully");
            System.out.println("=== OTP SERVICE END ===");
        } catch (Exception e) {
            System.out.println("Mail send failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean verifyOtp(String email, String otp) {
        String storedOtp = otpStorage.get(email);
        return storedOtp != null && storedOtp.equals(otp);
    }
}