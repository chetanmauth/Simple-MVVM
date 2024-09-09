package com.chetan.simplemvvm.domain.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chetan.simplemvvm.data.model.LoginResponse;
import com.chetan.simplemvvm.data.model.UserLogin;
import com.chetan.simplemvvm.data.network.ApiService;
import com.chetan.simplemvvm.data.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private final ApiService apiService;
    public MutableLiveData<String> userId = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> loginResult = new MutableLiveData<>();

    public LoginViewModel() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }

    public void doLogin() {
        UserLogin userLogin = new UserLogin(userId.getValue(), password.getValue());
        apiService.userLogin(userLogin.getUserId(), userLogin.getPassword()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d("doLogin", "" + response.body());
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getFullName() != null) {
                        loginResult.setValue(response.body().getFullName());
                    } else {
                        loginResult.setValue("Login Error: User not found");
                    }

                } else {
                    loginResult.setValue("Login Failed");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                loginResult.setValue("Network Error");
            }
        });
    }
}
