package com.example.thevetapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thevetapp2.ui.theme.TheVetApp2Theme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheVetApp2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VetNav()
                }
            }
        }
    }
}

@Composable
fun VetNav(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ){
        composable ("login"){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                login(
                    homeInterface = {
                        navController.navigate("homeInterface")
                    },
                    registerInterface = {
                        navController.navigate("registerInterface")
                    }
                )
                //TODO
            }
        }
        composable ("registerInterface"){
            registerInterface()
        }
        composable("homeInterface"){
            homeInterface()
        }
    }
}

@Composable
fun login(
    homeInterface: () -> Unit,
    registerInterface: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Vet App")


        Button(
            onClick = homeInterface
        ) {
            Text("Login")
        }
        Button(
            onClick = registerInterface
        ){
            Text("Register")
        }
    }
}

@Composable
fun registerInterface(

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the registration page")
    }
}

@Composable
fun homeInterface(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text ("This is the Home Page")

        Button(
            onClick = { /*TODO*/ }) {
            Text("Register new Pet")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheVetApp2Theme {
        VetNav()
    }
}