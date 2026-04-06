package com.evoting.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "voters")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voter_id", unique = true)
    private String voterId;

    @Column(nullable = false)
    private String name;

    private Integer age;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(name = "aadhar_number", unique = true)
    private String aadharNumber;

    private String address;

    private String location;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "has_voted")
    private Boolean hasVoted = false;

    @Column(name = "otp_verified")
    private Boolean otpVerified = false;

    @Column(name = "biometric_verified")
    private Boolean biometricVerified = false;

    public Voter() {
    }

    public Voter(String voterId, String name, Integer age, String phone, String email, String aadharNumber,
                 String address, String location, String maritalStatus,
                 Boolean hasVoted, Boolean otpVerified, Boolean biometricVerified) {
        this.voterId = voterId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email=email;
        this.aadharNumber = aadharNumber;
        this.address = address;
        this.location = location;
        this.maritalStatus = maritalStatus;
        this.hasVoted = hasVoted;
        this.otpVerified = otpVerified;
        this.biometricVerified = biometricVerified;
    }

    public Long getId() {
        return id;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }



    public String getAadharNumber() {
        return aadharNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public Boolean getOtpVerified() {
        return otpVerified;
    }

    public Boolean getBiometricVerified() {
        return biometricVerified;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public void setOtpVerified(Boolean otpVerified) {
        this.otpVerified = otpVerified;
    }

    public void setBiometricVerified(Boolean biometricVerified) {
        this.biometricVerified = biometricVerified;
    }
}