package com.example.marvel.marvel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//JsonIgnoreProperties = Ignora todas as variaveis que não estão listadas aqui
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsCharacter implements Serializable {

    public int id;
    public String name;
    public String description;
    public Date modified;
    public Thumbnail thumbnail;
    public String resourceURI;
    public Comics comics;
    public Series series;
    public Stories stories;
    public Events events;
    public List<Urls> urls;

}

class Urls implements Serializable {
    public String type;
    public String url;
}

class Comics implements Serializable {
    public int available;
    public String collectionURI;
    public List<ItemsComicsCharacter> items;
    public int returned;
}

class ItemsComicsCharacter implements Serializable {
    public String resourceURI;
    public String name;
}

class Stories implements Serializable {
    public int available;
    public String collectionURI;
    public List<ItemsStoriesCharacter> items;
    public int returned;
}

class ItemsStoriesCharacter implements Serializable {
    public String resourceURI;
    public String name;
    public String type;

}

class Events implements Serializable {
    public int available;
    public String collectionURI;
    public List<ItemsEventsCharacter> items;
    public int returned;
}

class ItemsEventsCharacter implements Serializable {
    public String resourceURI;
    public String name;
}

class Series implements Serializable {
    public int available;
    public String collectionURI;
    public List<ItemsSeriesCharacter> items;
    public int returned;
}

class ItemsSeriesCharacter implements Serializable {
    public String resourceURI;
    public String name;
}