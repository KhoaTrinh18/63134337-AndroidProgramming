package khoatrinh.countrylist;

public class Country {
    private String countryName;
    private int flagId;
    private int population;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getFlagId() {
        return flagId;
    }

    public void setFlagId(int flagID) {
        this.flagId = flagID;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country(String countryName, int flagId, int population) {
        this.countryName = countryName;
        this.flagId = flagId;
        this.population = population;
    }
}
