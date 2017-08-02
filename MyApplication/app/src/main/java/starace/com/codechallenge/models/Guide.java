package starace.com.codechallenge.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mstarace on 8/1/17.
 */

public class Guide {

    @SerializedName("data")
    private List<GuideData> guideDataList;

    public Guide(List<GuideData> guideDataList) {
        this.guideDataList = guideDataList;
    }

    public List<GuideData> getGuideDataList() {
        return guideDataList;
    }

    public void setGuideDataList(List<GuideData> guideDataList) {
        this.guideDataList = guideDataList;
    }
}
