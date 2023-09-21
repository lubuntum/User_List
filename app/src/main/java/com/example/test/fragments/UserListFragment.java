package com.example.test.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.adapters.UserAdapter;
import com.example.test.databinding.FragmentUserListBinding;
import com.example.test.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserListFragment extends Fragment {
    public UserAdapter userAdapter;
    public static List<User> userList = new ArrayList<>();
    private FragmentUserListBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userListInit();
        addUserBtnInit();
    }
    private void userListInit(){
        userAdapter = new UserAdapter(
                getContext(),
                R.layout.user_item,
                userList);
        binding.userList.setAdapter(userAdapter);
        binding.userList.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getContext(), String.valueOf(i), Toast.LENGTH_LONG).show();
        });

    }
    /*
    * Метод для инициализации добавления пользователя
    * */
    private void addUserBtnInit(){
        binding.addUserBtn.setOnClickListener((view)->{
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new AddUserFragment(),"add_user")
                    .addToBackStack(null)
                    .commit();
        });
    }
}