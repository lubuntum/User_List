package com.example.test.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class User implements Serializable {
    public static String [] subscriptionsNames = {
            "NETFLIX", "Yandex Music", "Spotify",
            "Google Cloud", "VK Music", "Microsoft 360",
            "AMAZON PRIME"
    };
    public String login;
    public double money;
    public String gender;
    public int age;
    public List<String> userSubscriptions = new ArrayList<>();
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
            User tempUser = new User(
                    "userLogin" + i,
                    roundedValue,
                    genders[random.nextInt(3)],
                    random.nextInt(82) + 18);
            User.generateUserSubscriptions(
                    tempUser,
                    random.nextInt(User.subscriptionsNames.length));
            testUsers.add(tempUser);

        }
        return testUsers;
    }
    public static void generateUserSubscriptions(User user, int subsCount){
        List<String> subscriptions = new ArrayList<>(User.subscriptionsNames.length);
        Collections.addAll(subscriptions, User.subscriptionsNames);
        Random random = new Random();
        for(int i = 0; i<subsCount;i++){
            int randomDigit = random.nextInt(subscriptions.size());
            user.userSubscriptions.add(subscriptions.get(randomDigit));
            subscriptions.remove(randomDigit);
        }
    }
}
