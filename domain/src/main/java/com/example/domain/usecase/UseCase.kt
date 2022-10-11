package com.example.domain.usecase

import com.example.domain.common.Transformer
import io.reactivex.rxjava3.core.Observable

abstract class UseCase<T>(private val transformer: Transformer<T>) {

    abstract fun createObservable(data: Map<String, Any>? = null): Observable<T>

    fun observable(withData: Map<String, Any>? = null): Observable<T> {
        return createObservable(withData).compose(transformer)
    }

    companion object {
        const val PARAM_SEARCH_PAGE = "PARAM_SEARCH_PAGE"
    }
}
