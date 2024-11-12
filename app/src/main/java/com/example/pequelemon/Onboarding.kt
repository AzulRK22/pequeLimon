package com.example.pequelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun OnboardingScreen(navController: NavHostController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
                .padding(top = 10.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título
        Text(
            text = "Let's get to know you",
            style = MaterialTheme.typography.displaySmall,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF4A5A3D))
                .padding(vertical = 16.dp),
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Título de Información personal alineado a la izquierda
        Text(
            text = "Personal Information",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho
                .padding(vertical = 8.dp), // Espacio superior e inferior
            textAlign = TextAlign.Start // Alinea a la izquierda
        )

        // Campo de Nombre
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Apellido
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Correo Electrónico
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de Registro
        Button(
            onClick = {
                if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
                    Toast.makeText(context, "Registration failed. Please enter all data.", Toast.LENGTH_SHORT).show()
                } else {
                    saveToSharedPreferences(context, firstName, lastName, email)
                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
                    navController.navigate(Home2.route) // Navigate to Home screen
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4D35E)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Register", color = Color.Black)
        }
    }
}

fun saveToSharedPreferences(context: Context, firstName: String, lastName: String, email: String) {
    val sharedPref = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    with(sharedPref.edit()) {
        putString("first_name", firstName)
        putString("last_name", lastName)
        putString("email", email)
        apply()
    }
}