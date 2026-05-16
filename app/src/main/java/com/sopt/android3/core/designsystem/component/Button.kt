package com.sopt.android3.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.core.designsystem.theme.LocalSopkathonTypography
import com.sopt.android3.core.designsystem.theme.SopkathonTheme
import com.sopt.android3.core.util.noRippleClickable

enum class ButtonVariant {
    PRIMARY,
    SECONDARY
}

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.PRIMARY,
) {
    val backgroundColor =
        if (variant == ButtonVariant.PRIMARY) SopkathonTheme.colors.primary500 else SopkathonTheme.colors.gray300

    Box(
        modifier = modifier
            .noRippleClickable(onClick)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(
                vertical = 12.dp,
                horizontal = 14.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = SopkathonTheme.colors.gray50,
            style = LocalSopkathonTypography.current.bodySB16
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ButtonPreview() {
    SopkathonTheme {
        Column(
            modifier = Modifier
                .padding(20.dp),
        ) {
            Button(
                text = "텍스트",
                onClick = {},
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    text = "텍스트",
                    onClick = {},
                    variant = ButtonVariant.SECONDARY,
                    modifier = Modifier.weight(1f)
                )
                Button(
                    text = "텍스트",
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}