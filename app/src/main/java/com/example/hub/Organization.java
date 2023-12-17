package com.example.hub;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Organization extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_organization, container, false);

        ImageView registrar = view.findViewById(R.id.registrar);
        ImageView MIS = view.findViewById(R.id.mis);
        ImageView appointment = view.findViewById(R.id.appointmenT);

        // Set OnClickListener for the ImageView
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the link when the ImageView is clicked
                openWebPage("https://web.facebook.com/CNSCRegistrarOfficial");
            }
        });

        MIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("https://web.facebook.com/cnsc.itso");
            }
        });

        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("https://s2.cnsc.edu.ph:55463/oaf/pages/appointment/");
            }
        });




        return view;
    }

    private void openWebPage(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
    }
