package com.sopt.android3.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


object SopkathonTheme {
    val colors: SopkathonColor
        @Composable
        get() = LocalSopkathonColor.current

    val typography: SopkathonTypography
        @Composable
        get() = LocalSopkathonTypography.current
}

@Composable
fun ProvideSopkathonColorsAndTypography(
    colors: SopkathonColor,
    typography: SopkathonTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalSopkathonColor provides colors,
        LocalSopkathonTypography provides typography,
        content = content
    )
}

@Composable
fun SopkathonTheme(
    content: @Composable () -> Unit,
) {
    ProvideSopkathonColorsAndTypography(
        colors = defaultSopkathonColor,
        typography = defaultSopkathonTypography,
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }
        MaterialTheme(
            content = content
        )
    }
}
