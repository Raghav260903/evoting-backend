package com.evoting.backend.controller;

import com.evoting.backend.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin(origins = "*")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public String sendOtp(@RequestBody Map<String, String> request) {

        String email = request.get("email");

        System.out.println("=== OTP CONTROLLER HIT ===");
        System.out.println("Request received for email: " + email);

        if (email == null || email.isEmpty()) {
            return "Email is required";
        }

        otpService.sendOtp(email);

        return "OTP sent to email";
    }

    @PostMapping("/verify")
    public boolean verifyOtp(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String otp = request.get("otp");

        System.out.println("=== OTP VERIFY HIT ===");
        System.out.println("Email: " + email);
        System.out.println("OTP entered: " + otp);

        return otpService.verifyOtp(email, otp);
    }
}