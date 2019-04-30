package com.example.felixcity.bookmanager;

public class upLoadPdf
{

    public String name;
    public String url;


    public upLoadPdf() {
    }

    public upLoadPdf(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
