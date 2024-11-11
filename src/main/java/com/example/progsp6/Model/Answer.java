package com.example.progsp6.Model;

import com.example.progsp6.Model.Document;

import java.util.ArrayList;

public class Answer {

    private String answer;
    private ArrayList<Document> documents;

    public Answer() {
    }

    public Answer(String answer, ArrayList<Document> documents) {
        this.answer = answer;
        this.documents = documents;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
}
