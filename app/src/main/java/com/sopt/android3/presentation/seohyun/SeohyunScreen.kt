package com.sopt.android3.presentation.seohyun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.android3.R
import com.sopt.android3.core.designsystem.component.BackTopBar
import com.sopt.android3.core.designsystem.component.card.Hashtag
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
    viewModel: SeohyunViewModel = SeohyunViewModel(),
    navigateToYeseul: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column {
        BackTopBar(onBackClick = { navigateToYeseul() })

        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = modifier.padding(horizontal = 30.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = SopkathonTheme.colors.staticwhite)
            ) {
                SeohyunCard(
                    content = uiState.posts.firstOrNull()?.content ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(486.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = SopkathonTheme.colors.gray100,
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_card),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(100.dp))
                            .size(60.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(text = "작성자")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "댓글")
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
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

@Composable
private fun SeohyunCard(
    content: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_card),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .matchParentSize()
                .background(color = Color.Black.copy(alpha = 0.73f))
                .padding(vertical = 30.dp, horizontal = 26.dp),
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Hashtag(label = "3일 전의 고민")
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

@Preview(showBackground = true)
@Composable
private fun SeohyunScreenPreview() {
    SopkathonTheme {
        SeohyunScreen()
    }
}
