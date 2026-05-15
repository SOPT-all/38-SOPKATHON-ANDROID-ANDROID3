package com.sopt.android3.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class SopkathonColor(
    val black: Color,
    val white: Color
    // 요로코롬
)

val defaultSopkathonColor = SopkathonColor(
    black = Color(0xFF000000),
    white = Color(0xFFFFFFFF),
    // 요런식으로
)

val LocalSopkathonColor = staticCompositionLocalOf { defaultSopkathonColor }
