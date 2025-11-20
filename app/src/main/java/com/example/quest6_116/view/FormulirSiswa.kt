package com.example.quest6_116.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.quest6_116.R
import com.example.quest6_116.ui.theme.Quest6_116Theme

@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by rememberSaveable { mutableStateOf("") }
    var txtGender by rememberSaveable { mutableStateOf("") }
    val listData: MutableList<String> = mutableListOf(txtNama, txtGender,txtAlamat)

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ){ isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = txtNama,
                shape = MaterialTheme.shapes.medium,
                onValueChange = { txtNama = it },
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(350.dp),
                label = { Text("Nama Lengkap") }
            )
            HorizontalDivider(
                modifier = Modifier.padding(12.dp).width(350.dp),
                thickness = 1.dp,
                color = Color.Red
            )
            Row {
                pilihanJK.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = txtGender == item,
                        onClick = {
                            txtGender = item
                        }
                    ),
        }

