package com.example.hphp.spetcare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link tipsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link tipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tipsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        int mascota = this.getArguments().getInt("mascota", -1);
        TextView textView = getActivity().findViewById(R.id.animal);
        if(mascota == 0){
            textView.setText("El animal es un perro :D");
        }else if(mascota == 1){
            textView.setText("El animal es un gato :D");
        }else if(mascota == 2){
            textView.setText("El animal es un hamster :D");
        }else if(mascota == 3){
            textView.setText("El animal es un pajaro :D");
        }
    }
}
