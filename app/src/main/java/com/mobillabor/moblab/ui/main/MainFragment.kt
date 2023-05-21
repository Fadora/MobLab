package com.mobillabor.moblab.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mobillabor.moblab.R
import com.mobillabor.moblab.adapters.CharacterAdapter
import com.mobillabor.moblab.adapters.OnCharacterClickListener
import com.mobillabor.moblab.model.Character


class MainFragment: Fragment(), OnCharacterClickListener {
    private val characterListViewModel by viewModels<MainViewModel>()

    val characterAdapter = CharacterAdapter()
    lateinit var recyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = characterAdapter
        characterListViewModel.characterList.observe(viewLifecycleOwner) { list ->
            characterAdapter.submitList(list)
        }



    }

    override fun onCharacterSelected(h: Character) {
        val bundle = Bundle()
        bundle.putString("charID", h.charId)
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }


}