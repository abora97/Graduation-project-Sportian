package com.example.graduationprojectsportian.model;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class firebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceSports;
    private List<Sport> sports = new ArrayList<>();


    public  interface DataStatus {
        void DataIsLoaded (List<Sport> sports, List<String> Keys);
        void DataInserted();
        void DataUpdated();
        void DataDeleted();
    }


    public firebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceSports = mDatabase.getReference("sports");
    }

    public void readYouthCenters(final DataStatus dataStatus){
        mReferenceSports.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                sports.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Sport sport = keyNode.getValue(Sport.class);
                    sports.add(sport);
                }
                dataStatus.DataIsLoaded(sports,keys);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}

