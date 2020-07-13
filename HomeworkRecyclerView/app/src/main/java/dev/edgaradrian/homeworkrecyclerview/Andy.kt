package dev.edgaradrian.homeworkrecyclerview

import java.util.*

data class Andy(val id: UUID = UUID.randomUUID(),
                var name: String = "",
                var job: String = "",
                var type: AndyType = AndyType.NONE
                ) {

}