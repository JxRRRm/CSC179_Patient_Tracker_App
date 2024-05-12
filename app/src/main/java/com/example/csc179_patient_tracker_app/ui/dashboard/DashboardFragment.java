package com.example.csc179_patient_tracker_app.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc179_patient_tracker_app.R;
import com.example.csc179_patient_tracker_app.data.MyAppDB;
import com.example.csc179_patient_tracker_app.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private NavController navController;

    private RecyclerView appointmentRecycler;
    private MyAppDB db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        navController = NavHostFragment.findNavController(this);
        db = MyAppDB.getDbInstance(getContext());


        appointmentRecycler = root.findViewById(R.id.appointment_recycler);

        appointmentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        appointmentRecycler.setAdapter(new AppointmentRecyclerAdapter(db.AppointmentDAO().getAllAppointments(), (appt) -> {
            DashboardFragmentDirections.ActionNavigationDashboardToNavigationMenu action = DashboardFragmentDirections.actionNavigationDashboardToNavigationMenu(appt);
            navController.navigate(action);
        }, getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}