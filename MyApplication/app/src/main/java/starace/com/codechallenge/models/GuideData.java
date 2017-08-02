package starace.com.codechallenge.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mstarace on 8/1/17.
 */

public class GuideData {

    private String startDate;

    private String endDate;

    private String name;

    @SerializedName("url")
    private String strUrl;

    private Venue venue;

    @SerializedName("icon")
    private String iconStrUrl;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrUrl() {
        return strUrl;
    }

    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getIconStrUrl() {
        return iconStrUrl;
    }

    public void setIconStrUrl(String iconStrUrl) {
        this.iconStrUrl = iconStrUrl;
    }
}
