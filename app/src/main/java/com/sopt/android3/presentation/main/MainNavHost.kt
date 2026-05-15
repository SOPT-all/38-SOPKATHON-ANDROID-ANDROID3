package com.sopt.android3.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.android3.presentation.jotehyun.JotehyunRoute
import com.sopt.android3.presentation.seohyun.SeohyunRoute
import com.sopt.android3.presentation.tehoon.TehoonRoute
import com.sopt.android3.presentation.yeseul.YeseulRoute

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "tehoon",
        ) {
            composable(route = "tehoon") {
                TehoonRoute(
                    navigateToSeohyun = { navController.navigateToSeohyun() }
                )
            }

            composable(route = "seohyun") {
                SeohyunRoute(
                    navigateToYeseul = { navController.navigateToYeseul() }
                )
            }

            composable(route = "yeseul") {
                YeseulRoute(
                    navigateToJotehyun = { navController.navigateToJotehyun() }
                )
            }

            composable(route = "jotehyun") {
                JotehyunRoute(
                    navigateToTehoon = { navController.navigateToTehoon() },
                )
            }
        }
    }
}
