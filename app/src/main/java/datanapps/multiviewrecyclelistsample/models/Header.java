package datanapps.multiviewrecyclelistsample.models;

public class Header implements BaseModel {

    private String  headerName;

    public Header() {
        // nothing to do here
    }

    public Header(String headerName) {
        this.headerName = headerName;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}