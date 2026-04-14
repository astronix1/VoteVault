package com.example.votevault
import HomeScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    GlobalNavigation.navController = navController
//    val std = if(isLoggedIn) "homescreen" else "auth"
    val std = "auth"
    NavHost(navController = navController, startDestination = std) {
        composable("auth") {
            LoginScreen(
                modifier = modifier,
                // 1. Handle the standard ID/Email login
                onContinueClicked = { sovereignId ->
                    // If the login is successful, navigate to the homescreen:

                    /* if (isValidUser) { */
                    navController.navigate("homescreen") {
                        popUpTo("auth") { inclusive = true }
                    }
                    /* } */
                },
                onBiometricClicked = {


                    /* myBiometricManager.authenticate( onSuccess = { */
                    navController.navigate("homescreen") {
                        popUpTo("auth") { inclusive = true }
                    }
                    /* }) */
                }
            )
        }

        composable("homescreen"){
            HomeScreen(modifier)
        }

    }
}

object GlobalNavigation{
    lateinit var navController: NavHostController
}