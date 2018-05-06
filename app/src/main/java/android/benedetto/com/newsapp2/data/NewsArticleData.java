package android.benedetto.com.newsapp2.data;

import android.benedetto.com.newsapp2.controller.AppController;
import android.benedetto.com.newsapp2.model.NewsArticle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

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
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                    url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject quoteObj = response.getJSONObject(i);

//                            Quote quote = new Quote();
//                            quote.setQuote(quoteObj.getString("quote"));
//                            quote.setAuthor(quoteObj.getString("name"));

                            Log.d("getQuote", quoteObj.getString("name"));

//                            quoteArrayList.add(quote);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    // only when the HTTP call is done, we call the callback method
                    if (null != callBack) callBack.processFinished(news);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            Log.d("getNews", "about to call AppController.getInstance().addToRequestQueue(jsonArrayRequest);");
            Log.d("getNews", "jsonArrayRequest: " + jsonArrayRequest.toString());


            AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        }
}





