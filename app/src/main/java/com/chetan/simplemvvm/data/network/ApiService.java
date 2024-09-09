package com.chetan.simplemvvm.data.network;

import com.chetan.simplemvvm.data.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("user/verification")
    Call<LoginResponse> userLogin(@Query("user_id") String id, @Query("password") String password);
}
