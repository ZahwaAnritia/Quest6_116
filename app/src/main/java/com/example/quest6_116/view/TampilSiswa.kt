package com.example.quest6_116.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.quest6_116.model.Siswa
import com.example.quest6_116.R
@Composable
fun TampilSiswa(
    statusUISiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {
    val items = listOf(
        Pair(stringResource(id = R.string.nama), statusUISiswa.nama),
        Pair(stringResource(id = R.string.gender), statusUISiswa.gender),
        Pair(stringResource(id = R.string.alamat), statusUISiswa.alamat)
    )
