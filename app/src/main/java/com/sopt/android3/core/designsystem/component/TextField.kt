package com.sopt.android3.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

@Composable
fun TextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onSubmitClick: (() -> Unit)? = null
) {
    var isFocused by remember { mutableStateOf(false) }

    val borderColor = if (isFocused) {
        SopkathonTheme.colors.gray600
    } else {
        SopkathonTheme.colors.gray200
    }

    val backgroundColor = if (isFocused) {
        Color.Transparent
    } else {
        SopkathonTheme.colors.gray100
    }

    val inputTextStyle = if (value.isEmpty()) SopkathonTheme.typography.bodyR14.copy(
        SopkathonTheme.colors
            .gray500
    ) else SopkathonTheme.typography.bodyM14.copy(
        SopkathonTheme.colors
            .gray500
    )

    Column(
        modifier = modifier,
    ) {
        Text(
            text = label,
            color = SopkathonTheme.colors.gray700,
            style = SopkathonTheme.typography.bodyM14
        )

        Spacer(modifier = Modifier.height(6.dp))

        BasicTextField(
            value = value,
            onValueChange = {
                if (it.length <= 80) {
                    onValueChange(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged{ focusState ->
                    isFocused = focusState.isFocused
                },
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(backgroundColor)
                        .border(1.dp, borderColor, RoundedCornerShape(12.dp))
                        .padding(horizontal = 16.dp, vertical = 14.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (value.isEmpty()) {
                                Text(
                                    text = "입력해주세요",
                                    color = SopkathonTheme.colors.gray500,
                                    style = SopkathonTheme.typography.bodyR14
                                )
                            }
                            innerTextField()
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        Text(
                            text = "${value.length}/80",
                            color = SopkathonTheme.colors.gray400.copy(alpha = 0.6f),
                            style = SopkathonTheme.typography.bodyM14,
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }
                }
            },
            textStyle = inputTextStyle,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "메시지에 마침표를 찍으세요.",
                color = SopkathonTheme.colors.gray400,
                style = SopkathonTheme.typography.labelR12
            )

            if (onSubmitClick != null) {
                val isReady = value.isNotEmpty()

                Button(
                    text = "전송하기",
                    onClick = {
                        if (isReady) onSubmitClick()
                    },
                    variant = ButtonVariant.PRIMARY,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .graphicsLayer {
                            alpha = if (isReady) 1f else 0f
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldPreview() {
    SopkathonTheme {
        var text by remember { mutableStateOf("") }

        TextField(
            label = "어떤 기억인가요?",
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
        )
    }
}