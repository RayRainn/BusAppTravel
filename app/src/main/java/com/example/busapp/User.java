package com.example.busapp;

public class User {//A User class that can be used to create User objects.
    private String full_name, studentID, email, password;


    public User(){//Blank constructor and one that takes variables, so User objects can be created and initiated, but also created
        //separately.

    }

    public User(String full_name, String studentID, String email, String password){
        this.full_name = full_name;
        this.studentID = studentID;
        this.email = email;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

/*<!--Team 17 - User Class code
@Author: Julian Laffin -->*/
