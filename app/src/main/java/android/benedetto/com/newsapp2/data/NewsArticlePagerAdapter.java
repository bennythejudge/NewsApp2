package android.benedetto.com.newsapp2.data;

import android.benedetto.com.newsapp2.R;
import android.benedetto.com.newsapp2.model.NewsArticle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NewsArticlePagerAdapter extends
        RecyclerView.Adapter<NewsArticlePagerAdapter.ViewHolder> {
    private List<NewsArticle> news;

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsArticlePagerAdapter(List<NewsArticle> news) {
        this.news = news;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NewsArticlePagerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(news.get(position).getTitle());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return news.size();
    }
}