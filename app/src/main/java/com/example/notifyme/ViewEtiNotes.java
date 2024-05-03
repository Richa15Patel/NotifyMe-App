package com.example.notifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewEtiNotes extends AppCompatActivity {

    ListView myPDFListView2;
    DatabaseReference databaseReference2;
    List<UserHelperClass2> uploadPDFs2;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_eti_notes);

        myPDFListView2 = (ListView) findViewById(R.id.myListView);
        uploadPDFs2= new ArrayList<UserHelperClass2>(); //  uploadPDFs = new ArrayList< >();
        drawerLayout = findViewById(R.id.drawer_layout1);

        viewAllFiles();

        myPDFListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(ViewEtiNotes.this, "File opening", Toast.LENGTH_SHORT).show();

                UserHelperClass2 helperClass2 = uploadPDFs2.get(position);

                //opening selected file
                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(helperClass2.getUrl2()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles() {
        databaseReference2 = FirebaseDatabase.getInstance().getReference("ETI");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    UserHelperClass2 helperClass2 = postSnapshot.getValue(com.example.notifyme.UserHelperClass2.class);
                    uploadPDFs2.add(helperClass2);
                }

                String [] uploads = new String[uploadPDFs2.size()];

                for (int i = 0; i < uploads.length; i++){
                    uploads[i] = uploadPDFs2.get(i).getNameofpdf2();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads){
                    //                    @NonNull
//                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);
                        TextView myText = (TextView)view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);

                        return view;
                    }
                };
                // storing the pdfs in listView
                myPDFListView2.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void ClickMenu(View view) {openDrawer(drawerLayout);
    }

    private  void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, StudentViewPg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, StudentTimetablePg.class);
        startActivity(intent);
    }

    public void studyMaterial(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, StudentStudyMaterial.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(ViewEtiNotes.this, LogoutPg.class);
        startActivity(intent);
    }

}