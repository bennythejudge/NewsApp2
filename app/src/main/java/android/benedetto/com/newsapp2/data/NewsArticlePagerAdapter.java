package android.benedetto.com.newsapp2.data;

import android.benedetto.com.newsapp2.R;
import android.benedetto.com.newsapp2.model.NewsArticle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NewsArticlePagerAdapter extends
        RecyclerView.Adapter<NewsArticlePagerAdapter.MyViewHolder> {
    private List<NewsArticle> news;

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsArticlePagerAdapter(List<NewsArticle> news) {
        this.news = news;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView itemTitleTV;
        TextView itemBodyTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemTitleTV = (TextView) itemView.findViewById(R.id.item_title);
            itemBodyTV = (TextView) itemView.findViewById(R.id.item_body);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.v("onBindViewHolder", "position: " + position);
        NewsArticle na = news.get(position);
        holder.itemTitleTV.setText(na.getTitle());
        holder.itemBodyTV.setText(na.getContent());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return news.size();
    }
}