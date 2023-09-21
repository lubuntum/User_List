package com.example.test.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    public String login;
    public double money;
    public String gender;
    public int age;
    public User(String login, double money, String gender, int age) {
        this.login = login;
        this.money = money;
        this.gender = gender;
        this.age = age;
    }
    public static List<User> generateTestUsers(int usersCount){
        List<User> testUsers = new ArrayList<>();
        String [] genders = {"male","female","helicopter"};
        Random random = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for(int i = 0; i < usersCount;i++) {
            double randomNumber = random.nextDouble() * 100;
            String roundedNumber = decimalFormat.format(randomNumber);
            double roundedValue = Double.parseDouble(roundedNumber);
            testUsers.add(new User(
                    "userLogin" + i,
                    roundedValue,
                    genders[random.nextInt(3)],
                    random.nextInt(82) + 18));
        }
        return testUsers;
    }
}
