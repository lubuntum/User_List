package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.test.adapters.UserAdapter;
import com.example.test.entity.User;
import com.example.test.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {
    public UserAdapter userAdapter;
    public ListView usersListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        usersListView = findViewById(R.id.user_list);
        userAdapter =
                new UserAdapter(
                        getApplicationContext(),
                        R.layout.user_item,
                        User.generateTestUsers(15));
        usersListView.setAdapter(userAdapter);
         */
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment, new UserListFragment(),"user_list_fragment")
                .commit();
    }

}