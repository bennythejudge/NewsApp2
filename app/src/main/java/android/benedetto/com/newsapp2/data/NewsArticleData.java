package android.benedetto.com.newsapp2.data;

import android.benedetto.com.newsapp2.controller.AppController;
import android.benedetto.com.newsapp2.model.NewsArticle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsArticleData {
        ArrayList<NewsArticle> news = new ArrayList<>();


    public void getNews(final NewsArticleListAsyncResponse callBack) {
        String url = "https://content.guardianapis.com/search?q=infance&api-key=33a2e54f-afd9-4dca-bc32-6ec3de85deca&order-by=newest";

        Log.d("getNews", "inside here");

        // singleton only use one instance
        // mistake nr. 2: you were using a different Volley in the gradle file
        //     implementation 'com.android.volley:volley:1.1.0'
        // instead of
        //     implementation 'com.dubsmash.volley:library:2.0.1'
        JsonObjectRequest jsor = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        NewsArticle na = new NewsArticle();

                        na.setContent("test");
                        na.setTitle("title");

                        news.add(na);


                        Log.d("onResponse", "response: " + response);

                        // only when the HTTP call is done, we call the callback method
                        if (null != callBack) callBack.processFinished(news);

                    }





                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse", "Error: " + error.getMessage());

            }
        });


        Log.d("getNews", "about to call AppController.getInstance().addToRequestQueue(jsonArrayRequest);");


        // for the second time you have spent a lot of time chasing the
        // null value exception at this point both times caused by
        // getInstance() because the entry for AppController was missing from the
        // manifest file
        AppController.getInstance().addToRequestQueue(jsor);
    }
}





