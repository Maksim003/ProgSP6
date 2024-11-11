package com.example.progsp6.Model;


import java.util.ArrayList;

public class Request {

    private String request;
    private ArrayList<Document> documents;

    public Request(String request, ArrayList<Document> documents) {
        this.request = request;
        this.documents = documents;
    }

    public Request() {
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
}
