package com.example.marvel.marvel.model;

import java.io.Serializable;
import java.util.Date;

public class ResultsCharacter implements Serializable {

    public int id;
    public String name;
    public String description;
    public Date modified;
    public String resourceURI;
    public Urls urls;
    public Thumbnail thumbnail;
    public Comics comics;
    public Stories stories;
    public Events events;
    public Series series;

}

class Urls implements Serializable{
    public String type;
    public String url;
}

class Thumbnail implements Serializable{
    public String path;
    public String extension;
}

class Comics implements Serializable{
    public int available;
    public int returned;
    public String collectionURI;
    public ItemsComicsCharacter items;

}

class ItemsComicsCharacter implements Serializable{
    public String resourceURI;
    public String name;
}

class Stories implements Serializable{
    public int available;
    public int returned;
    public String collectionURI;
    public ItemsStoriesCharacter items;
}

class ItemsStoriesCharacter implements Serializable{
    public String resourceURI;
    public String name;
    public String type;

}

class Events implements Serializable{
    public int available;
    public int returned;
    public String collectionURI;
    public ItemsEventsCharacter items;
}

class ItemsEventsCharacter implements Serializable{
    public String resourceURI;
    public String name;
}

class Series implements Serializable{
    public int available;
    public int returned;
    public String collectionURI;
    public ItemsSeriesCharacter items;
}

class ItemsSeriesCharacter implements Serializable{
    public String resourceURI;
    public String name;
}