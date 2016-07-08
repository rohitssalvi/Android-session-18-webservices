package gardenbooking.rkdeveloper.com.webserviceexample.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.util.concurrent.TimeUnit;

import gardenbooking.rkdeveloper.com.webserviceexample.Utils.CommanUtils;

/**
 * Created by ROHIT on 7/7/2016.
 */
public class callWebservice extends AsyncTask<String,Void,String> {

    Context context;

    String url;
    String result="";
    getWebServiceResult webResult;
    FormEncodingBuilder param;
    public callWebservice(Context c,String url,FormEncodingBuilder p,getWebServiceResult s)
    {
       context=c;
     webResult=s;
        this.url=url;
        param=p;

    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        CommanUtils.showProgressDialog(context,"Please Wait",false);

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        CommanUtils.hideLoding();
        if(result.equals(""))
        {

        }
        else {

            try {
               webResult.getWebresopnse(s);

            } catch (Exception e) {

            }
        }


    }

    @Override
    protected String doInBackground(String... params) {

        OkHttpClient client=new OkHttpClient();


        Request request=new Request.Builder()
                .url(url)
                .get()
                .build();

        String hit_url=url+request.toString();
        Log.i("URL",hit_url);
        try{
            Response response=client.newCall(request).execute();
            if(!response.isSuccessful())
            {
                result=response.toString();
                if(result.equals("")) {

                    CommanUtils.showToast(context, "Some Erroe Occuerd");
                }
            }

            result=response.body().string();

        }catch (Exception e)
        {

        }
        return result;
    }
}
