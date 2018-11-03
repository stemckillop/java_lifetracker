package com.drkdagron.mtglifetracker

import android.util.Log

data class Player(var listener: OnPlayerValueChange)  {

    var life: Int = 20


    fun reset() {
        life = 20
    }

    fun modifyLife(how: Int) {
        life += how

        listener.onPlayerValueChange()
    }

    enum class LifeType {
        Life, Poison, Experience, Energy
    }
}