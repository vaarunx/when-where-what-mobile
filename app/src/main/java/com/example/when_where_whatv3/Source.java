package com.example.when_where_whatv3;

import java.io.Serializable;

public class Source implements Serializable {
    String id = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
