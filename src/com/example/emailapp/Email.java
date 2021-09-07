package com.example.emailapp;
import java.util.*;
import java.io.*;

public class Email {
    public Scanner s = new Scanner(System.in);

    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    public Email(){

    }

    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: "+this.fname+" "+this.lname);
        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();
    }

    // Generate email
    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }

    private String setDept(){
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do{
            System.out.println("Please enter department code");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid code, please insert again.");
            }
        }
        while (!flag);

        return null;
    }

    // Generate random password
    private String generate_password(int length){
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?=<>+-*/^|";
        String values = Capital_chars+Small_chars+numbers+symbols;
        String password = "";

        for (int i = 0; i < length; i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }

        return password;
    }

    // Change Password
    public void set_password(){
        boolean flag = false;
        do {
            System.out.println("Do you want to change password? (Y/N)");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y'){
                flag = true;
                System.out.println("Please, Enter current password.");
                String current_pass = s.next();
                if (current_pass.equals(this.password)){
                    System.out.println("Enter new password:");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                }
                else {
                    System.out.println("Incorrect password.");
                }
            }
            else if (choice == 'N' || choice == 'y'){
                flag = true;
                System.out.println("Password change operation cancelled.");
            }
            else {
                System.out.println("Please enter valid option");
            }
        }
        while (!flag);
    }

    // Set Mailbox capacity
    public void set_mailCapacity(){
        System.out.println("Current mailbox capacity ="+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity changed.");
    }

    // Set alternate email
    public void alternate_email(){
        System.out.println("Enter alternate email:");
        this.alter_email = s.next();
        System.out.println("Alternate email is updated.");
    }

    //Display user information
    public void getInfo(){
        System.out.println("Name: "+this.fname+" "+this.lname);
        System.out.println("Department: "+this.dept);
        System.out.println("Email: "+this.email);
        System.out.println("Alternate Email: "+this.alter_email);
        System.out.println("Mailbox Capacity: "+this.mailCapacity);
    }

    // Exit
    public void exitSystem(){
        System.out.println("Thank you for using this system.");
    }

    // Store user data in a file
    public void storefile(){
        try {
            FileWriter in = new FileWriter("info.txt");
            in.write("First Name: "+this.fname);
            in.append("\nLast Name: "+this.lname);
            in.append("\nEmail: "+this.email);
            in.close();
            System.out.println("Data saved.");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    // Read from file
    public void read_file(){
        try {
            FileReader f1 = new FileReader("info.txt");
            int i;
            while ((i=f1.read()) != -1){
                System.out.print((char) i);
            }
            f1.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
