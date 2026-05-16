package com.sopt.android3.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

@Composable
fun BackTopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    onProfileClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier,
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown, // 뒤로가기
                contentDescription = null,
            )
        }

        if (onProfileClick != null) {
            IconButton(
                onClick = onProfileClick,
                modifier = Modifier,
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle, // 내 기록
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun BackTopBarPreview() {
    SopkathonTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 프로필 버튼 없음
            BackTopBar(
                onBackClick = {},
            )
            // 프로필 버튼 있음
            BackTopBar(
                onBackClick = {},
                onProfileClick = {}
            )
        }
    }
}