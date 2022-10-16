package uz.gita.budget_app.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import uz.gita.budget_app.R
import uz.gita.budget_app.screens.intro.IntroScreen
import uz.gita.budget_app.screens.main.MainViewModel
import uz.gita.budget_app.screens.main.impl.MainViewModelImpl
import uz.gita.budget_app.screens.splash.impl.SplashViewModelImpl
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.ui.theme.White


class SplashScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        Splash()
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
        val logoAnimationState = animateLottieCompositionAsState(composition = composition)
        LottieAnimation(composition = composition, progress = logoAnimationState.progress)
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            val navigator = LocalNavigator.currentOrThrow
            navigator.replace(IntroScreen())
        }
    }
}


@Preview()
@Composable
fun SplashPreview() {
    BudgetAppTheme {

    }
}