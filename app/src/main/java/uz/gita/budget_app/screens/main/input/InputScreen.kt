package uz.gita.budget_app.screens.main.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import uz.gita.budget_app.ui.theme.BrandingColor
import uz.gita.budget_app.ui.theme.GrayDark

// Created by Jamshid Isoqov an 10/15/2022
class InputScreen : AndroidScreen() {
    @OptIn(ExperimentalPagerApi::class)
    @Composable
    override fun Content() {
        val pagerState = rememberPagerState(2)
    }
}

@ExperimentalPagerApi
@Composable
fun InputScreenContent() {
    val pagerState = rememberPagerState(2)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
            Tabs(pagerState = pagerState)
        }
        Box(modifier =Modifier.fillMaxWidth().weight(1f)) {
            Pager(pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Pager(pagerState: PagerState) {

        HorizontalPager(state = pagerState) {
            when (this.currentPage) {
                0 -> {

                }
                1 -> {

                }
            }
        }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf("Active", "Completed")
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = BrandingColor,
        modifier = Modifier.background(Color.Blue),
        indicator = { _ ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions = listOf()),
                height = 2.dp,
                color = BrandingColor
            )
        }
    ) {

        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) BrandingColor
                        else GrayDark
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun InputScreenPreview() {
    InputScreenContent()
}