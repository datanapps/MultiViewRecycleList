package datanapps.multiviewrecyclelistsample.models;

public class RectHeader implements BaseModel {

    private String rectHeaderName;
    private String rectHeaderImageUrl;


    public RectHeader() {
        // nothing to do here
    }

    public RectHeader(String headerImage, String headerName ) {
        this.rectHeaderImageUrl = headerImage;
        this.rectHeaderName = headerName;
    }

    public String getRectHeaderName() {
        return rectHeaderName==null?"":rectHeaderName;
    }

    public void setRectHeaderName(String rectHeaderName) {
        this.rectHeaderName = rectHeaderName;
    }

    public String getRectHeaderImageUrl() {
        return rectHeaderImageUrl;
    }

    public void setRectHeaderImageUrl(String rectHeaderImageUrl) {
        this.rectHeaderImageUrl = rectHeaderImageUrl;
    }
}