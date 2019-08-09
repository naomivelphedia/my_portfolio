package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "health")
@Entity
public class Health {
    private double height;
    private double weight;
    private double bmi;
    private String bodyType;

    public double getHeight() {
        return height;
    }

    public void setHeight() {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight() {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi() {
        this.bmi = bmi;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType() {
        this.bodyType = bodyType;
    }
}
