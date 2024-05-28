package com.example.collab;

public class Member {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String university;
    private String year;

    // Required default constructor for Firebase serialization
    public Member() {
    }

    public Member(String name, String surname, String email, String phone, String university, String year) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.university = university;
        this.year = year;
    }

    // Getters and setters
    // Add getters and setters for all fields
    // For brevity, I'll include just a few examples here

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Similarly define getters and setters for other fields
}
