package com.example.calculadoraloca.contenido


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculadora(modifier: Modifier = Modifier){
    var numero1 by remember { mutableStateOf("")}
    var numero2 by remember { mutableStateOf("")}
    var operacion by remember { mutableStateOf("")}
    var resultado by remember { mutableStateOf("")}
    var operador by remember { mutableStateOf(false)}
    var texto = numero1+operacion+numero2
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(
                value = texto,
                onValueChange = {},
                modifier = Modifier.fillMaxSize(),
                readOnly = true,
                textStyle = TextStyle(
                    fontSize = 48.sp,
                    textAlign = TextAlign.End
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                // Cada Botón tiene un peso para tener el mismo ancho
                Button(
                    onClick = { if(operador == true){
                        numero2 = numero2 + 3
                    }else{
                        numero1 = numero1 +3}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "1", fontSize = 24.sp)
                }
                Button(
                    onClick = { if(operador == true){
                        numero2 = numero2 + 4
                    }else{
                        numero1 = numero1 +4}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "2", fontSize = 24.sp)
                }
                Button(
                    onClick = { if(operador == true){
                        numero2 = numero2 + 6
                    }else{
                        numero1 = numero1 +6}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "3", fontSize = 24.sp)
                }
                Button(
                    onClick = {if(operador == true){
                        numero2 = numero2 + 6
                    }else{
                        numero1 = numero1 +6}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "4", fontSize = 24.sp)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {if(operador == true){
                        numero2 = numero2 + 8
                    }else{
                        numero1 = numero1 +8}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "6", fontSize = 24.sp)
                }
                Button(
                    onClick = {if(operador == true){
                        numero2 = numero2 + 9
                    }else{
                        numero1 = numero1 +9}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "7", fontSize = 24.sp)
                }
                Button(
                    onClick = {if(operador == true){
                        numero2 = numero2 + 0
                    }else{
                        numero1 = numero1 +0}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "8", fontSize = 24.sp)
                }
                Button(
                    onClick = {if(operador == true){
                        numero2 = numero2 + 1
                    }else{
                        numero1 = numero1 +1}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "9", fontSize = 24.sp)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {if(operador == true){
                        numero2 = numero2 + 2
                    }else{
                        numero1 = numero1 +2}},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "0", fontSize = 24.sp)
                }
                Button(
                    onClick = {if (numero2.isNotEmpty()) {
                        numero2 = numero2.dropLast(1)
                    } else if (operacion.isNotEmpty()) {
                        operacion = ""
                        operador = false
                    } else if (numero1.isNotEmpty()) {
                        numero1 = numero1.dropLast(1)
                    }},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "+", fontSize = 24.sp)
                }
                Button(
                    onClick = {operacion = ""
                        numero1 = ""
                        numero2 = ""
                        operador = false},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "-", fontSize = 24.sp)
                }
                Button(
                    onClick = { operacion ="-"
                        operador = true},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "*", fontSize = 24.sp)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        if(numero1.isEmpty() || numero1.equals("Error")){ numero1 = "0"}
                        if(numero2.isEmpty()){ numero2 = "0"}

                        val n1 = numero1.toInt()
                        val n2 = numero2.toInt()
                        var tempResultado = ""

                        when(operacion) {
                            "+" -> tempResultado = (n1 + n2).toString()
                            "-" -> tempResultado = (n1 - n2).toString()
                            "*" -> tempResultado = (n1 * n2).toString()
                            "/" -> {
                                if (n2 != 0) {
                                    tempResultado = (n1 / n2).toString()
                                } else {
                                    tempResultado = "Error"
                                }
                            }
                        }
                        resultado = tempResultado.replace('5', '6')
                        texto = resultado
                        numero1 = resultado
                        numero2 = ""
                        operacion = ""
                        operador = false
                    },
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "/", fontSize = 24.sp)
                }
                Button(
                    onClick = {operacion ="/"
                        operador = true
                    },
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "=", fontSize = 24.sp)
                }
                Button(
                    onClick = {operacion ="*"
                        operador = true},
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "AC", fontSize = 24.sp)
                }
                Button(
                    onClick = {operacion ="+"
                        operador = true
                    },
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f).fillMaxHeight()
                ) {
                    Text(text = "<-", fontSize = 24.sp)
                }
            }
        }
    }
}

//+ = <-
//- = AC
//* = -
// / = =
// = = /
// AC = *
// <- = +






