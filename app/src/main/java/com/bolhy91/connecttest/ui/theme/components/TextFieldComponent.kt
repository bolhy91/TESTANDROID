package com.bolhy91.connecttest.ui.theme.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bolhy91.connecttest.ui.theme.inputColor

@Composable
fun TextFieldComponent(
    title: String,
    valueText: MutableState<String>,
    onChangeText: (String) -> Unit
) {
    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = valueText.value,
        onValueChange = {
                        valueText.value = it
            onChangeText(valueText.value)
            isError = valueText.value.isEmpty() || valueText.value.isBlank()
        },
        textStyle = TextStyle(fontSize = 18.sp),
        modifier = Modifier
            .fillMaxWidth()
            .background(inputColor),
        placeholder = {
            Text(
                text = title,
                style = TextStyle(color = Color.Black, fontSize = 18.sp)
            )
        },
        singleLine = true,
        isError = isError,
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    val test = remember { mutableStateOf("") }
    TextFieldComponent(title = "First Name", test, {})
}