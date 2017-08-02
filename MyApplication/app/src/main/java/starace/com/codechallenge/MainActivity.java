package starace.com.codechallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import starace.com.codechallenge.RecyclerView.GuideRecyclerAdapter;
import starace.com.codechallenge.models.Guide;
import starace.com.codechallenge.models.GuideData;
import starace.com.codechallenge.retrofit.RetrofitClient;
import starace.com.codechallenge.retrofit.RetrofitInterface;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressBar progressBar;

    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        makeCallToGuides();
    }

    private void initViews() {
        progressBar = (ProgressBar) findViewById(R.id.guide_progress_bar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void makeCallToGuides() {
        RetrofitInterface retrofitService = RetrofitClient.getClient().create(RetrofitInterface.class);
        Call<Guide> call = retrofitService.getUpcomingGuides();
        call.enqueue(new Callback<Guide>() {
            @Override
            public void onResponse(Call<Guide> call, Response<Guide> response) {
                Guide guide = response.body();
                setAdapter(guide.getGuideDataList());
                Log.d(TAG, "response successful");
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Guide> call, Throwable t) {
                Log.e(TAG, "Call to " + call.request().toString() + " has failed: ");
                Toast.makeText(MainActivity.this, getString(R.string.on_error_text), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setAdapter(List<GuideData> guideDataList) {
        GuideRecyclerAdapter adapter = new GuideRecyclerAdapter(guideDataList);
        recyclerView.setAdapter(adapter);
    }
}
