package com.example.csc179_patient_tracker_app.ui.dashboard;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.AppointmentModel;
import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private RecyclerView appointmentRecycler;
    private RecyclerView.Adapter adapter;
    private MyAppDB db;
    List<AppointmentModel> appointments;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        appointmentRecycler = root.findViewById(R.id.appointment_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        appointmentRecycler.setLayoutManager(layoutManager);
        db = MyAppDB.getDbInstance(getContext());

        navController = NavHostFragment.findNavController(this);

        appointments = db.AppointmentDAO().getAllAppointments();

        adapter = new AppointmentAdapter(appointments, db, (appt) -> {
            DashboardFragmentDirections.ActionNavigationDashboardToNavigationMenu action = DashboardFragmentDirections.actionNavigationDashboardToNavigationMenu(appt);
            navController.navigate(action);
        });

        appointmentRecycler.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        appointmentRecycler.addItemDecoration(dividerItemDecoration);

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
