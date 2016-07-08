package gardenbooking.rkdeveloper.com.webserviceexample.network;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import gardenbooking.rkdeveloper.com.webserviceexample.Utils.CommanUtils;

/**
 * Created by ROHIT on 7/8/2016.
 */
public class callWebserivesUsingAsynHttp {

    Context context;
    String url;
    getWebServiceResult webResult;


    public callWebserivesUsingAsynHttp(Context c,String urls)
    {
   context=c;
    this.url=urls;


    }

    public void getDataFromServer()
    {

        AsyncHttpClient client=new AsyncHttpClient();
        client.get(context,url, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                CommanUtils.showProgressDialog(context, "Loding Data...", false);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                CommanUtils.hideLoding();



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                CommanUtils.hideLoding();
            }
        });


    }

}
