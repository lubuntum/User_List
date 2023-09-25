package com.example.test.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.test.databinding.DialogUserInfoBinding;
import com.example.test.entity.User;

import java.io.Serializable;
import java.util.ArrayList;

public class UserInfoDialog extends DialogFragment {
    private User user;
    public static String USER_KEY;
    public static String USER_SUBS;
    DialogUserInfoBinding binding;
    /*Метод для создания окна и передачи User*/
    public static UserInfoDialog  getInstance(User user){
        Bundle args = new Bundle();
        args.putSerializable(USER_KEY, user);
        //args.putSerializable(USER_SUBS, (Serializable) user.userSubscriptions);
        UserInfoDialog userInfoDialog = new UserInfoDialog();
        userInfoDialog.setArguments(args);
        return userInfoDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*Получаем переданного пользователя через входные аргументы*/
        if(getArguments()!=null && getArguments().containsKey(USER_KEY)){
            this.user = (User)getArguments().getSerializable(USER_KEY);
            //this.user.userSubscriptions = (ArrayList<String>)getArguments().getSerializable(USER_SUBS);
        }
        /*Инициализация binding*/
        binding = DialogUserInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ArrayAdapter<String> userSubsAdapter =
                new ArrayAdapter<>(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        user.userSubscriptions);
        binding.userSubs.setAdapter(userSubsAdapter);
        binding.userLogin.setText(user.login);
    }
}
