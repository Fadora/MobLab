package com.mobillabor.moblab.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobillabor.moblab.model.Character
import com.mobillabor.moblab.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.quote

@HiltViewModel
class DetailsViewModel @Inject constructor(
    detailsRepo: DetailsRepository
)
    : ViewModel(){
    val character : MutableLiveData<Character?> = MutableLiveData()
    val quoteList : MutableLiveData<List<Quote>?> = MutableLiveData(listOf())
    val detailsRepository = detailsRepo

    fun initValues(charId: String){
        viewModelScope.launch {
            var char  = detailsRepository.loadCharacterFromAPI(charId)
            var quotes:List<Quote>? = null;
            if(char !=null){
                quotes = detailsRepository.loadQuoteForCharFromAPI(charId)
                if(quotes != null && quotes.size > 4){
                    detailsRepository.saveFirst5Quotes(quotes.subList(0,5))
                }
            }
            else{
                char = detailsRepository.loadCharacterFromLocal(charId)
                if(char != null){
                    quotes = detailsRepository.loadQuoteForCharFromLocal(charId)
                }
            }

            character.value= char
            quoteList.value= quotes

        }
    }

    }