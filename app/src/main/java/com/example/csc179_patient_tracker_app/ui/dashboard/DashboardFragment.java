package com.example.csc179_patient_tracker_app.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private NavController navController;

    private Button createPatientButton;
    private RecyclerView appointmentRecycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        navController = NavHostFragment.findNavController(this);

        createPatientButton = root.findViewById(R.id.button_create_patient);
        appointmentRecycler = root.findViewById(R.id.appointment_recycler);

        createPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_navigation_dashboard_to_create_patient);
            }
        });

        appointmentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        appointmentRecycler.setAdapter(new AppointmentRecyclerAdapter(dashboardViewModel.getAppointments(), (appt) -> {
            DashboardFragmentDirections.ActionNavigationDashboardToNavigationMenu action = DashboardFragmentDirections.actionNavigationDashboardToNavigationMenu(appt);
            navController.navigate(action);
        }));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}