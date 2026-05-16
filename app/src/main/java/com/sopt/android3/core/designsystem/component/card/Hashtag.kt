package com.sopt.android3.core.designsystem.component.card

import android.R.attr.label
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.android3.core.designsystem.theme.LocalSopkathonTypography
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

@Composable
fun Hashtag(
    label: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(SopkathonTheme.colors.gray50)
            .padding(
                vertical = 4.dp,
                horizontal = 16.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = LocalSopkathonTypography.current.bodyM14,
            color = SopkathonTheme.colors.gray700
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HashTagPreview() {
    SopkathonTheme {
        Hashtag(label = "이별")
    }
}