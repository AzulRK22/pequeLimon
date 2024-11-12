package com.example.pequelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import com.example.pequelemon.ui.theme.LittleLemonYellow
import com.example.pequelemon.ui.theme.LittleLemonGreen
import com.example.pequelemon.ui.theme.WhiteText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpperPanel(
    searchPhrase: String,
    onSearchPhraseChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LittleLemonGreen)
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonYellow
        )
        Text(
            text = stringResource(id = R.string.location),
            fontSize = 24.sp,
            color = WhiteText
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                style = MaterialTheme.typography.bodyMedium,
                color = WhiteText,
                modifier = Modifier
                    .padding(bottom = 28.dp, end = 20.dp)
                    .fillMaxWidth(0.6f)
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(LittleLemonGreen)
            )
        }

        // Barra de búsqueda en lugar del botón
        TextField(
            value = searchPhrase,
            onValueChange = onSearchPhraseChange,
            placeholder = { Text("Introduce frase de búsqueda") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(5.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LittleLemonYellow,
                unfocusedContainerColor = LittleLemonYellow,
                focusedTextColor = LittleLemonGreen,
                unfocusedTextColor = LittleLemonGreen
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    var searchPhrase by remember { mutableStateOf("") }
    UpperPanel(
        searchPhrase = searchPhrase,
        onSearchPhraseChange = { searchPhrase = it }
    )
}
