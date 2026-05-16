package com.sopt.android3.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.android3.core.designsystem.theme.SopkathonTheme

@Composable
fun LogoTopBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Filled.Home, // 로고
            contentDescription = null,
            modifier = Modifier.padding(start = 20.dp)
        )

        IconButton(
            onClick = onClick,
            modifier = Modifier,
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle, // 내 기록
                contentDescription = null,
                modifier = Modifier.padding(end = 17.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun LogoTopBarPreview() {
    SopkathonTheme {
        LogoTopBar(
            onClick = {}
        )
    }
}