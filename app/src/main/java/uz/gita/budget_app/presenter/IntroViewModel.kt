package uz.gita.budget_app.presenter

import uz.gita.budget_app.utils.AppViewModel

interface IntroScreenViewModel : AppViewModel<Intent, Unit, Nothing>

sealed interface Intent {

    object OpenMain : Intent
}