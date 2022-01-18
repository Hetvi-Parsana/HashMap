/*
HETVI TUSHARBHAI PARSANA
CSCI _ 2110
B00877530
*/

package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String filename = "src/com/company/username_password.txt";
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line, data[], name, username, password;
        HashMap<String, String> credentials = new HashMap<>();
        HashMap<String, String> details = new HashMap<>();

        while ((line = br.readLine()) != null) {
            data = line.split("\t");
            name = data[0];
            username = data[1];
            password = data[2];

            credentials.put(username, password);
            details.put(username, name);
        }

        for (int i = 0; i < 3; i++) {
            System.out.print("Login: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();

            if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                System.out.println("\nLogin successful");
                System.out.println("Welcome " + details.get(username));
                break;
            } else {
                switch (i) {
                case 0:
                    System.out.println("\nEither the username or password is incorrect. You have 2 more attempts.");
                    break;
                case 1:
                    System.out.println("\nEither the username or password is incorrect. You have 1 more attempt.");
                    break;
                case 2:
                    System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
                    break;
                }
            }

        }

        sc.close();
        br.close();
    }
}
