package com.edu.myfirtconsumptionapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAPIService {
    @GET("https://jsonplaceholder.typicode.com/todos/1")
    public Call<Object> obtener();
}
