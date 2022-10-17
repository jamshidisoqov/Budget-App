package uz.gita.budget_app.screens.main.report.monthly.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.domain.*
import uz.gita.budget_app.screens.main.report.monthly.intent_uistate.M_R_Intents
import uz.gita.budget_app.screens.main.report.monthly.intent_uistate.M_R_UiState
import uz.gita.budget_app.screens.main.report.monthly.presenter.MonthlyReportViewModel
import uz.gita.budget_app.utils.returnDateAndThen
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MonthlyReportViewModelImpl @Inject constructor(
    val expansesUseCase: ExpansesUseCase,
    val incomeUseCase: IncomeUseCase,
    val calendarUseCase: CalendarUseCase,
    val categoryUseCase: CategoryUseCase,
    val balanceUseCase: BalanceUseCase
) : MonthlyReportViewModel, ViewModel() {

    var currentDate = Date()
    init {
        viewModelScope.launch {
            val month = returnDateAndThen()
            val currentMonth = month.first
            val nextMonth = month.second

            expansesUseCase.getAllExpansesByDate(currentMonth, nextMonth).collectLatest {

            }

            expansesUseCase.getExpansesSumByDate(currentMonth, nextMonth)
            incomeUseCase.getIncomesSumByDate(currentMonth, nextMonth)
        }
    }

    val uiState = M_R_UiState()
    override fun onEventDispatcher(intent: M_R_Intents) = intent {
        when (intent) {
            is M_R_Intents.CalendarNext -> //reduce
            {

            }
            is M_R_Intents.CalendarPrev -> //reduce
            {

            }
            is M_R_Intents.ReportTabSelected -> //reduce
            {

            }
        }
    }

    override val container: Container<M_R_UiState, Nothing> = container(uiState){
        getAllData()
    }

    private fun getAllData() = intent{
        viewModelScope.launch (Dispatchers.IO){
            val month = returnDateAndThen()
            val currentMonth = month.first
            val nextMonth = month.second
            var exList : List<java.io.Serializable> = emptyList()
            var inList : List<java.io.Serializable> = emptyList()
            var dayList : List<java.io.Serializable> = emptyList()

            currentDate = Date(currentMonth)
            val currentBalances = balanceUseCase.getCurrentBalance()

            expansesUseCase.getAllExpansesByDate(currentMonth, nextMonth).collectLatest {
                exList = it
            }
            incomeUseCase.getAllIncomeByDate(currentMonth,nextMonth).collectLatest {
                inList = it
            }



            val incomeAmount = incomeUseCase.getIncomesSumByDate(currentMonth, nextMonth)
            val expenseAmount = expansesUseCase.getExpansesSumByDate(currentMonth, nextMonth)
            var deltaExIn = incomeAmount - expenseAmount

            reduce { state.copy(incomeCount = incomeAmount.toLong()) }
            reduce { state.copy(expenseCount = expenseAmount.toLong()) }
            reduce { state.copy(currentBalance = currentBalances) }

            reduce {
                state.copy(previousBalance = currentBalances-deltaExIn.toFloat())
            }

            reduce {
                state.copy(monthData = SimpleDateFormat.getDateInstance().format("MMM dd, yyyy").format(currentDate))
            }
        }
    }
}