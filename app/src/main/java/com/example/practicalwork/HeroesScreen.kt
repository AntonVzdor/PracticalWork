package com.example.practicalwork

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.dataSource.HeroesRepository.heroes
import com.example.practicalwork.model.SuperHero
import com.example.practicalwork.ui.theme.PracticalWorkTheme

@Composable
fun HeroesList(){

}

@Composable
fun HeroListItem(heroes: SuperHero, modifier: Modifier = Modifier){
    Card {
        Row {
            Column(
                modifier = modifier
                    .padding(all = 16.dp)
            ) {
                Text(text = stringResource(id = heroes.stringNameRes))
                Text(text = stringResource(id = heroes.stringDescribeRes))
            }
            Box {
                Image(
                    painter = painterResource(id = heroes.paint),
                    contentDescription = null
                )
            }
        }
}
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SuperHeroesPreview() {

    PracticalWorkTheme {

    }
}
