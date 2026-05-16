package com.sopt.android3.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.core.designsystem.theme.SopkathonTheme
import com.sopt.android3.core.util.noRippleClickable

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.noRippleClickable(onClick = onLeftClick)
                .weight(1f)
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Home, // 뒤로가기
                    contentDescription = null,
                )

                Text(
                    text = "망각하기",
                )
            }
        }

        Box(
            modifier = Modifier.noRippleClickable(onClick = onRightClick)
                .weight(1f)
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = null,
                )

                Text(
                    text = "소각해주기",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomBarPreview() {
    SopkathonTheme {
        Column() {
            BottomBar(
                modifier = Modifier,
                onLeftClick = {},
                onRightClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            BottomBar(
                modifier = Modifier,
                onLeftClick = {},
                onRightClick = {}
            )
        }
    }
}
