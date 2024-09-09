package com.chetan.simplemvvm.data.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("User Name")
    private String UserName;

    @SerializedName("User key")
    private String key;

    @SerializedName("Client ID")
    private String clientId;

    @SerializedName("full name")
    private String fullName;

    public LoginResponse(String userName, String key, String clientId, String fullName) {
        UserName = userName;
        this.key = key;
        this.clientId = clientId;
        this.fullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
