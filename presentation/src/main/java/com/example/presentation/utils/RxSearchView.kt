package com.example.presentation.utils

import androidx.appcompat.widget.SearchView
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

object RxSearchView {
    fun fromSearchView(@NonNull searchView: SearchView, onSubmit: () -> Unit): Observable<String> {

        val subject: BehaviorSubject<String> = BehaviorSubject.create()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                subject.onComplete()
                onSubmit()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                println("lenght ${newText?.length}")
                subject.onNext(newText)
                return true
            }
        })
        return subject
    }
}
