package com.sopt.android3.presentation.yeseul

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.android3.core.designsystem.theme.SopkathonTheme
import com.sopt.android3.core.util.noRippleClickable

@Composable
fun YeseulRoute(
    navigateToJotehyun: () -> Unit
) {
    YeseulScreen(
        navigateToJotehyun = navigateToJotehyun,
    )
}

@Composable
fun YeseulScreen(
    modifier: Modifier = Modifier,
    navigateToJotehyun: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.gray400
            )
    ) {
        Text(
            text = "Yeseul Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToJotehyun)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SeohyunScreenPreview() {
    SopkathonTheme {
        YeseulScreen()
    }
}
