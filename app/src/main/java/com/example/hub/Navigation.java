package com.example.hub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Navigation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_navigation, container, false);

        ImageView computerStudiesImageView = view.findViewById(R.id.computer);
        ImageView engineeringStudiesImageView = view.findViewById(R.id.engineering);
        ImageView casStudiesImageView = view.findViewById(R.id.cas_studies);
        ImageView cbpaStudiesImageView = view.findViewById(R.id.cbpa_studies);
        ImageView Navigator = view.findViewById(R.id.building);

        Navigator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageDialog("ERROR", "PLEASE CONTACT DEVELOPER TO PERFORM THIS EVENT.");
            }
        });

        computerStudiesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog("Computer Studies", "•Information Technology \n•Information System");
            }
        });

        engineeringStudiesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog("Engineering Studies", "•Civil Engineering \n" +
                        "•Electrical Engineering\n" +
                        "•Mechanical Engineering");
            }
        });

        casStudiesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog("CAS Studies", "•Development Communication\n" +
                        "•Applied Mathematics\n" +
                        "•Biology\n" +
                        "•English Language Studies\n" +
                        "•History\n" +
                        "•Sociology");
            }
        });

        cbpaStudiesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog("CBPA Studies", "•Business Administration\n" +
                        "Major in:\n" +
                        "  •Business Economics\n" +
                        "  •Marketing Management\n" +
                        "  •Human Resource Management\n" +
                        "  •Financial Management\n" +
                        "•Public Administration\n" +
                        "•Hospitality Management\n" +
                        "•Accountancy\n" +
                        "•Office Administration\n" +
                        "•Entrepreneurship");
            }
        });

        return view;
    }

    private void showImageDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
