package android.benedetto.com.newsapp2;

import android.benedetto.com.newsapp2.data.NewsArticlePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private NewsArticlePagerAdapter npa;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // first we need to fetch the news from the API

        // then we display them in the recycler view
        mRecyclerView = findViewById(R.id.recycler_view);

        // finally we need to update them (when? ideally when the user pulls the view - if only
        // I knew how to do that
        

        // and finally2: we need a config menu to change the filter

        // good luck with all of the above! (self-derogatory sarcasm)


    }
}
