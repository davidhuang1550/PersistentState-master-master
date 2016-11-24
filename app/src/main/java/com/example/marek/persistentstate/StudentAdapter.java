package com.example.marek.persistentstate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by xlhuang3 on 11/24/2016.
 */
public class StudentAdapter extends BaseAdapter {
    ArrayList<String> studentId;
    ArrayList<String> studentGrade;
    Context context;
    StudentAdapter(ArrayList<String> sId,ArrayList<String> sGrade,Context c){
        studentGrade=sGrade;
        studentId=sId;
        context=c;
    }

    @Override
    public int getCount() {
        return studentGrade.size();
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
        View row;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row=inflater.inflate(R.layout.studentlayout,null);
        TextView t1 = (TextView)row.findViewById(R.id.studentid);
        TextView t2 = (TextView)row.findViewById(R.id.studentgrade);
        t1.setText(studentId.get(i));
        t2.setText(studentGrade.get(i));
        return row;


    }
}
