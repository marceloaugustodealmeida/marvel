package com.example.marvel.marvel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

//JsonIgnoreProperties = Ignora todas as variaveis que não estão listadas aqui
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCharacter implements Serializable {

    public int offset;
    public int limit;
    public int total;
    public int count;
    public List<ResultsCharacter> results;

}
