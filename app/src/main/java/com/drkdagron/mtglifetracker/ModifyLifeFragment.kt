package com.drkdagron.mtglifetracker

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.widget.EditText

class ModifyLifeFragment : DialogFragment() {

    lateinit var owner: Player
    lateinit var lifeEdit: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val view = (activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.dialog_modify_life, null)
        lifeEdit = view.findViewById(R.id.modify_life)
        builder.setView(view)
                .setTitle("Change Life Total")
                .setPositiveButton("Accept", { d, i ->
                    owner.life = lifeEdit.text.toString().toInt()
                    owner.listener.onPlayerValueChange()
                    d.dismiss()
                })
                .setNegativeButton("Cancel", { d, i -> d.dismiss() })
        return builder.create()
    }
}