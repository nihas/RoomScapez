package com.room.scapez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Nihas on 16-Jul-15.
 */
public class RVAdapter extends BaseAdapter{

    List<Person> persons;
    private ArrayList<Person> arraylist;
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;


    RVAdapter(Context mContext,List<Person> persons){
        this.persons = persons;
        this.mContext=mContext;
        this.arraylist = new ArrayList<Person>();
        this.arraylist.addAll(persons);

    }

//    @Override
//    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
//        PersonViewHolder pvh = new PersonViewHolder(v);
//        return pvh;
//    }
//
//    @Override
//    public void onBindViewHolder(PersonViewHolder holder, int i) {
//        holder.personName.setText(persons.get(i).name);
//        holder.personAge.setText(persons.get(i).age);
//        holder.personPhoto.setImageResource(persons.get(i).photoId);
//
//    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }
//
//    @Override
//    public int getItemCount() {
//        return persons.size();
//    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final PersonViewHolder holder;
        if (view == null) {
            holder = new PersonViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item, viewGroup, false);
            // Locate the TextViews in listview_item.xml
            holder.cv = (CardView)view.findViewById(R.id.cv);
            holder.personName = (TextView)view.findViewById(R.id.person_name);
//            holder.personAge = (TextView)view.findViewById(R.id.person_age);
//            holder.personPhoto = (ImageView)view.findViewById(R.id.person_photo);
            view.setTag(holder);
        } else {
            holder = (PersonViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.personName.setText(persons.get(i).name);
//        holder.personAge.setText(persons.get(i).age);
//        holder.personPhoto.setImageResource(persons.get(i).photoId);



        // Listen for ListView Item Click
//        view.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // Send single item click data to SingleItemView Class
//                Intent intent = new Intent(mContext, AvatarToolbarSample.class);
//                // Pass all data rank
////                intent.putExtra("rank",(worldpopulationlist.get(position).getRank()));
//                // Pass all data country
//                intent.putExtra("city",(persons.get(i).name));
//                // Pass all data population
////                intent.putExtra("population",(worldpopulationlist.get(position).getPopulation()));
//                // Pass all data flag
//                // Start SingleItemView Class
//                mContext.startActivity(intent);
//                ((SearchActivity)mContext).finish();
//                //Toast.makeText(mContext," "+persons.get(i).name,Toast.LENGTH_SHORT).show();
//
//
//            }
//        });

        return view;
    }

    public static class PersonViewHolder{//} extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

//        PersonViewHolder(View itemView) {
//           // super(itemView);
//            cv = (CardView)itemView.findViewById(R.id.cv);
//            personName = (TextView)itemView.findViewById(R.id.person_name);
//            personAge = (TextView)itemView.findViewById(R.id.person_age);
//            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
//        }
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        persons.clear();
        if (charText.length() == 0) {
            persons.addAll(arraylist);
        }
        else
        {
            for (Person wp : arraylist)
            {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    persons.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
