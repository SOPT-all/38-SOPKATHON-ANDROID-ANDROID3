package com.sopt.android3.presentation.seohyun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import com.sopt.android3.R
import com.sopt.android3.core.designsystem.component.card.Card
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
    LazyColumn(
        modifier = modifier.padding(horizontal = 30.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = SopkathonTheme.colors.staticwhite)
            ) {
                Column(
                    modifier = Modifier.padding(top = 30.dp)
                ) {
                    Card(
                        nickname = "익명A",
                        content = "본문본문본문본문본문본문본문본문본문본문본문본문본문본문본문본문",
                        thumbnail = R.drawable.img_card,
                        hashtags = listOf("슬픔", "그리움"),
                        modifier = Modifier.height(486.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column {
                    Row {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(50.dp))
                                .background(Color.White)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(text = "작성자")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "댓글")
                        }
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
