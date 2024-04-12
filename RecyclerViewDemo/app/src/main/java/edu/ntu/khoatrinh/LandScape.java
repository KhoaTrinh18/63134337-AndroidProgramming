package edu.ntu.khoatrinh;

public class LandScape {
    String landImage;
    String landName;

    public String getLandImage() {
        return landImage;
    }

    public void setLandImage(String landImage) {
        this.landImage = landImage;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public LandScape(String landImage, String landName) {
        this.landImage = landImage;
        this.landName = landName;
    }
}
