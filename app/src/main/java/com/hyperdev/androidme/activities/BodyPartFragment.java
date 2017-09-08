package com.hyperdev.androidme.activities;

/**
 * Created by TONYO on 9/8/2017.
 */



import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;



public class BodyPartFragment extends Fragment {

    private List<Integer> partnum;
    private int position;
    private static final String list_part = "parts_list";
    private static final String num_part = "parts_number";
    public BodyPartFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            partnum = savedInstanceState.getIntegerArrayList(list_part);
            position = savedInstanceState.getInt(num_part);
        }
        View rootView = inflater.inflate(R.layout.body_part_fragment, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.Fragment);
        if(partnum !=null){
            imageView.setImageResource(partnum.get(position));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(position < partnum.size()-1){
                        position++;
                    }else {
                        position = 0;
                    }
                    imageView.setImageResource(partnum.get(position));
                }
            });
        }
        return rootView;
    }

    public void setPartList(List<Integer> partList) {

        this.partnum = partList;
    }

    public void setListPosition(int mListPosition) {

        this.position= mListPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(list_part, (ArrayList<Integer>)partnum);
        outState.putInt(num_part,position);
    }
}