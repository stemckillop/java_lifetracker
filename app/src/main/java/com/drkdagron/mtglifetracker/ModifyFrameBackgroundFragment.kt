package com.drkdagron.mtglifetracker

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class ModifyFrameBackgroundFragment : DialogFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        var which = (v?.tag as String)[0]
        var index = (v?.tag as String)[1]

        Log.e("TAG", which.toString())
        Log.e("TAG", index.toString())

        if (which == 'b') {
            resetBackgroundAlphas()

            background = index
        } else if (which == 'g') {
            resetGuildAlphas()

            guild = index
        }

        v.alpha = 1f


    }

    lateinit var act: OnBackgroundFrameChange
    var player: Int = -1
    var background: Char = 'p'
    var guild: Char = 'p'

    lateinit var backgroundButtons : ArrayList<Button>
    lateinit var guildButtons: ArrayList<ImageButton>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val view = (activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.dialog_frame_background, null)

        getBackgroundButtons(view)
        getGuildButtons(view)

        builder.setView(view)
                .setTitle("Change Background")
                .setPositiveButton("Set", { d, i ->
                    act.onBackgroundFrameChange(player, background, guild)
                    d.dismiss()
                })
                .setNegativeButton("Cancel", { d, i -> d.dismiss() })
        return builder.create()
    }

    fun getBackgroundButtons(view: View) {
        backgroundButtons = ArrayList<Button>()
        backgroundButtons.add(view.findViewById(R.id.d_bg_none))
        backgroundButtons.add(view.findViewById(R.id.d_bg_w))
        backgroundButtons.add(view.findViewById(R.id.d_bg_u))
        backgroundButtons.add(view.findViewById(R.id.d_bg_b))
        backgroundButtons.add(view.findViewById(R.id.d_bg_r))
        backgroundButtons.add(view.findViewById(R.id.d_bg_g))
        backgroundButtons.add(view.findViewById(R.id.d_bg_c))

        for (btn in backgroundButtons) {
            btn.alpha = 0.3f
            btn.setOnClickListener(this)
        }
    }

    fun getGuildButtons(view: View) {
        guildButtons = ArrayList<ImageButton>()
        guildButtons.add(view.findViewById(R.id.d_g_azorius))
        guildButtons.add(view.findViewById(R.id.d_g_boros))
        guildButtons.add(view.findViewById(R.id.d_g_dimir))
        guildButtons.add(view.findViewById(R.id.d_g_golgari))
        guildButtons.add(view.findViewById(R.id.d_g_gruul))
        guildButtons.add(view.findViewById(R.id.d_g_izzet))
        guildButtons.add(view.findViewById(R.id.d_g_orzhov))
        guildButtons.add(view.findViewById(R.id.d_g_rakdos))
        guildButtons.add(view.findViewById(R.id.d_g_selesyna))
        guildButtons.add(view.findViewById(R.id.d_g_simic))
        for (btn in guildButtons) {
            btn.alpha = 0.3f
            btn.setOnClickListener(this)
        }
    }

    fun resetBackgroundAlphas() {
        for (btn in backgroundButtons) {
            btn.alpha = 0.3f
        }
    }
    fun resetGuildAlphas() {
        for (btn in guildButtons) {
            btn.alpha = 0.3f
        }
    }


}