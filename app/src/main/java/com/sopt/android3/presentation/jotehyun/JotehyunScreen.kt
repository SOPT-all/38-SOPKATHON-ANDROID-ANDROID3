package com.sopt.android3.presentation.jotehyun

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
fun JotehyunRoute(
    navigateToTehoon: () -> Unit
) {
    JotehyunScreen(
        navigateToTehoon = navigateToTehoon,
    )
}

@Composable
fun JotehyunScreen(
    modifier: Modifier = Modifier,
    navigateToTehoon: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
    ) {
        Text(
            text = "Jotehyun Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToTehoon)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun JotehyunScreenPreview() {
    SopkathonTheme {
        JotehyunScreen()
    }
}
