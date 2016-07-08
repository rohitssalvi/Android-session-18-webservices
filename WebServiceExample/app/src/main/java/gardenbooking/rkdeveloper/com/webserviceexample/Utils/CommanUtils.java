package gardenbooking.rkdeveloper.com.webserviceexample.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.ViewOutlineProvider;
import android.widget.Toast;

/**
 * Created by ROHIT on 7/7/2016.
 */
public class CommanUtils {

   static ProgressDialog  dialog;

   public static ProgressDialog showProgressDialog(Context c,String message,Boolean cancel)
   {
       dialog=new ProgressDialog(c);
       dialog.setMessage(message);
       dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
       dialog.setCanceledOnTouchOutside(cancel);
       dialog.show();
    return dialog;

   }

  public static void hideLoding()
  {
      if(dialog.isShowing()) {
          dialog.dismiss();
      }
  }

 public static void showToast(Context c,String messsage)
 {
    Toast toast=Toast.makeText(c,messsage,Toast.LENGTH_LONG);
     toast.show();

 }



}
