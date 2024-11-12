package com.example.pequelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // Recupera la información del usuario
    val firstName = sharedPreferences.getString("first_name", "N/A") ?: "N/A"
    val lastName = sharedPreferences.getString("last_name", "N/A") ?: "N/A"
    val email = sharedPreferences.getString("email", "N/A") ?: "N/A"

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

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar la información personal
        Text(text = "Nombre: $firstName", fontSize = 18.sp, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "Apellido: $lastName", fontSize = 18.sp, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = "Correo electrónico: $email", fontSize = 18.sp, modifier = Modifier.padding(vertical = 4.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de Logout
        Button(
            onClick = {
                Toast.makeText(context, "Logout successful", Toast.LENGTH_SHORT).show()
                navController.navigate(Onboarding.route) // Navegar a la pantalla de Onboarding
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4D35E)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Logout", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    // Usar un controlador de navegación simulado para la vista previa
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}