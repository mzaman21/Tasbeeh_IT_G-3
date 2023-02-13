package com.example.tasbeehapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {

    Context context;
//    String[] date;
//    int[] kalma,darood,astgfar;
    List<TasbeehModel> list=new ArrayList<TasbeehModel>();

    public GridAdapter(Context context, List<TasbeehModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myview= inflater.inflate(R.layout.grid_item,null);


        TextView t_date,t_kalma,t_darood,t_astgfar;

        t_date = myview.findViewById(R.id.g_date);
        t_kalma = myview.findViewById(R.id.g_kalma);
        t_darood = myview.findViewById(R.id.g_darood);
        t_astgfar = myview.findViewById(R.id.g_astgfar);

        String kstr  = String.valueOf(list.get(i).getKalma_Count());
        String dstr  = String.valueOf(list.get(i).getDarood_Count());
        String astr  = String.valueOf(list.get(i).getAstgfar_Count());


        t_date.setText(list.get(i).getToday_date());
        t_kalma.setText(kstr);
        t_darood.setText(dstr);
        t_astgfar.setText(astr);

        return myview;
    }
}
