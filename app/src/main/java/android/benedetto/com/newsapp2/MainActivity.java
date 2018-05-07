package android.benedetto.com.newsapp2;

import android.app.LoaderManager;
import android.benedetto.com.newsapp2.data.NewsArticleData;
import android.benedetto.com.newsapp2.data.NewsArticleListAsyncResponse;
import android.benedetto.com.newsapp2.data.NewsArticlePagerAdapter;
import android.benedetto.com.newsapp2.model.NewsArticle;
import android.content.Loader;
import android.support.v4.view.NestedScrollingChild;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<NewsArticle>> {

    private static final String LOG_TAG = MainActivity.class.getName();
    private static final int NEWSARTICLE_LOADER_ID = 1;


    private NewsArticlePagerAdapter npa;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<String> newsData;
    private ArrayList<NewsArticle> newsData1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<NewsArticle> some_news = getArticles();


        // initially I use a static array
        // create a list of NewsArticle
        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle(
                "How mobile tech is improving healthcare for some of the world’s most remote communities",
                "How mobile tech is improving healthcare for some of the world’s most remote communities How mobile tech is improving healthcare for some of the world’s most remote communities How mobile tech is improving healthcare for some of the world’s most remote communities"
        ));
        newsArticles.add(new NewsArticle(
                "Wildlife on your doorstep: share your May photos",
                "Wildlife on your doorstep: share your May photos Wildlife on your doorstep: share your May photos Wildlife on your doorstep: share your May photos "

        ));
        newsArticles.add(new NewsArticle(
                "Our Digital Fellows share their experiences of the scheme",
                "Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme"
        ));
        newsArticles.add(new NewsArticle(
                "Our Digital Fellows share their experiences of the scheme",
                "Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme"
        ));
        newsArticles.add(new NewsArticle(
                "Our Digital Fellows share their experiences of the scheme",
                "Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme"
        ));
        newsArticles.add(new NewsArticle(
                "Our Digital Fellows share their experiences of the scheme",
                "Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme"
        ));
        newsArticles.add(new NewsArticle(
                "Our Digital Fellows share their experiences of the scheme",
                "Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme Our Digital Fellows share their experiences of the scheme"
        ));

        // then we display them in the recycler view
        mRecyclerView = findViewById(R.id.recycler_view);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new NewsArticlePagerAdapter(newsArticles);
        mRecyclerView.setAdapter(mAdapter);

        // finally we need to update them (when? ideally when the user pulls the view - if only
        // I knew how to do that

        // and finally2: we need a config menu to change the filter

        // good luck with all of the above! (self-derogatory sarcasm)
    }

    @Override
    public Loader<List<NewsArticle>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<NewsArticle>> loader, List<NewsArticle> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<NewsArticle>> loader) {

    }
}
