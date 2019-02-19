package com.marlon.fireapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marlon.fireapp.R;
import com.marlon.fireapp.activities.HomeActivity;
import com.marlon.fireapp.pojos.Note;
import com.marlon.fireapp.pojos.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewNote extends Fragment {

    EditText etText;
    Button btnSaveNote;
    View rootView;
    DatabaseReference databaseReference;
    FirebaseAuth auth;

    public NewNote() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_newnote, container, false);

        etText = rootView.findViewById(R.id.nn_ettext);
        btnSaveNote = rootView.findViewById(R.id.nn_btnSaveNote);


        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = etText.getText().toString().trim();

                Note note = new Note(text,text,6);

                databaseReference.child("users").child(auth.getCurrentUser().getUid()).child("notes").child(note.getName()).setValue(note);
                Toast.makeText(getActivity(), "Nota creada con exito!", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                getActivity().finish();


            }
        });

        return rootView;
    }

}
