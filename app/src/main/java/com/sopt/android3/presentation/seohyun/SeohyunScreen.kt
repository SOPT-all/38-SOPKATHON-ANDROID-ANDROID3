package com.sopt.android3.presentation.seohyun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.R
import com.sopt.android3.core.designsystem.component.BackTopBar
import com.sopt.android3.core.designsystem.component.card.Card
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

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
    Column() {
        BackTopBar(
            onBackClick = { navigateToYeseul() }
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = modifier.padding(horizontal = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = SopkathonTheme.colors.staticwhite)
            ) {
                Card(
                    nickname = "익명A",
                    content = "본문본문...",
                    thumbnail = R.drawable.img_card,
                    hashtags = listOf("슬픔", "그리움"),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(486.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row() {
                    Image(
                        painterResource(R.drawable.img_card),
                        contentDescription = null,
                        modifier = Modifier.clip(shape = RoundedCornerShape(50.dp)).size(30.dp)
                    )
                    Column {
                        Text(text = "작성자")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "댓글")
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Button(onClick = {}) {
                        Text(text = "남겨 놓기")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = navigateToYeseul) {
                        Text(text = "소각하기")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SeohyunScreenPreview() {
    SopkathonTheme {
        SeohyunScreen()
    }
}
