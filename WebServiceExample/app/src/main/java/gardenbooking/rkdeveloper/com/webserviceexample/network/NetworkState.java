package gardenbooking.rkdeveloper.com.webserviceexample.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ROHIT on 7/6/2016.
 */
public class NetworkState {

  private static NetworkState instance=new NetworkState();
  static Context context;
  ConnectivityManager connectivityManager;
  boolean connectet=false;
   public static NetworkState getInstance(Context c)
   {
       context=c;
       return instance;
   }

  public Boolean isConnecttoInternet()
  {
      connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
      if(connectivityManager!=null)
      {

          NetworkInfo info=connectivityManager.getActiveNetworkInfo();
           if(info.isConnected()&& info!=null&& info.isAvailable())
           {
               return true;
           }
      }

     return false;
  }

}
