package com.sopt.android3.core.designsystem.theme

import android.R.attr.fontFamily
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.sopt.android3.R

// 이 폰트 안쓸수도 잇으니 유의~ font 는 기본적으로 추가해놓은겁니다~!
val SopkathonRegularFont = FontFamily(Font(R.font.pretendard_regular))
val SopkathonMediumFont = FontFamily(Font(R.font.pretendard_medium))
val SopkathonBoldFont = FontFamily(Font(R.font.pretendard_bold))

@Immutable
data class SopkathonTypography(
    val title: TextStyle,
    val displayB30: TextStyle,
    val titleSB22: TextStyle,
    val titleSB18: TextStyle,
    val titleM18: TextStyle,
    val titleR18: TextStyle,
    val bodySB16: TextStyle,
    val bodyM16: TextStyle,
    val bodyR16: TextStyle,
    val bodySB14: TextStyle,
    val bodyM14: TextStyle,
    val bodyR14: TextStyle,
    val labelM12: TextStyle,
    val labelR12: TextStyle,
    val captionR10: TextStyle
)

val defaultSopkathonTypography = SopkathonTypography(
    title = TextStyle(
        fontFamily = SopkathonRegularFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    displayB30 = TextStyle(
        fontFamily = SopkathonBoldFont,
        fontWeight = FontWeight.W700,
        fontSize = 30.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.01).em
    ),
    titleSB22 = TextStyle(
        fontFamily = SopkathonBoldFont,
        fontWeight = FontWeight.W700,
        fontSize = 18.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.01).em
    ),
    titleSB18 = TextStyle(
        fontFamily = SopkathonBoldFont,
        fontWeight = FontWeight.W700,
        fontSize = 18.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.01).em
    ),
    titleM18 = TextStyle(
        fontFamily = SopkathonMediumFont,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.01).em
    ),
    titleR18 = TextStyle(
        fontFamily = SopkathonRegularFont,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.01).em
    ),

    bodySB16 = TextStyle(
        fontFamily = SopkathonBoldFont,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),
    bodyM16 = TextStyle(
        fontFamily = SopkathonMediumFont,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),
    bodyR16 = TextStyle(
        fontFamily = SopkathonRegularFont,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),
    bodySB14 = TextStyle(
        fontFamily = SopkathonBoldFont,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),
    bodyM14 = TextStyle(
        fontFamily = SopkathonMediumFont,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),
    bodyR14 = TextStyle(
        fontFamily = SopkathonRegularFont,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),

    labelM12 = TextStyle(
        fontFamily = SopkathonMediumFont,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),
    labelR12 = TextStyle(
        fontFamily = SopkathonRegularFont,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    ),

    captionR10 = TextStyle(
        fontFamily = SopkathonRegularFont,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp,
        lineHeight = 1.4.em,
        letterSpacing = (-0.02).em
    )
)

val LocalSopkathonTypography = staticCompositionLocalOf { defaultSopkathonTypography }
