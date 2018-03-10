package com.example.rony.allaboutcse;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
 
 public class ListViewCustomAdapter extends ArrayAdapter {

     public ArrayList<String> subject;

     public ArrayList<String> details;

     public Context context;

     public LayoutInflater inflater;

     public ListViewCustomAdapter(Context context,
                                  ArrayList<String> subject, ArrayList<String> details) {
         // TODO Auto-generated constructor stub
         super(context, 0);
         this.context = context;
         this.subject = subject;
         this.details = details;

         this.inflater = (LayoutInflater) context
                 .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     }

     @Override
     public int getCount() {
         // TODO Auto-generated method stub
         return subject.size();
     }

     @Override
     public Object getItem(int position) {
         // TODO Auto-generated method stub
         return null;
     }

     @Override
     public long getItemId(int position) {
         // TODO Auto-generated method stub
         return 0;
     }

     public class ViewHolder {
         //ImageView thumbnail;
         TextView txtViewSubject;
         TextView txtViewDetails;

     }

     @Override
     public View getView(int position, View convertview, ViewGroup parent) {
         // TODO Auto-generated method stub

         ViewHolder holder;
         if (convertview == null) {
             holder = new ViewHolder();
             convertview = inflater.inflate(R.layout.listview_row, null);


//    holder.thumbnail = (ImageView) convertview
//      .findViewById(R.id.imgViewLogo);
             holder.txtViewSubject = (TextView) convertview
                     .findViewById(R.id.txtViewTitle);
             holder.txtViewDetails = (TextView) convertview
                     .findViewById(R.id.txtViewDescription);

             convertview.setTag(holder);
         } else
         {
             holder = (ViewHolder) convertview.getTag();
         }

             //holder.thumbnail.setImageResource(R.drawable.home_back);
             holder.txtViewSubject.setText(subject.get(position));
             holder.txtViewDetails.setText(details.get(position));
             //convertview.setBackgroundResource((convertview.isSelected()) ? R.drawable.listview_background2 : R.layout.listview_background2);


         if (convertview.isSelected()) {
             convertview.setBackgroundResource(R.drawable.listview_background2);
         } else {
             convertview.setBackgroundResource(R.drawable.listview_background);
         }
         return convertview;
     }

 }