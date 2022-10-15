package uz.gita.budget_app.screens.intro

import uz.gita.budget_app.R

class OnBoardingItems(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object {
       fun getData():List<OnBoardingItems>{
           return listOf(
               OnBoardingItems(R.drawable.illustration1, R.string.onBoardingTitle1, R.string.onBoardingDesc1),
               OnBoardingItems(R.drawable.illustration2, R.string.onBoardingTitle2, R.string.onBoardingDesc2),
               OnBoardingItems(R.drawable.illustration3, R.string.onBoardingTitle3, R.string.onBoardingDesc3)
           )
       }
    }
}