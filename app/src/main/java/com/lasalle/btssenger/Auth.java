package com.lasalle.btssenger;

public class Auth {
    private String status;
    private Data data;

    public Auth() {

    }

    public String getStatus() {
        return status;
    }

    public String getAuthToken() {
        return data.authToken;
    }

    private class Data {
        private String userId;
        private String authToken;

        public String getUserId() {
            return userId;
        }
    }

}
