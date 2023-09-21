package com.example.test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test.R;
import com.example.test.entity.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private LayoutInflater inflater;
    private List<User> users;
    private int resource;
    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> users) {
        super(context, resource, users);
        this.resource = resource;
        this.users = users;
        //Класс для генерации UI
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View viewGroup, @NonNull ViewGroup parent) {
        View userView = inflater.inflate(resource, parent, false);
        User user = users.get(position);
        TextView userLogin =
                userView.findViewById(R.id.user_login);
        TextView userMoney =
                userView.findViewById(R.id.user_money);
        TextView userGender =
                userView.findViewById(R.id.user_gender);
        TextView userAge =
                userView.findViewById(R.id.user_age);
        userLogin.setText(user.login);
        userMoney.setText(String.format("Money: %f₽", user.money));
        userGender.setText(String.format("Gender: %s", user.gender));
        userAge.setText(String.format("Age: %d years", user.age));
    return userView;
    }

    public List<User> getUsers() {
        return users;
    }
}
