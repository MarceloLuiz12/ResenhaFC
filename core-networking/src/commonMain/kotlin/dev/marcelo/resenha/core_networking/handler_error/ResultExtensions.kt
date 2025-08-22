package dev.marcelo.resenha.core_networking.handler_error

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch

fun <T> Flow<T>.catchFailure(action: suspend FlowCollector<T>.(NetWorkFailure) -> Unit): Flow<T> =
    catch {
        if(it is NetWorkFailure){
            action(it)
        }else{
            action(NetWorkFailure.GenericError())
        }
    }
