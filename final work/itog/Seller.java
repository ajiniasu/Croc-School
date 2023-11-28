package itog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seller {
    private int idSeller;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("SecondName")
    private String secondName;

    // конструкторы, геттеры и сеттеры

    public Seller() {
        this.idSeller = 0;
        this.firstName = "";
        this.secondName = "";
    }

    public Seller(int id, String firstName, String secondName) {
        this.idSeller = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return idSeller;
    }
}
