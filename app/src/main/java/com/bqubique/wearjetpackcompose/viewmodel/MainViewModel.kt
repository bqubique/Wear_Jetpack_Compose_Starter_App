package com.bqubique.wearjetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

}