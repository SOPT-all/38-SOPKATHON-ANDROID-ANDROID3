package com.sopt.android3.core.designsystem.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

@Composable
fun Card(
    nickname: String,
    title: String,
    content: String,
//    @DrawableRes thumbnail: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
    ) {
//        Image(
//            painter = painterResource(id = thumbnail),
//            contentDescription = null,
//            modifier = Modifier.matchParentSize(),
//            contentScale = ContentScale.Crop
//        )

        Column(
            modifier = Modifier
                .background(Color.Gray)
                .padding(
                    vertical = 30.dp,
                    horizontal = 26.dp,
                ),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "${nickname}의 소거하고 싶은 고민",
                color = Color.White,
                fontSize = 12.sp,
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Hashtag(label = "슬픔")
                Hashtag(label = "그리움")
            }

            Text(
                text = title,
            )

            Text(
                text = content,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CardPreview() {
    SopkathonTheme {
        Card(
            nickname = "익명A",
            title = "전남친과 헤어졌는데 너무 슬프다",
            content = "본문본문본문본문본문본문본문본문본문본문본문본문본문본문본문본문",
            modifier = Modifier.height(320.dp)
        )
    }
}