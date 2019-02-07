package datanapps.multiviewrecyclelistsample.models;

public class RectHeader implements BaseModel {

    private String rectHeaderName;

    private int rectHeaderBgColorCode;

    public RectHeader() {
        // nothing to do here
    }

    public RectHeader(int bgColorCode, String headerName) {
        this.rectHeaderBgColorCode = bgColorCode;
        this.rectHeaderName = headerName;
    }

    public int getRectHeaderBgColorCode() {
        return rectHeaderBgColorCode;
    }

    public void setRectHeaderBgColorCode(int rectHeaderBgColorCode) {
        this.rectHeaderBgColorCode = rectHeaderBgColorCode;
    }

    public String getRectHeaderName() {
        return rectHeaderName==null?"":rectHeaderName;
    }

    public void setRectHeaderName(String rectHeaderName) {
        this.rectHeaderName = rectHeaderName;
    }
}