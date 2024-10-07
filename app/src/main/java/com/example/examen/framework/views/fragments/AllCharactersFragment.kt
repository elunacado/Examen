// AllCharactersFragment.kt
package com.example.examen.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.R
import com.example.examen.data.network.model.DragonBallObject
import com.example.examen.databinding.FragmentAllCharactersBinding
import com.example.examen.framework.adapters.DragonBallAdapter
import com.example.examen.framework.viewmodel.AllCharactersViewModel

class AllCharactersFragment : Fragment() {
    private var _binding: FragmentAllCharactersBinding? = null

    private lateinit var viewModel: AllCharactersViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DragonBallAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AllCharactersViewModel::class.java]

        _binding = FragmentAllCharactersBinding.inflate(inflater, container, false)
        val root: View = _binding!!.root

        initializeComponents(root)
        initializeObservers()
        viewModel.getDragonBallList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(root: View) {
        recyclerView = root.findViewById(R.id.RVDragonBall)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        adapter = DragonBallAdapter(emptyList(), requireContext())
        recyclerView.adapter = adapter
    }

    private fun setUpRecyclerView(dataForList: List<DragonBallObject>) {
        adapter.updateData(dataForList)
    }

    private fun initializeObservers() {
        viewModel.characters.observe(viewLifecycleOwner) { dragonBallObjects ->
            setUpRecyclerView(dragonBallObjects)
        }
    }
}