package uz.gita.budget_app.screens.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uz.gita.budget_app.R
import uz.gita.budget_app.screens.main.MainScreen
import uz.gita.budget_app.screens.main.input.CustomButtonView


class IntroScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        TabLayout()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {
    val coroutineScope = rememberCoroutineScope()
    val systemUiController: SystemUiController = rememberSystemUiController()
    val items: ArrayList<IntroData> = arrayListOf(
        IntroData(R.drawable.illustration1, R.string.onBoardingTitle1, R.string.onBoardingDesc1),
        IntroData(R.drawable.illustration2, R.string.onBoardingTitle2, R.string.onBoardingDesc2),
        IntroData(R.drawable.illustration3, R.string.onBoardingTitle3, R.string.onBoardingDesc3)
    )

    val pagerState =
        rememberPagerState(pageCount = items.size, initialOffscreenLimit = 2, initialPage = 0)


    OnBoardingPager(
        items = items,
        pagerState = pagerState,
        modifier = Modifier.fillMaxWidth(),
        coroutineScope
    )

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    items: List<IntroData>,
    pagerState: PagerState,
    modifier: Modifier,
    coroutineScope: CoroutineScope,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val navigator = LocalNavigator.currentOrThrow
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "${pagerState.currentPage + 1}/${items.size}")
            if (pagerState.currentPage + 1 < items.size) {
                OutlinedButton(
                    onClick = {
                        navigator.push(MainScreen())
                    },
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(text = "Skip")
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(500.dp)
        ) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Image(
                        painter = painterResource(id = items[page].image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = stringResource(items[page].title),//to get string resource
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(items[page].desc),//to get string resource
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }

                }
            }
        }
        if (pagerState.currentPage + 1 < items.size) {
            CustomButtonView(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = "Continue",
                onClick = { coroutineScope.launch { pagerState.scrollToPage(pagerState.currentPage + 1) } },
            )
        } else CustomButtonView(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = "Get started ",
            onClick = {
                navigator.replace(MainScreen())
            },
        )
    }
}

