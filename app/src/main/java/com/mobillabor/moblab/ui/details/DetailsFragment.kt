package com.mobillabor.moblab.ui.details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mobillabor.moblab.R
import com.mobillabor.moblab.ui.main.MainViewModel

class DetailsFragment: Fragment() {

    private val detailsViewModel by viewModels<DetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        detailsViewModel.character.observe(viewLifecycleOwner) { char ->
           if(char != null){
            view.findViewById<TextView>(R.id.character_name).text = char.name
            view.findViewById<TextView>(R.id.birthdate).text = getString(R.string.birthdate, char.birthdate)
            view.findViewById<TextView>(R.id.date_of_death).text = getString(R.string.dateofdeath, char.dateofdeath)
            view.findViewById<TextView>(R.id.race).text = getString(R.string.race, char.race)
            view.findViewById<TextView>(R.id.realm).text = getString(R.string.realm, char.realm)
            view.findViewById<TextView>(R.id.gender).text = getString(R.string.gender, char.gender)
            view.findViewById<TextView>(R.id.spouse).text = getString(R.string.spouse, char.spouse)
            view.findViewById<TextView>(R.id.hair).text = getString(R.string.hair, char.hair)
            view.findViewById<TextView>(R.id.height).text = getString(R.string.height, char.height)
        }}

        val charId = arguments?.getString("charID")

        if (charId != null) {
            detailsViewModel.initValues(charId)
        }

    }
}