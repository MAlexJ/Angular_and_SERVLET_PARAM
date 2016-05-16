package com.malex.entities;

import java.io.Serializable;

/**
 * Created by Серёжа on 15.05.2016.
 */
public class BaseEntity implements Serializable{
    public BaseEntity() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;


}
