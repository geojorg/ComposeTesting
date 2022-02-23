package com.geojorgco.composetesting

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NumberPadScreen() {
    val passcodeLength = 6
    val focusRequesters = remember {
        (0 until passcodeLength).map { FocusRequester() }
    }
    val digits = remember {
        mutableStateListOf(
            *((0 until passcodeLength).map { "" }.toTypedArray())
        )
    }
    Box(Modifier.fillMaxSize()) {
        Row(Modifier.align(Alignment.Center)) {
            for (i in 0 until passcodeLength) {
                TextField(
                    value = digits[i],
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            digits[i] = it
                            if (digits[i].isBlank() && i > 0) {
                                focusRequesters[i - 1].requestFocus()
                            } else if (it.length == 2 && i < passcodeLength - 1) {
                                focusRequesters[i + 1].requestFocus()
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(2.dp)
                        .width(50.dp)
                        .focusOrder(focusRequesters[i])
                        .onKeyEvent { event ->
                            if (event.type == KeyEventType.KeyUp
                                && event.key == Key.Backspace
                                && digits[i].isEmpty()
                                && i > 0
                            ) {
                                focusRequesters[i - 1].requestFocus()
                                digits[i - 1] = ""
                                true
                            } else {
                                false
                            }
                        },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done,
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(fontSize = 14.sp)
                )
            }
        }
    }
}