package com.sopt.android3.presentation.tehoon

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.android3.R
import com.sopt.android3.core.designsystem.component.BottomBar
import com.sopt.android3.core.designsystem.component.Button
import com.sopt.android3.core.designsystem.component.LogoTopBar
import com.sopt.android3.core.designsystem.component.card.Card
import com.sopt.android3.core.designsystem.theme.SopkathonTheme
import com.sopt.android3.presentation.gominModel
import com.sopt.android3.presentation.tehoon.component.PressCard

@Composable
fun TehoonRoute(
    navigateToYeseul: () -> Unit,
    navigateToJotehyun: () -> Unit,
    navigateToSeohyun: () -> Unit,
    viewModel: TehoonViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    TehoonScreen(
        uiState = uiState,
        navigateToYeseul = navigateToYeseul,
        navigateToJotehyun = navigateToJotehyun,
        navigateToSeohyun = navigateToSeohyun,
        onLongClickAction = viewModel::changeToNextGomin
    )
}

@Composable
fun TehoonScreen(
    uiState: TehoonUiState,
    modifier: Modifier = Modifier,
    navigateToYeseul: () -> Unit = {},
    navigateToJotehyun: () -> Unit = {},
    navigateToSeohyun: () -> Unit = {},
    onLongClickAction: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.staticwhite),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        LogoTopBar(
            onClick = { navigateToSeohyun() },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        // TopBar와 BottomBar 사이의 모든 공간을 차지하는 컨테이너
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (uiState.isLoading) {
                // 로딩 중일 때는 인디케이터만 중앙에 표시
                CircularProgressIndicator(
                    color = SopkathonTheme.colors.gray400
                )
            } else {
                // 로딩이 완료되면 카드와 텍스트, 버튼을 표시
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        LongTabCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            nickname = "익명 ${uiState.gomin.postId}", // 실제 postId 사용 부분
                            content = uiState.gomin.content,
                            thumbnail = getServerImageResourceId(uiState.gomin.postId),
                            pressedTumbnail = getServerPressedImageResourceId(uiState.gomin.postId),
                            hashtags = uiState.gomin.hashtags,
                            onLongClickAction = onLongClickAction
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "길게 누르면 다음 기억으로 넘어가요",
                        style = SopkathonTheme.typography.labelM12,
                        color = SopkathonTheme.colors.gray400
                    )

                    Spacer(modifier = Modifier.height(17.dp))

                    Button(
                        text = "소각 도와주기",
                        onClick = { navigateToJotehyun() }
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }

        BottomBar(
            modifier = Modifier.fillMaxWidth(),
            onSelected = 0,
            onLeftClick = { navigateToYeseul() },
            onRightClick = { }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LongTabCard(
    modifier: Modifier = Modifier,
    nickname: String,
    content: String,
    @DrawableRes thumbnail: Int,
    @DrawableRes pressedTumbnail: Int,
    hashtags: List<String>,
    onLongClickAction: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = modifier.combinedClickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = {  },
            onLongClick = onLongClickAction
        )
    ) {
        if (isPressed) {
            PressCard(
                nickname = nickname,
                content = content,
                thumbnail = pressedTumbnail,
                hashtags = hashtags
            )
        } else {
            Card(
                nickname = nickname,
                content = content,
                thumbnail = thumbnail,
                hashtags = hashtags
            )
        }
    }
}

@DrawableRes
fun getServerImageResourceId(id: Int): Int {
    return when (id) {
        1 -> R.drawable.img_default_01
        2 -> R.drawable.img_default_02
        3 -> R.drawable.img_default_03
        4 -> R.drawable.img_default_01
        5 -> R.drawable.img_default_02
        6 -> R.drawable.img_default_03
        7 -> R.drawable.img_default_01
        8 -> R.drawable.img_default_02
        9 -> R.drawable.img_default_03
        10 -> R.drawable.img_default_01
        else -> R.drawable.img_default_01
    }
}

@DrawableRes
fun getServerPressedImageResourceId(id: Int): Int {
    return when (id) {
        1 -> R.drawable.img_pressed_01
        2 -> R.drawable.img_pressed_02
        3 -> R.drawable.img_pressed_03
        4 -> R.drawable.img_pressed_01
        5 -> R.drawable.img_pressed_02
        6 -> R.drawable.img_pressed_03
        7 -> R.drawable.img_pressed_01
        8 -> R.drawable.img_pressed_02
        9 -> R.drawable.img_pressed_03
        10 -> R.drawable.img_pressed_01
        else -> R.drawable.img_pressed_01
    }
}

@Preview(showBackground = true)
@Composable
private fun SeohyunScreenPreview() {
    SopkathonTheme {
        TehoonScreen(
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
            )
        )
    }
}
