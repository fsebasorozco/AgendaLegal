package com.fsebasorozco.agendalegal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.R.*;

public class LocationActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Button Bloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Bloc = (Button) findViewById(R.id.Bloc);

        Bloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationActivity.this,MapsActivity.class);
                startActivityForResult(intent,1);
            }
        });
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Notarias");
        listDataHeader.add("Juzgados");
        listDataHeader.add("Cortes");

        // Adding child data
        List<String> Notarias = new ArrayList<String>();
        Notarias.add("The Shawshank Redemption");
        Notarias.add("The Godfather");
        Notarias.add("The Godfather: Part II");
        Notarias.add("Pulp Fiction");
        Notarias.add("The Good, the Bad and the Ugly");
        Notarias.add("The Dark Knight");
        Notarias.add("12 Angry Men");

        List<String> Juzgados = new ArrayList<String>();
        Juzgados.add("The Conjuring");
        Juzgados.add("Despicable Me 2");
        Juzgados.add("Turbo");
        Juzgados.add("Grown Ups 2");
        Juzgados.add("Red 2");
        Juzgados.add("The Wolverine");

        List<String> Cortes = new ArrayList<String>();
        Cortes.add("2 Guns");
        Cortes.add("The Smurfs 2");
        Cortes.add("The Spectacular Now");
        Cortes.add("The Canyons");
        Cortes.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), Notarias); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Juzgados);
        listDataChild.put(listDataHeader.get(2), Cortes);
    }
}
