package android.benedetto.com.newsapp2.controller;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    public static final String TAG = AppController.class.getSimpleName();
    private static AppController mInstance;
    private RequestQueue mRequestQueue;


    public static synchronized AppController getInstance() {
            Log.d("getInstance", "before the log.d");
            Log.d("getInstance", "mInstance: " + mInstance.toString());
            return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("onCreate", "inside AppController");
        mInstance = this;
    }

    public RequestQueue getRequestQueue() {
        Log.d("getRequestQueue", "inside here");


        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
            Log.d("getRequestQueue",
                    "it was null going for true branch mRequestQueue: " + mRequestQueue.toString());

        } else {
            Log.d("getRequestQueue", "going for else with mRequestQueue: " +
                    mRequestQueue.toString());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {

        Log.d("addToRequestQueue", "inside here - 2 argument version");
        Log.d("addToRequestQueue", "req: " + req.toString());
        Log.d("addToRequestQueue", "tag: " + tag.toString());


        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }


    public <T> void addToRequestQueue(Request<T> req) {

        Log.d("addToRequestQueue", "inside here - single argument version");
        Log.d("addToRequestQueue", "req: " + req.toString());

        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
