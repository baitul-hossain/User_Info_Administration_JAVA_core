package com.example.emailapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String f_name = s.next();
        System.out.println("Enter your last name:");
        String l_name = s.next();

        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        do {
            System.out.println("\n*****\nEnter your choice:\n1. Show User Information\n2. Change Password" +
                    "\n3. Change Mailbox capacity\n4. Set alternate email\n5. Save User Information to file" +
                    "\n6. Read from file\n7. Exit");
            choice = s.nextInt();

            switch (choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCapacity();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    em1.exitSystem();
                    break;
                default:
                    System.out.println("Invalid code.");
            }

        }
        while (choice != 7);
    }
}
