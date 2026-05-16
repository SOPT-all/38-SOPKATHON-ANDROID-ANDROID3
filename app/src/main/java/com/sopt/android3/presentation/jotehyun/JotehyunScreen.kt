package com.sopt.android3.presentation.jotehyun

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.android3.core.designsystem.component.BackTopBar
import com.sopt.android3.core.designsystem.component.BottomBar
import com.sopt.android3.core.designsystem.component.Button
import com.sopt.android3.core.designsystem.component.ButtonVariant
import com.sopt.android3.core.designsystem.component.TextField
import com.sopt.android3.core.designsystem.component.card.Card
import com.sopt.android3.core.designsystem.theme.SopkathonTheme
import com.sopt.android3.core.util.noRippleClickable
import com.sopt.android3.presentation.gominModel
import com.sopt.android3.presentation.tehoon.LongTabCard
import com.sopt.android3.presentation.tehoon.TehoonScreen
import com.sopt.android3.presentation.tehoon.TehoonUiState
import com.sopt.android3.presentation.tehoon.TehoonViewModel
import com.sopt.android3.presentation.tehoon.getServerImageResourceId


@Composable
fun JotehyunRoute(
    navigateToTehoon: () -> Unit,
    viewModel: TehoonViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    JotehyunScreen(
        uiState = uiState,
        onValueChange = { viewModel.onChangedValue(it) },
        navigateToTehoon = navigateToTehoon,
        postTehoon = { viewModel.tehoonPost() }
    )
}

@Composable
fun JotehyunScreen(
    uiState: TehoonUiState,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    navigateToTehoon: () -> Unit,
    postTehoon:() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.staticwhite)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = SopkathonTheme.colors.staticwhite),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            BackTopBar(
                onBackClick = { navigateToTehoon() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 20.dp),
                nickname = "익명 ${uiState.gomin.postId}",
                content = uiState.gomin.content,
                thumbnail = getServerImageResourceId(uiState.gomin.postId),
                hashtags = uiState.gomin.hashtags,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "길게 누르면 다음 기억으로 넘어가요",
                style = SopkathonTheme.typography.labelM12,
                color = SopkathonTheme.colors.gray400
            )

            Spacer(modifier = Modifier.height(17.dp))

            Button(
                text = "소각 도와주기",
                onClick = { }
            )

            Spacer(modifier = Modifier.height(70.dp))
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .imePadding()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(264.dp)
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(color = SopkathonTheme.colors.gray100),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        label = "어떤 공감의 말을 남기고 싶나요?",
                        value = uiState.textfieldText,
                        onValueChange = { onValueChange(it) }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            text = "취소",
                            onClick = { },
                            variant = ButtonVariant.SECONDARY,
                            modifier = Modifier
                                .height(46.dp)
                                .weight(1f)
                        )

                        Button(
                            text = "전하기",
                            onClick = {
                                postTehoon()
                                navigateToTehoon()
                            },
                            variant = ButtonVariant.PRIMARY,
                            modifier = Modifier
                                .height(46.dp)
                                .weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 720)
@Composable
private fun JotehyunScreenPreview() {
    SopkathonTheme {
        JotehyunScreen(
            uiState = TehoonUiState(
                gomin = gominModel(
                    postId = 1,
                    title = "프리뷰 고민",
                    content = "이제 프리뷰가 화면에 예쁘게 잘 보일 겁니다!",
                    hashtags = listOf("행복", "기쁨")
                ),
                isLoading = false,
                error = null,
                isSuccess = true
            ),
            navigateToTehoon = { },
            onValueChange = { },
            postTehoon = { },
        )
    }
}
