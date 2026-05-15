package com.sopt.android3.presentation.tehoon

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
fun TehoonRoute(
    navigateToSeohyun: () -> Unit
) {
    TehoonScreen(
        navigateToSeohyun = navigateToSeohyun,
    )
}

@Composable
fun TehoonScreen(
    modifier: Modifier = Modifier,
    navigateToSeohyun: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
    ) {
        Text(
            text = "Tehoon Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToSeohyun)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SeohyunScreenPreview() {
    SopkathonTheme {
        TehoonScreen()
    }
}
