package com.sopt.android3.presentation.seohyun

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
fun SeohyunRoute(
    navigateToYeseul: () -> Unit
) {
    SeohyunScreen(
        navigateToYeseul = navigateToYeseul,
    )
}

@Composable
fun SeohyunScreen(
    modifier: Modifier = Modifier,
    navigateToYeseul: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.gray400
            )
    ) {
        Text(
            text = "Seohyun Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToYeseul)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SeohyunScreenPreview() {
    SopkathonTheme {
        SeohyunScreen()
    }
}
