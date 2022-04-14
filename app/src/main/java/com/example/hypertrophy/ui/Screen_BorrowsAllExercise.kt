package com.example.hypertrophy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import com.example.hypertrophy.R
import com.example.hypertrophy.model.network.ExerciseInfo
import com.example.hypertrophy.viewModel.ExercisesViewModel

@Composable
fun Screen_BorrowsAllExercise(exercisesViewModel: ExercisesViewModel) {

    var tabIndex by remember { mutableStateOf(0) }

    //todo should be replaced by viewModel variable
    val tabTitles = listOf("cardio", "back", "chest","lower arms","lower legs","neck","shoulders","upper arms","upper legs","waist")

    Scaffold {

        Column {

            ScrollableTabRow(selectedTabIndex = tabIndex) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = { Text(text = title) })
                }
            }
            TabContent(tabIndex,tabTitles,exercisesViewModel)
        }
    }
}

@Composable
fun TabContent(tabIndex:Int,tabTitles:List<String>,exercisesViewModel: ExercisesViewModel){

    var typeExpanded by remember { mutableStateOf(false) }


    Column {

        Row (horizontalArrangement = Arrangement.End){

            DropdownMenu(
                expanded = typeExpanded,
                onDismissRequest = { typeExpanded = false },
                modifier = Modifier,
            ) {}
        }

        LazyColumn(){

            items(exercisesViewModel.exerciseList.value){
                it ->
                exerciseInfoCard(exerciseInfo = it)
            }
        }
    }
}


@ExperimentalCoilApi
@Composable
fun exerciseInfoCard(exerciseInfo: ExerciseInfo){

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface
    ){
        Row(verticalAlignment = Alignment.CenterVertically){

            Image(
                modifier = Modifier
                    .size(150.dp),
                painter = rememberImagePainter(
                    data = exerciseInfo.gifUrl.substring(0,4) + "s" + exerciseInfo.gifUrl.substring(4),
                    builder = {
                        decoder(GifDecoder()) // gif decoder
                        placeholder(R.drawable.ic_launcher_foreground)
                        crossfade(true)
                    }),
                contentDescription = null
            )

            Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center){

                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {

                    Text(text = exerciseInfo.name)
                }

                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Targeted Body Part: ${exerciseInfo.bodyPart}")
                    Text(text = "Targeted Muscle: ${exerciseInfo.target}")
                    Text(text = "Equipment: ${exerciseInfo.equipment}")
                }
            }
        }
    }
}
