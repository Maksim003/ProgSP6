package com.example.progsp6;

import com.example.progsp6.Model.Answer;
import com.example.progsp6.Model.Document;
import com.example.progsp6.Model.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Client {


    public ArrayList<Document> getData(Request request) {
        ArrayList<Document> documents = new ArrayList<>();
        String outJson = "", inJson = "";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try (Socket clientSocket = new Socket("localhost", 3345); DataInputStream in =
                new DataInputStream(clientSocket.getInputStream()); DataOutputStream out =
                new DataOutputStream(clientSocket.getOutputStream())){
            while (!clientSocket.isClosed()) {
                outJson = objectMapper.writeValueAsString(request);
                out.writeUTF(outJson);
                out.flush();
                inJson = in.readUTF();
                if (!inJson.equals("")) {
                    documents = getDoc(objectMapper.readValue(inJson, Answer.class));
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documents;
    }

    public ArrayList<Document> getDoc(Answer answer) {
        ArrayList<Document> documents = new ArrayList<>();
        switch (answer.getAnswer()) {
            case "get", "add", "edit", "delete" -> documents = answer.getDocuments();
        }
        return documents;
    }


}
