package com.sopt.android3.presentation.seohyun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
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
    viewModel: SeohyunViewModel = viewModel(),
    navigateToYeseul: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // 전체 배경을 staticwhite로
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.staticwhite)
    ) {
        BackTopBar(onBackClick = { navigateToYeseul() })

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "나의 기억",
                style = SopkathonTheme.typography.titleSB22,
                color = SopkathonTheme.colors.staticblack
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                "소각은 7개의 마음이 닿으면 할 수 있어요",
                style = SopkathonTheme.typography.bodyR14,
                color = SopkathonTheme.colors.staticblack
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.error != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = uiState.error ?: "오류가 발생했습니다",
                        color = SopkathonTheme.colors.staticblack,
                        style = SopkathonTheme.typography.bodyR14
                    )
                }
            }

            else -> {
                // 번들 간 간격은 LazyColumn spacedBy 하나로만 관리
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(23.dp)
                ) {
                    items(uiState.posts, key = { it.postId }) { post ->
                        PostBundle(post = post)
                    }
                    item { Spacer(modifier = Modifier.height(10.dp)) }
                }
            }
        }
    }
}

@Composable
private fun PostBundle(
    post: PostUiModel,
    modifier: Modifier = Modifier,
) {
    // 번들 내부 아이템 간격: 10dp
    // 버튼 → 다음 카드 간격은 LazyColumn의 spacedBy(32dp)만 적용 (중복 없음)
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SeohyunCard(
            content = post.content,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(320.dp)
                .aspectRatio(320f / 229f)
        )

        post.reactions.forEach { reaction ->
            ReactionCard(
                reaction = reaction,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {},
                modifier = Modifier.weight(1f).heightIn(46.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SopkathonTheme.colors.gray300
                )
            ) {
                Text(
                    text = "남겨 놓기",
                    style = SopkathonTheme.typography.bodySB16,
                    color = SopkathonTheme.colors.gray100
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {},
                modifier = Modifier.weight(1f).heightIn(46.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SopkathonTheme.colors.primary500
                )
            ) {
                Text(
                    text = "소각하기",
                    style = SopkathonTheme.typography.bodySB16,
                    color = SopkathonTheme.colors.gray50
                )
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
                Hashtag(label = "3일 전의 기억")
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

@Composable
private fun ReactionCard(
    reaction: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .heightIn(68.dp)
            .aspectRatio(320f / 68f)
            .background(color = SopkathonTheme.colors.gray100, RoundedCornerShape(10.dp))
            .padding(horizontal = 20.dp, vertical = 16.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.img_logo_header),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .size(36.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                "TODO: 사용자 더미 데이터",
                style = SopkathonTheme.typography.labelM12,
                color = SopkathonTheme.colors.gray700
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                reaction,
                style = SopkathonTheme.typography.labelM12,
                color = SopkathonTheme.colors.gray600
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