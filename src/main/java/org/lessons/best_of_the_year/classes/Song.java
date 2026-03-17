package org.lessons.best_of_the_year.classes;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;

    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%d %s ", id, title);
    }

}
