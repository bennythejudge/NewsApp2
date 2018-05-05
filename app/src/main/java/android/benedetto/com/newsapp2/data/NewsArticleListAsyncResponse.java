package android.benedetto.com.newsapp2.data;

import android.benedetto.com.newsapp2.model.NewsArticle;

import java.util.ArrayList;

public interface NewsArticleListAsyncResponse {
    void processFinished(ArrayList<NewsArticle> news);
}
