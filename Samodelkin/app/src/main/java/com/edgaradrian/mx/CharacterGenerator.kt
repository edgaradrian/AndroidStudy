package com.edgaradrian.mx

private fun <T> List<T>.rand() = shuffled().first()

private fun Int.roll() = (0 until this)
    .map { (1..6).toList().rand() }
    .sum()
    .toString()

private val firstName = listOf("Edgar", "Adrián", "Dulce")
private val lastName = listOf("Ruiz", "Wayne", "Miranda")

object CharacterGenerator {
    data class CharacterData(val name: String,
                             val race: String,
                             val dex: String,
                             val wis: String,
                             val str: String)

    private fun name() = "${firstName.rand()} ${lastName.rand()}"

    private fun race() = listOf("human", "elf", "wookie").rand()

    private fun dex() = 4.roll()

    private fun wis() = 3.roll()

    private fun str() = 5.roll()

    fun generate() = CharacterData(name = name(),
                                   race = race(),
                                   dex = dex(),
                                   wis = wis(),
                                   str = str())

}//CharacterGenerator