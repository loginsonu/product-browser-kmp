package com.sony.productbrowser.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sony.productbrowser.presentation.theme.AppColors
import com.sony.productbrowser.presentation.theme.AppTheme

@Composable
fun RatingView(
    rating: Double,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Rating",
            tint = AppColors.Rating
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )

    }

}

@Preview
@Composable
private fun RatingViewPreview() {

    AppTheme {

        RatingView(
            rating = 4.8
        )

    }

}