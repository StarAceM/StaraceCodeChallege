package starace.com.codechallenge.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import starace.com.codechallenge.models.Guide;

/**
 * Created by mstarace on 8/1/17.
 */

public interface RetrofitInterface {

    @GET("service/v2/upcomingGuides/")
    Call<Guide> getUpcomingGuides();
}
