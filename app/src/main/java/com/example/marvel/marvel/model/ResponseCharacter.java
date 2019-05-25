package com.example.marvel.marvel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

//JsonIgnoreProperties = Ignora todas as variaveis que não estão listadas aqui
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCharacter implements Serializable {

    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public String etag;
    public DataCharacter data;

}
