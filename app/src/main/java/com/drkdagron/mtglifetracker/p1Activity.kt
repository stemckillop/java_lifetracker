package com.drkdagron.mtglifetracker

import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class p1Activity : AppCompatActivity(), OnPlayerValueChange, OnBackgroundFrameChange{
    override fun onBackgroundFrameChange(player: Int, background: Char, guild: Char) {
        when (background) {
            '0' -> p1Back.backgroundTintList(ColorStateList.valueOf(R.color.mana_white_true))
            '1' -> p1Back.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mana_white))
            '2' -> p1Back.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mana_blue))
            '3' -> p1Back.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mana_black))
            '4' -> p1Back.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mana_red))
            '5' -> p1Back.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mana_green))
            '6' -> p1Back.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.mana_colorless))
        }

        when (guild) {
            '0' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.azorius))
            '1' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.boros))
            '2' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.dimir))
            '3' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.golgari))
            '4' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.gruul))
            '5' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.izzet))
            '6' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.orzhov))
            '7' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.rakdos))
            '8' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.selesnya))
            '9' -> p1Guild.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.simic))
        }
    }

    override fun onPlayerValueChange() {
        p1Life.text = p1.life.toString()
    }

    val TAG = "p1Activity"

    lateinit var p1: Player
    lateinit var p1Life: TextView
    lateinit var p1Back: View
    lateinit var p1Guild: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p1)

        p1Life = findViewById(R.id.p1Life)
        p1Back = findViewById<View>(R.id.p1_card_back)
        p1Guild = findViewById(R.id.p1_img_back)
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
    fun modifyFrame(view : View) {
        val player = (view.tag as String)[0]

        val newFragment = ModifyFrameBackgroundFragment()
        newFragment.act = this
        newFragment.player = player.toInt()
        newFragment.show(supportFragmentManager, "modify_frame")
    }
}
