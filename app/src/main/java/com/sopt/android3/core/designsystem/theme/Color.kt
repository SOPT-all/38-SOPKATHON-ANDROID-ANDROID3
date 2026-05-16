package com.sopt.android3.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class SopkathonColor(
    val staticblack: Color,
    val staticwhite: Color,
    val primary500: Color,
    val primary100: Color,
    val subblue500: Color,
    val subred500: Color,
    val subred100: Color,
    val gray50: Color,
    val gray100: Color,
    val gray200: Color,
    val gray300: Color,
    val gray400: Color,
    val gray500: Color,
    val gray600: Color,
    val gray700: Color,
)

val defaultSopkathonColor = SopkathonColor(
    staticblack = Color(0xFF000000),
    staticwhite = Color(0xFFFFFFFF),
    primary500 = Color(0xFF534DFF),
    primary100 = Color(0xFFEFEEFF),
    subblue500 = Color(0xFF1F95FF),
    subred500 = Color(0xFFFF3C7E),
    subred100 = Color(0xFFFFD5E2),
    gray50 = Color(0xFFFAFBFB),
    gray100 = Color(0xFFF3F4F7),
    gray200 = Color(0xFFD2D6DB),
    gray300 = Color(0xFFB2B8C0),
    gray400 = Color(0xFF8E95A0),
    gray500 = Color(0xFF6D7683),
    gray600 = Color(0xFF505867),
    gray700 = Color(0xFF181E27),
)

val LocalSopkathonColor = staticCompositionLocalOf { defaultSopkathonColor }
