package com.example.csc179_patient_tracker_app.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.data.PatientModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class AppointmentRecyclerAdapter extends RecyclerView.Adapter<AppointmentRecyclerAdapter.AppointmentRecyclerHolder> {

    private List<AppointmentModel> appointments;
    private Consumer<AppointmentModel> onClickConsumer;
    private MyAppDB db;

    public AppointmentRecyclerAdapter(List<AppointmentModel> appointments, Consumer<AppointmentModel> onClickConsumer, Context context) {
        this.appointments = appointments;
        this.onClickConsumer = onClickConsumer;

        Collections.sort(appointments);
        notifyDataSetChanged();
        db = MyAppDB.getDbInstance(context);
    }

    @NonNull
    @Override
    public AppointmentRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);

        return new AppointmentRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentRecyclerHolder holder, int position) {
        AppointmentModel appointment = appointments.get(position);
        PatientModel patient = appointment.getPatient(db);

        if (patient != null) {
            String lastName = patient.getLastName();
            String firstName = patient.getFirstName();
            String middleName = patient.getMiddleName();
            String patientName = String.format("%s, %s %s", lastName, firstName, middleName);

            String reason = appointment.getReason();
            String date = appointment.getDate();
            String appointmentText = String.format("Patient: %s\nReason: %s\nDate: %s", patientName, reason, date);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickConsumer.accept(appointment);
                }
            });

            holder.appointmentText.setText(appointmentText);
        } else {
            // Handle null patient
            holder.appointmentText.setText("Patient information not available");
            holder.itemView.setOnClickListener(null); // Disable click listener or handle accordingly
        }
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public static class AppointmentRecyclerHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView appointmentText;

        public AppointmentRecyclerHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            this.appointmentText = itemView.findViewById(R.id.appointment_text);
        }
    }
}
