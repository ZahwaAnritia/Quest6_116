package com.example.quest6_116.viewmodel

import android.R
import com.example.quest6_116.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : viewModel() {

    private val _statusUI = MutableStateFlow( value = Siswa())
    val statusUI: StateFlow<Siswa> _statusUI.asStateFlow()

    fun setSiswa(ls: MutableList<String>){
        _statusUI.update { statusSaatIni->
            statusSaatIni.copy(nama=ls[0], gender=ls[1],  alamat =ls[2])
        }
    }
}