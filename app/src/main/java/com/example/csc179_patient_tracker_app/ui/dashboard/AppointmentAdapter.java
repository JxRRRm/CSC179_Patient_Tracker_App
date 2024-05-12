package com.example.csc179_patient_tracker_app.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.MyAppDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {
    private List<AppointmentModel> appointments;
    private MyAppDB db;

    public AppointmentAdapter(List<AppointmentModel> appointments, MyAppDB db) {
        this.appointments = filterAppointmentsForToday(appointments);
        this.db = db;
    }

    @NonNull
    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.ViewHolder holder, int position) {
        AppointmentModel appointment = appointments.get(position);
        // Fetch and display patient's name
        int patientId = appointment.getPatientId();
        String patientName = db.AppointmentDAO().getPatientName(patientId);

        holder.tv_patientname.setText(patientName);
        holder.tv_date.setText(appointment.getDate());
        holder.tv_time.setText(appointment.getAppointmentTime());
        holder.tv_reason.setText(appointment.getReason());


    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    private List<AppointmentModel> filterAppointmentsForToday(List<AppointmentModel> appointments) {
        List<AppointmentModel> filteredAppointments = new ArrayList<>();
        Calendar today = Calendar.getInstance();
        for (AppointmentModel appointment : appointments) {
            Date appointmentDate = parseDateString(appointment.getDate());
            if (isSameDay(today, appointmentDate)) {
                filteredAppointments.add(appointment);
            }
        }
        return filteredAppointments;
    }

    private Date parseDateString(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isSameDay(Calendar cal, Date date) {
        if (date == null) {
            return false;
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        return cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date, tv_time, tv_reason, tv_patientname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_reason = itemView.findViewById(R.id.tv_reason);
            tv_patientname = itemView.findViewById(R.id.tv_patientname);
        }
    }
}
