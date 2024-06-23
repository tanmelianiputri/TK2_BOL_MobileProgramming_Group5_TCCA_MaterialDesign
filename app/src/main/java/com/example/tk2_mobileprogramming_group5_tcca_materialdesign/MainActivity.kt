package com.example.tk2_mobileprogramming_group5_tcca_materialdesign

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tk2_mobileprogramming_group5_tcca_materialdesign.ui.theme.GreenJC
import com.example.tk2_mobileprogramming_group5_tcca_materialdesign.ui.theme.TK2_MobileProgramming_Group5_TCCA_MaterialDesignTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TK2_MobileProgramming_Group5_TCCA_MaterialDesignTheme {
                Box(
                    modifier = Modifier
                    .fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController)
                }
            }
        }
    }
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello.. Please Log In",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Green
        )
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 26.dp, vertical = 140.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = { Text(text = "Username") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = GreenJC,
                unfocusedLeadingIconColor = GreenJC,
                focusedLabelColor = GreenJC,
                unfocusedLabelColor = GreenJC,
                focusedContainerColor = GreenJC,
                unfocusedContainerColor = GreenJC,
                focusedIndicatorColor = GreenJC,
                unfocusedIndicatorColor = GreenJC,
                unfocusedPlaceholderColor = GreenJC
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Username")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = GreenJC,
                unfocusedLeadingIconColor = GreenJC,
                focusedLabelColor = GreenJC,
                unfocusedLabelColor = GreenJC,
                focusedContainerColor = GreenJC,
                unfocusedContainerColor = GreenJC,
                focusedIndicatorColor = GreenJC,
                unfocusedIndicatorColor = GreenJC,
                unfocusedPlaceholderColor = GreenJC
            ), leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        
        Button(onClick = {
            if (authenticate(username, password)){
             onLoginSuccess()
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
            }
        }, colors = ButtonDefaults.buttonColors(GreenJC),
            contentPadding = PaddingValues(start = 60.dp, end = 60.dp, top = 8.dp),
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Text(text = "Login", fontSize = 22.sp)
        }
    }
}

private fun authenticate(username: String, password: String): Boolean{
    val validUsername = "pengguna"
    val validPassword = "masuk"
    return username == validUsername && password == validPassword
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "login" ) {
        composable("login"){
            LoginScreen(onLoginSuccess = {
                navController.navigate("home"){
                    popUpTo(0)
                }
            })
        }
        composable("home"){
            HomeScreen()
        }
    }
}

