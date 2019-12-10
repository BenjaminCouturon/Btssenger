package com.lasalle.btssenger;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationService {
    @POST("login")
    Single<Auth> login(@Body UserPassword  userPassword);
}
