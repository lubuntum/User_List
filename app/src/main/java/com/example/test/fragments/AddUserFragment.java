package com.example.test.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.test.R;
import com.example.test.databinding.FragmentAddUserBinding;
import com.example.test.entity.User;

public class AddUserFragment extends Fragment {
    FragmentAddUserBinding binding;
    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initSwitchGender();
        initCommitBtn();
    }

    private void initSwitchGender(){
        binding.userGender.setOnCheckedChangeListener((compoundButton, b) -> {
            if(!b)
                binding.userGender.setText("Male");
            else binding.userGender.setText("Female");
        });
    }
    private void initCommitBtn(){
        binding.commitBtn.setOnClickListener((v)->{
            String login = binding.userLogin.getText().toString();
            int age = Integer.valueOf(binding.userAge.getText().toString());
            String gender = binding.userGender.getText().toString();
            if(age == 0 || login.equals("") ) return;
            User user = new User(login, 0, gender, age);

            UserListFragment.userList.add(user);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}