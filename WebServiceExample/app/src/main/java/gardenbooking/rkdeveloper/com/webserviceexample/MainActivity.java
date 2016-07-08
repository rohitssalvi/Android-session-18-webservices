package gardenbooking.rkdeveloper.com.webserviceexample;

import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.okhttp.FormEncodingBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import gardenbooking.rkdeveloper.com.webserviceexample.Utils.CommanUtils;
import gardenbooking.rkdeveloper.com.webserviceexample.Utils.Data;
import gardenbooking.rkdeveloper.com.webserviceexample.network.NetworkState;
import gardenbooking.rkdeveloper.com.webserviceexample.network.callWebserivesUsingAsynHttp;
import gardenbooking.rkdeveloper.com.webserviceexample.network.callWebservice;
import gardenbooking.rkdeveloper.com.webserviceexample.network.getWebServiceResult;

public class MainActivity extends AppCompatActivity implements getWebServiceResult {

private  String url="http://api.openweathermap.org/data/2.5/weather?q=bangalore&appid=d7b900681c37193223281142bd919019";
    ArrayList<Data> plist=new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   listView=(ListView)findViewById(R.id.list);
        getDataFromServer();


    }

    private void getDataFromServer() {
        FormEncodingBuilder param=new FormEncodingBuilder();
        param.add("q","udaipur");


       callWebservice services=new callWebservice(this,url,param,this);
        services.execute();

        /*callWebserivesUsingAsynHttp res=new callWebserivesUsingAsynHttp(this,url);
        res.getDataFromServer();*/



    }

    @Override
    public void getWebresopnse(String result) {

        try{
            JSONObject jsonObject=new JSONObject(result);
            String name=jsonObject.getString("name");
           JSONObject temp=jsonObject.getJSONObject("main");
            float t=temp.getInt("temp");
            JSONObject sys=jsonObject.getJSONObject("sys");
            String s=sys.getString("country");
            JSONArray jsonArray1=jsonObject.getJSONArray("weather");
            for (int i=0;i<jsonArray1.length();i++)
            {


                JSONObject obj=jsonArray1.getJSONObject(i);
                Data d=new Data();
                d.setDescription(obj.getString("description"));
                d.setName(name);
                d.setTemp(t);
                d.setCountry(s);
                plist.add(d);


            }

            CustomAdapter adapter=new CustomAdapter(MainActivity.this,plist);
            listView.setAdapter(adapter);



        }catch (Exception e)
        {

        }

    }
}
