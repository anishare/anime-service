package com.anishare.animeservice.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String malID;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMalID() {
        return malID;
    }

    public void setMalID(String malID) {
        this.malID = malID;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", malID='" + malID + '\'' +
                '}';
    }
}
