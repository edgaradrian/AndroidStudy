package dev.edgaradrian.homeworkrecyclerview

import androidx.lifecycle.ViewModel

class AndyListViewModel: ViewModel() {

    val andys = mutableListOf<Andy>()

    init {
        for (type in AndyType.values()) {
            val andy = Andy()
            andy.name = type.name
            andy.job = "Android Developer"
            andy.type = type
            andys += andy
        }
    }

}//AndyListViewModel