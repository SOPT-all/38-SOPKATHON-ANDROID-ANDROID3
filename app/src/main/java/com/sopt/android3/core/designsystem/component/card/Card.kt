package com.sopt.android3.core.designsystem.component.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.R
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

@Composable
fun Card(
    nickname: String,
    content: String,
    @DrawableRes thumbnail: Int,
    hashtags: List<String>,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = thumbnail),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .matchParentSize()
                .padding(
                    vertical = 30.dp,
                    horizontal = 26.dp,
                ),
        ) {
            Text(
                text = "${nickname}의 소거하고 싶은 고민",
                color = SopkathonTheme.colors.gray100,
                style = SopkathonTheme.typography.labelM12
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                hashtags.forEach { tag ->
                    Hashtag(label = tag)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = content,
                color = SopkathonTheme.colors.gray100,
                style = SopkathonTheme.typography.titleM18
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun CardPreview() {
    SopkathonTheme {
        Card(
            nickname = "익명A",
            content = "본문본문본문본문본문본문본문본문본문본문본문본문본문본문본문본문",
            thumbnail = R.drawable.img_card,
            hashtags = listOf("슬픔", "그리움"),
            modifier = Modifier.height(486.dp)
        )
    }
}
