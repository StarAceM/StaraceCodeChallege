package starace.com.codechallenge.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import starace.com.codechallenge.R;
import starace.com.codechallenge.models.GuideData;
import starace.com.codechallenge.models.Venue;

/**
 * Created by mstarace on 8/1/17.
 */

public class GuideRecyclerAdapter extends RecyclerView.Adapter<GuideRecyclerAdapter.GuideViewHolder> {

    private List<GuideData> guideDataList;

    public GuideRecyclerAdapter(List<GuideData> guideDataList) {
        this.guideDataList = guideDataList;
    }

    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
        return new GuideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, int position) {
        GuideData data = guideDataList.get(position);
        holder.name.setText(data.getName());
        holder.endDate.setText(holder.endDate.getContext().getString(R.string.end_date_prefix).concat(" ").
                concat(data.getEndDate()));
        setLocationText(holder.location, data.getVenue());
        setIconImage(holder.icon, data.getIconStrUrl());
        setDivider(holder.divider, position);
    }

    private void setLocationText(TextView location, Venue venue) {
        if (venue.getState() == null) {
            location.setVisibility(View.GONE);
        } else if (venue.getCity() == null) {
            location.setText(venue.getState());
        } else {
            location.setText(venue.getCity().concat(", ").concat(venue.getState()));
        }
    }

    private void setIconImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .resize(150, 150)
                .centerCrop()
                .into(imageView);
    }

    private void setDivider(View divider, int position) {
        if (position == guideDataList.size() - 1) {
            divider.setVisibility(View.INVISIBLE);
        } else {
            divider.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return guideDataList.size();
    }

    public class GuideViewHolder extends RecyclerView.ViewHolder {

        TextView location;

        TextView name;

        TextView endDate;

        ImageView icon;

        View divider;

        private GuideViewHolder(View itemView) {
            super(itemView);

            location = (TextView) itemView.findViewById(R.id.guide_location_text_view);
            name = (TextView) itemView.findViewById(R.id.guide_name_text_view);
            endDate = (TextView) itemView.findViewById(R.id.guide_end_date_text_view);
            icon = (ImageView) itemView.findViewById(R.id.guide_icon_image_view);
            divider = itemView.findViewById(R.id.guide_divider);

        }
    }
}
