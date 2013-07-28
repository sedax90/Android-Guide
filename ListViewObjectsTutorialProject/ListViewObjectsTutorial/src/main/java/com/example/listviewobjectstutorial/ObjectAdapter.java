package com.example.listviewobjectstutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Cristian on 28/07/13.
 */
public class ObjectAdapter extends ArrayAdapter<Cms> {
    //sovrascrivo il costruttore
    public ObjectAdapter(android.content.Context context, int textViewResourceId, Cms[] objects){
        super(context, textViewResourceId, objects);
    }

    //sovrascrivo il metodo GetView
    public View getView(int position, android.view.View convertView, android.view.ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.riga_lista, null);

        TextView LargeTxt = (TextView)convertView.findViewById(R.id.largeTxt);
        TextView SmallTxt = (TextView)convertView.findViewById(R.id.smallTxt);

        Cms cms = getItem(position);

        LargeTxt.setText(cms.getLarge());
        SmallTxt.setText(cms.getSmall());

        return convertView;
    }
}