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

@OptIn(ExperimentalMaterial3Api::class)
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
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.padding(12.dp).width(350.dp),
                thickness = 1.dp,
                color = Color.Red
            )
            Row {
                pilihanJK.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                        selected = txtGender == item,
                        onClick = {
                            txtGender = item
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = txtGender == item,
                            onClick = { txtGender = item }
                        )
                        Text(text = item)
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(12.dp).width(350.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            OutlinedTextField(
                value = txtAlamat,
                onValueChange = { txtAlamat = it },
                shape = MaterialTheme.shapes.medium,
                singleLine = true,
                modifier = Modifier.width(350.dp),
                label = { Text("Alamat") }
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier.fillMaxWidth(fraction = 1f).padding(horizontal = 20.dp),
                enabled = txtAlamat.isNotEmpty(),
                onClick = { onSubmitButtonClicked(listData)
                }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}




