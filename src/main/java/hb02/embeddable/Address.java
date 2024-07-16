package hb02.embeddable;

import javax.persistence.Embeddable;

@Embeddable//Gomulebilir, bu class a karsilik tablo olusturma
//baska bir toblaya bu classtaki fieldlar sutun olarak gomulebilir.
public class Address {

    private String street;
    private String city;
    private String country;

    // Getter-Setter

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
