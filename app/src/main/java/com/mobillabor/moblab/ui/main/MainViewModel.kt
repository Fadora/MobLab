package com.mobillabor.moblab.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import com.mobillabor.moblab.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
): ViewModel(){
    val characterList : MutableLiveData<List<Character>?> = MutableLiveData(listOf())

    init{
       initData(mainRepository)
    }

    fun initData(mainRepository:MainRepository){
        viewModelScope.launch {
            var list = mainRepository.loadCharactersFromAPI()
            if(list == null){
                list = mainRepository.loadCharactersFromLocal()
            }
            else{
                mainRepository.saveFirst5CharacterToLocal(list.subList(0,5))
            }
            characterList.value = list
        }
    }



}