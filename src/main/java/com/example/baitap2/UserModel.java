package com.example.baitap2;

public class UserModel {
    private String firstName;
    private String lastName;

    // Constructor không tham số
    public UserModel() {
    }

    // Getters và setters cho các thuộc tính
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
