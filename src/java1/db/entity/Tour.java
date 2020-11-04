package java1.db.entity;

public class Tour {
    private String country;
    private String city;
    private String prise;
    private String food;
    private String addInformation;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAddInformation() {
        return addInformation;
    }

    public void setAddInformation(String addInformation) {
        this.addInformation = addInformation;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", prise='" + prise + '\'' +
                ", food='" + food + '\'' +
                ", addInformation='" + addInformation + '\'' +
                '}';
    }
}
