package com.sopt.android3.presentation.yeseul

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.android3.R
import com.sopt.android3.core.designsystem.component.BottomBar
import com.sopt.android3.core.designsystem.component.LogoTopBar
import com.sopt.android3.core.designsystem.component.TextField
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

@Composable
fun YeseulRoute(
    navigateToSeohyun:() -> Unit,
    navigateToTehoon:() -> Unit,
    viewModel: YeseulViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            navigateToSeohyun()
            viewModel.resetUiState()
        }
    }

    YeseulScreen(
        navigateToSeohyun = navigateToSeohyun,
        navigateToTehoon = navigateToTehoon,
        onFormSubmit = { typedText ->
            viewModel.postMemory(typedText)
        },
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun YeseulScreen(
    modifier: Modifier = Modifier,
    navigateToSeohyun: () -> Unit = {},
    navigateToTehoon: () -> Unit = {},
    onFormSubmit: (String) -> Unit = {},
) {
    var text by remember { mutableStateOf("") }

    val isKeyboardVisible = WindowInsets.isImeVisible

    Box (
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        LogoTopBar(
            onClick = navigateToSeohyun,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .imePadding()
        ) {
            Text(
                text = "반가워요, 올해 여름\n잊고 싶은 기억이 있나요?",
                color = SopkathonTheme.colors.primary500,
                style = SopkathonTheme.typography.titleSB22,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = if (isKeyboardVisible) 100.dp else 250.dp)
            )

            TextField(
                label = "어떤 기억인가요?",
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                onSubmitClick = {
                    onFormSubmit(text)
                    text = ""
                    navigateToTehoon()
                }
            )

            Spacer(modifier = Modifier.height(
                if (isKeyboardVisible) {
                    10.dp
                } else {
                    100.dp
                }
            ))
        }

        if (!isKeyboardVisible) {
            BottomBar(
                onSelected = 1,
                onRightClick = navigateToTehoon,
                onLeftClick = {},
                modifier = Modifier.align(Alignment.BottomCenter),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun YeseulScreenPreview() {
    SopkathonTheme {
        YeseulScreen()
    }
}
