package com.example.progsp6.Model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Document {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty numberOfDoc = new SimpleIntegerProperty();
    private StringProperty category = new SimpleStringProperty();
    private StringProperty type = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

    public Document() {

    }

    public Document(int id, String name, int numberOfDoc, String category, String type, String status, LocalDate date) {
        this.id.set(id);
        this.name.set(name);
        this.numberOfDoc.set(numberOfDoc);
        this.category.set(category);
        this.type.set(type);
        this.status.set(status);
        this.date.set(date);

    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getNumberOfDoc() {
        return numberOfDoc.get();
    }

    public IntegerProperty numberOfDocProperty() {
        return numberOfDoc;
    }

    public void setNumberOfDoc(int numberOfDoc) {
        this.numberOfDoc.set(numberOfDoc);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }
}
