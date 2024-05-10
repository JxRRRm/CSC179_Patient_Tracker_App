package com.example.csc179_patient_tracker_app.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.PatientModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class AppointmentRecyclerAdapter extends RecyclerView.Adapter<AppointmentRecyclerAdapter.AppointmentRecyclerHolder> {

    private List<AppointmentModel> appointments;
    private Consumer<AppointmentModel> onClickConsumer;

    public AppointmentRecyclerAdapter(List<AppointmentModel> appointments, Consumer<AppointmentModel> onClickConsumer) {
        this.appointments = appointments;
        this.onClickConsumer = onClickConsumer;

        Collections.sort(appointments);
        notifyDataSetChanged();
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

        PatientModel patient = appointment.getPatient();
        String patientName = String.format("%s, %s %s", patient.getLastName(), patient.getFirstName(), patient.getMiddleName());
        String reason = appointment.getReason();
        String date = appointment.getDate();

        String appointmentText = String.format("Patient: %s Reason: %s Date: %s", patientName, reason, date);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickConsumer.accept(appointment);
            }

        });

        holder.appointmentText.setText(appointmentText);
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
