package com.example.translator.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.translate.domain.history.HistoryDataSource
import com.example.translator.translate.domain.translate.Translate
import com.example.translator.translate.presentation.TranslateEvent
import com.example.translator.translate.presentation.TranslateViewModel

class AndroidTranslateViewModel(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
): ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translate = translate,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}