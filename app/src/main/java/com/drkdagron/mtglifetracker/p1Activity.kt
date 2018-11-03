package com.drkdagron.mtglifetracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class p1Activity : AppCompatActivity(), OnPlayerValueChange{
    override fun onPlayerValueChange() {
        p1Life.text = p1.life.toString()
    }

    val TAG = "p1Activity"

    lateinit var p1: Player
    lateinit var p1Life: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p1)

        p1Life = findViewById(R.id.p1Life)
        p1 = Player(this)
    }

    fun modifyLife(view : View) {
        val player = (view.tag as String)[0]
        val math = (view.tag as String)[1]

        if (math == 's') {
            p1.modifyLife(-1)
        } else if (math == 'a') {
            p1.modifyLife(1)
        } else if (math == 'm') {
            val newFragment = ModifyLifeFragment()
            newFragment.owner = p1
            newFragment.show(supportFragmentManager, "modify_life")
        }
    }
}
