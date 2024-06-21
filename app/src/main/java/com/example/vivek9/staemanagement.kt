package com.example.vivek9

import androidx.compose.runtime.Composable
 import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun statemanagement(){
    var State =remember{
        mutableStateOf("")
    }
    TextField(value=State.value,onValueChange={
State.value=it
    })

}


