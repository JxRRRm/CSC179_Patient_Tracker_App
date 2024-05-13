package com.example.csc179_patient_tracker_app.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.data.PatientModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PatientSearchRecyclerAdapter extends RecyclerView.Adapter<PatientSearchRecyclerAdapter.PatientItem> {
    private List<PatientModel> patients = new ArrayList<>();
    private MyAppDB db;
    private Consumer<PatientModel> onClickListener;

    public PatientSearchRecyclerAdapter(Context context, Consumer<PatientModel> onClick) {
        db = MyAppDB.getDbInstance(context);
        this.onClickListener = onClick;
    }

    @NonNull
    @Override
    public PatientItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient, parent, false);

        return new PatientItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientItem holder, int position) {
        PatientModel patientModel = patients.get(position);
        holder.firstName.setText(patientModel.firstName);
        holder.middleName.setText(patientModel.middleName);
        holder.lastName.setText(patientModel.lastName);
        holder.dob.setText(patientModel.dob);
        holder.phoneNumber.setText(patientModel.homePhone);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.accept(patientModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void resetSearch() {
        patients.clear();
        notifyDataSetChanged();
    }
    public void search(String firstName, String middleName, String lastName) {
        patients = db.PatientDAO().searchPatients(firstName, middleName, lastName);
        notifyDataSetChanged();
    }

    public void search(String firstName, String middleName, String lastName, String dob, String medicalId) {
        patients = db.PatientDAO().searchPatients(firstName, middleName, lastName, dob, medicalId);
        notifyDataSetChanged();
    }

    static class PatientItem extends RecyclerView.ViewHolder {
        public TextView firstName;
        public TextView middleName;
        public TextView lastName;
        public TextView dob;
        public TextView phoneNumber;

        public PatientItem(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.first_name);
            middleName = itemView.findViewById(R.id.middle_name);
            lastName = itemView.findViewById(R.id.last_name);
            dob = itemView.findViewById(R.id.dob);
            phoneNumber = itemView.findViewById(R.id.phone_number);
        }
    }
}
