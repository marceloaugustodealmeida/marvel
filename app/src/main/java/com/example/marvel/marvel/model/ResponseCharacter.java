package com.example.marvel.marvel.model;

import java.io.Serializable;

public class ResponseCharacter implements Serializable {

    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public DataCharacter data;
    public String etag;
}
