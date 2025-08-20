package com.example.practicalwork.uiScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.practicalwork.R
import com.example.practicalwork.data.RouteData

@Composable
fun InfoBlock(route: RouteData, onFavoriteClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .background(color = colorResource(R.color.teal_200), shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Depart", style = MaterialTheme.typography.labelMedium)
                Text("${route.depart.iata_code}  ${route.depart.name}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Arrival", style = MaterialTheme.typography.labelMedium)
                Text("${route.arrive.iata_code}  ${route.arrive.name}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Passengers: ${route.depart.passengers}", style = MaterialTheme.typography.bodySmall)
            }

            IconButton(onClick = onFavoriteClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Add to favorite",
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}
