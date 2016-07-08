package gardenbooking.rkdeveloper.com.webserviceexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gardenbooking.rkdeveloper.com.webserviceexample.Utils.Data;

/**
 * Created by ROHIT on 7/8/2016.
 */
public class CustomAdapter extends BaseAdapter {

  Context c;
  ArrayList<Data> DataFromServer;
  LayoutInflater inflate;
  public CustomAdapter(Context c,ArrayList<Data> list)
  {
      DataFromServer=list;
      this.c=c;
  }


    @Override
    public int getCount() {
        return DataFromServer.size();
    }

    @Override
    public Object getItem(int position) {
        return DataFromServer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder holder;
        if(convertView==null)
        {
            inflate=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflate.inflate(R.layout.custom_layout, parent,false);
            holder=new viewHolder();
           holder.name=(TextView)convertView.findViewById(R.id.name);
            holder.country=(TextView)convertView.findViewById(R.id.country);
            holder.des=(TextView)convertView.findViewById(R.id.des);
            holder.tem=(TextView)convertView.findViewById(R.id.temp);
            convertView.setTag(holder);


        }
        else{
            holder=(viewHolder)convertView.getTag();
        }

        holder.name.setText(DataFromServer.get(position).getName());
        holder.country.setText(DataFromServer.get(position).getCountry());
        holder.tem.setText(String.valueOf(DataFromServer.get(position).getTemp()));
        holder.des.setText(DataFromServer.get(position).getDescription());

        return convertView;
    }

    class viewHolder{
       TextView name,des,country,tem;
    }
}
