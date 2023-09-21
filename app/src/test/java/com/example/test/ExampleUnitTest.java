package com.example.test;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.test.entity.User;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void generateUsers(){
        List<User> users = User.generateTestUsers(15);
        for (int i =0; i < users.size();i++){
            User user = users.get(i);
            System.out.println(
                    String.format("Login : %s, Money: %f, Gender: %s, Age : %d",user.login, user.money, user.gender, user.age));
        }

    }
}