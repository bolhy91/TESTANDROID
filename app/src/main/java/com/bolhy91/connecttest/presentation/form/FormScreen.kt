package com.bolhy91.connecttest.presentation.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bolhy91.connecttest.R
import com.bolhy91.connecttest.domain.model.Person
import com.bolhy91.connecttest.ui.theme.blackColor
import com.bolhy91.connecttest.ui.theme.components.DropDownComponent
import com.bolhy91.connecttest.ui.theme.components.TextFieldComponent
import com.bolhy91.connecttest.utils.findMakeByMake
import com.bolhy91.connecttest.utils.findMakeByYear

@Composable
fun FormScreen(
    viewModel: FormViewModel = hiltViewModel()
) {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val color = remember { mutableStateOf("") }
    val plate = remember { mutableStateOf("") }
    val year = remember { mutableStateOf(0) }
    var make by remember { mutableStateOf("") }
    var models by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 22.dp,
                end = 22.dp,
                top = 22.dp,
            ),
    ) {
        Text(
            text = stringResource(R.string.welcome), style = TextStyle(
                color = blackColor, fontSize = 30.sp, fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldComponent(title = "First Name",
            valueText = firstName,
            onChangeText = { firstName.value = it })

        TextFieldComponent(title = "Last Name",
            valueText = lastName,
            onChangeText = { lastName.value = it })

        TextFieldComponent(title = "Phone", valueText = phone, onChangeText = { phone.value = it })

        TextFieldComponent(title = "Color", valueText = color, onChangeText = { color.value = it })

        TextFieldComponent(title = "Plate", valueText = plate, onChangeText = { plate.value = it })

        DropDownComponent("Year", listOf("2020", "2019"), onItemClick = {
            year.value = it.toInt()
        })
        val makes = findMakeByYear(year.value)
        DropDownComponent(title = "Make", suggestions = makes, onItemClick = {
            make = it
        })

        val modelos = findMakeByMake(make, year.value)
        DropDownComponent(title = "Model", suggestions = modelos, onItemClick = { models = it })

        TextButton(
            onClick = {
                val person = Person(
                    firstName = firstName.value,
                    lastName = lastName.value,
                    phone = phone.value,
                    year = year.value,
                    make = make,
                    model = models,
                    color = color.value,
                    plate = plate.value
                )
                viewModel.saveForm(person)
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(blackColor)
        ) {
            Text(
                text = "Save",
                style = TextStyle(
                    color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 15.sp
                ),
            )
        }

    }
}