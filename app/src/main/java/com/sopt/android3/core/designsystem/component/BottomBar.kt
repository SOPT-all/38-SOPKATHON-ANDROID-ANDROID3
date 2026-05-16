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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.R
import com.sopt.android3.core.designsystem.theme.SopkathonTheme
import com.sopt.android3.core.util.noRippleClickable

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onSelected: Int, //1 = 왼쪽 셀렉 / 0 = 오른쪽 셀렉(색깔지정)
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
                    imageVector = ImageVector.vectorResource(R.drawable.ic_nav_write),
                    contentDescription = null,
                    tint = if(onSelected == 0) SopkathonTheme.colors.gray400 else SopkathonTheme.colors.staticblack
                )

                Text(
                    text = "망각하기",
                    style = SopkathonTheme.typography.labelM12,
                    color = if(onSelected == 0) SopkathonTheme.colors.gray400 else SopkathonTheme.colors.staticblack
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
                    imageVector = ImageVector.vectorResource(R.drawable.ic_nav_trash),
                    contentDescription = null,
                    tint = if(onSelected == 1) SopkathonTheme.colors.gray400 else SopkathonTheme.colors.staticblack
                )

                Text(
                    text = "소각해주기",
                    style = SopkathonTheme.typography.labelM12,
                    color = if(onSelected == 1) SopkathonTheme.colors.gray400 else SopkathonTheme.colors.staticblack
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
                onSelected = 0,
                onLeftClick = {},
                onRightClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            BottomBar(
                modifier = Modifier,
                onSelected = 1,
                onLeftClick = {},
                onRightClick = {}
            )
        }
    }
}
