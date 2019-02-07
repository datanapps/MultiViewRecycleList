package datanapps.multiviewrecyclelistsample.models;

public class User implements BaseModel {
    private int image;
    private String  name;

    public User() {
        // nothing to do here
    }

    public User(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}