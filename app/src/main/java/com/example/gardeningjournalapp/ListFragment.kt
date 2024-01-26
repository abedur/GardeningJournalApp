package com.example.gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardeningjournalapp.data.PlantViewModel
import com.example.gardeningjournalapp.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var plantViewModel: PlantViewModel
    private var binding: FragmentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter = ListAdapter()
        binding?.recyclerview?.adapter = listAdapter
        binding?.recyclerview?.layoutManager = LinearLayoutManager(requireContext())

        plantViewModel = ViewModelProvider(this).get(PlantViewModel::class.java)
        plantViewModel.readAllData.observe(viewLifecycleOwner, Observer { plant ->
            listAdapter.setData(plant)
        })

        binding?.floatingActionButton?.setOnClickListener {
            findNavController().navigate(R.id.actionMoveToAddFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
