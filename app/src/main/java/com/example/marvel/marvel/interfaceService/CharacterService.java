package com.example.marvel.marvel.interfaceService;

import com.example.marvel.marvel.model.RequestCharacter;
import com.example.marvel.marvel.model.ResponseCharacter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CharacterService {

    public static final String BASE_URL = "https://gateway.marvel.com:443/v1/public/";

    @GET("characters?apikey=001ac6c73378bbfff488a36141458af2&ts=thesoer&hash=72e5ed53d1398abb831c3ceec263f18b")
    Call<ResponseCharacter> listCharacter();

}
