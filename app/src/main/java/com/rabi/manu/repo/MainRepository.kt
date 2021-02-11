package com.rabi.manu.repo

import com.rabi.manu.model.Card
import com.rabi.manu.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository {

    suspend fun getCards(): Flow<DataState<List<Card>>> = flow {
        emit(DataState.Loading)
        try{
            val data = Data().get()
            emit(DataState.Success(data))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}