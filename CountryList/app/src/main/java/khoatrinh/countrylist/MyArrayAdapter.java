package khoatrinh.countrylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private ArrayList<Country> myList;

    static class ViewHolder {
        ImageView flagImg;
        TextView txtCountry, txtPop;
    }

    public MyArrayAdapter(Context context, int idLayout, ArrayList<Country> myList) {
        this.myList = myList;
        this.idLayout = idLayout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(idLayout, null);
            holder = new ViewHolder();
            holder.flagImg = (ImageView) convertView.findViewById(R.id.flagImg);
            holder.txtCountry = (TextView) convertView.findViewById(R.id.txtCountry);
            holder.txtPop = (TextView) convertView.findViewById(R.id.txtPop);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Country country = myList.get(position);
        holder.txtCountry.setText(country.getCountryName());
        holder.txtPop.setText("Population: " + country.getPopulation());
        holder.flagImg.setImageResource(country.getFlagId());
        return convertView;
    }
}
