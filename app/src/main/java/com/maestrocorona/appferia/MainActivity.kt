package com.maestrocorona.appferia

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita el diseño sin bordes en Android 13+
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                // Inicia la segunda actividad cuando se presiona el botón
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}

// 🎨 Definimos los colores de las tarjetas para modo claro y oscuro
private val Purple40 = Color(0xFF6650a4) // Modo claro
private val Purple80 = Color(0xFFD0BCFF) // Modo oscuro

// 🌟 Composable principal que muestra la lista de categorías
@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background // Fondo adaptado al tema del sistema
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado entre elementos
        ) {
            // Tarjetas de categorías
            BusinessItem("Negocios de la Nave 1")
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")
            BusinessItem("Atracciones y Concierto") // ✅ Nueva tarjeta añadida

            // Botón para ir a la segunda pantalla
            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes", fontFamily = FontFamily.SansSerif) // Fuente sans-serif aplicada
            }
        }
    }
}

// 📌 Composable reutilizable que representa una tarjeta con imagen y texto
@Composable
fun BusinessItem(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp), // Tamaño de la tarjeta
        colors = CardDefaults.cardColors(
            containerColor = Purple40, // Color de fondo de la tarjeta
            contentColor = Color.White // Color del texto
        ),
        shape = RoundedCornerShape(12.dp) // Bordes redondeados
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically // Centra los elementos en la fila
        ) {
            // Imagen del negocio
            Image(
                painter = painterResource(id = R.drawable.logo_rest),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            // Texto con fuente sans-serif
            Text(
                text = text,
                modifier = Modifier.padding(8.dp),
                fontFamily = FontFamily.SansSerif // Aplicando la fuente sans-serif
            )
        }
    }
}

// 🔍 @Preview permite ver la pantalla en Android Studio sin ejecutar la app
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(onNavigateToSecondActivity = {}) // Vista previa sin funcionalidad del botón
}

