package com.zeeroapps.sunflower.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zeeroapps.sunflower.R;
import com.zeeroapps.sunflower.adapters.GardenPlantAdapter;
import com.zeeroapps.sunflower.data.GardenPlanting;
import com.zeeroapps.sunflower.data.PlantAndGardenPlantings;
import com.zeeroapps.sunflower.databinding.FragmentGardenBinding;
import com.zeeroapps.sunflower.utils.InjectorUtils;
import com.zeeroapps.sunflower.view_models.GardenPlantingListViewModel;
import com.zeeroapps.sunflower.view_models.GardenPlantingListViewModelFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GardenFragment extends Fragment {
    private FragmentGardenBinding binding;

    public GardenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGardenBinding.inflate(inflater, container, false);
        GardenPlantAdapter adapter = new GardenPlantAdapter();
        binding.gardenList.setAdapter(adapter);
        subscribeUI(adapter);
        return binding.getRoot();
    }

    private void subscribeUI(GardenPlantAdapter adapter) {
        GardenPlantingListViewModelFactory factory = InjectorUtils.provideGardenPlantListViewModelFactory(getContext());
        GardenPlantingListViewModel viewModel = ViewModelProviders.of(this, factory).get(GardenPlantingListViewModel.class);
        viewModel.gardenPlantings.observe(getViewLifecycleOwner(), new Observer<List<GardenPlanting>>() {
            @Override
            public void onChanged(@Nullable List<GardenPlanting> gardenPlantings) {
                binding.setHasPlantings((gardenPlantings != null && !gardenPlantings.isEmpty()));
            }
        });

        viewModel.plantAndGardenPlantings.observe(getViewLifecycleOwner(), new Observer<List<PlantAndGardenPlantings>>() {
            @Override
            public void onChanged(@Nullable List<PlantAndGardenPlantings> gardenPlantingsList) {
                if (gardenPlantingsList != null && !gardenPlantingsList.isEmpty()) {
                    adapter.updateList(gardenPlantingsList);
                }
            }
        });
    }



}
