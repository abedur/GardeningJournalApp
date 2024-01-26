package com.example.gardeningjournalapp

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gardeningjournalapp.data.Plant
import com.example.gardeningjournalapp.data.PlantViewModel
import com.example.gardeningjournalapp.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var plantViewModel: PlantViewModel;
    lateinit var binding: FragmentAddBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        binding.btnReturnToMain.setOnClickListener {
            findNavController().navigate(R.id.actionMoveToListFragment)

        }
        plantViewModel = ViewModelProvider(this)[PlantViewModel::class.java]
        binding.addNewPlant.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.getRoot();
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    private fun insertDataToDatabase() {

        val plantName = binding.plantName.text.toString();
        val plantType = binding.plantType.text.toString();
        val plantWaterFrequency = binding.plantWaterFrequency.text;
        val plantDate = binding.plantDate.text.toString();

        if (inputCheck(plantName, plantType, plantWaterFrequency)) {
            val newPlant =
                Plant(
                    0,
                    plantName,
                    plantType,
                    Integer.parseInt(plantWaterFrequency.toString()),
                    plantDate
                )
            plantViewModel.addPlant(newPlant)
            Toast.makeText(requireContext(), "New plant added successfully", Toast.LENGTH_LONG)
                .show()
            findNavController().navigate(R.id.actionMoveToListFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill all the fields.", Toast.LENGTH_LONG)
                .show()
        }
    }


}