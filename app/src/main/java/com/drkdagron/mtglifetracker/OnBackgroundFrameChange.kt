package com.drkdagron.mtglifetracker

interface OnBackgroundFrameChange {
    fun onBackgroundFrameChange(player: Int, background: Char, guild: Char)
}