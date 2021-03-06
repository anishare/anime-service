package com.anishare.animeservice.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class AnimeDTO {

    private UUID id;
    @NotBlank(message = "Name must not be blank")
    private String name;
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
        return "AnimeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", malID='" + malID + '\'' +
                '}';
    }
}
