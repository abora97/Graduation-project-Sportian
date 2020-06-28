package com.example.graduationprojectsportian.api;

import com.example.graduationprojectsportian.model.ResponseHeadLines;
import com.example.graduationprojectsportian.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    //this interface is using special retrofit annotations to encode the parameters and request method





    //http://newsapi.org/v2/top-headlines?country=eg&category=sport&apiKey=72a09f3a08aa416c8f394e4c75ef1435
    @GET(Constants.TOP_HEADLINES)
    Call<ResponseHeadLines> getNews(@Query(Constants.COUNTRY) String country, @Query(Constants.CATEGORY)String Category ,@Query(Constants.API_KEY) String apiKey);



}
