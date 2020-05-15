package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_play_with_friend.*

class PlayWithJarvisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_jarvis)

        var flag: Int = 0
        var flag1: Int = 0
        var flag2: Int = 0
        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"

        val low = findViewById<Button>(R.id.diff_low)
        val medium = findViewById<Button>(R.id.diff_medium)
        val high = findViewById<Button>(R.id.diff_high)

        val wepcircle = findViewById<ImageButton>(R.id.wepon_circle)
        val wepcross = findViewById<ImageButton>(R.id.wepon_cross)
        val movecircle = findViewById<ImageButton>(R.id.circle_move)
        val movecross = findViewById<ImageButton>(R.id.cross_move)

        val play = findViewById<Button>(R.id.play)
        val quit = findViewById<Button>(R.id.quit)

        low.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
        wepcircle.setImageDrawable(resources.getDrawable(R.drawable.ic_circle_secondary))
        movecircle.setImageDrawable(resources.getDrawable(R.drawable.ic_circle_secondary))

        low.setOnClickListener(View.OnClickListener {
            low.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            medium.setBackgroundResource(R.drawable.layout_difficulty_button)
            high.setBackgroundResource(R.drawable.layout_difficulty_button)
            flag = 0
        })
        medium.setOnClickListener(View.OnClickListener {
            low.setBackgroundResource(R.drawable.layout_difficulty_button)
            medium.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            high.setBackgroundResource(R.drawable.layout_difficulty_button)
            flag = 1
        })
        high.setOnClickListener(View.OnClickListener {
            low.setBackgroundResource(R.drawable.layout_difficulty_button)
            medium.setBackgroundResource(R.drawable.layout_difficulty_button)
            high.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            flag = 2
        })

        wepcircle.setOnClickListener(View.OnClickListener {
            wepcircle.setImageResource(R.drawable.ic_circle_secondary)
            wepcross.setImageResource(R.drawable.ic_cross_white)
            flag1 = 0
        })
        wepcross.setOnClickListener(View.OnClickListener {
            wepcircle.setImageResource(R.drawable.ic_circle_white)
            wepcross.setImageResource(R.drawable.ic_cross_secondary)
            flag1 = 1
        })
        movecircle.setOnClickListener(View.OnClickListener {
            movecircle.setImageResource(R.drawable.ic_circle_secondary)
            movecross.setImageResource(R.drawable.ic_cross_white)
            flag2 = 0
        })
        movecross.setOnClickListener(View.OnClickListener {
            movecircle.setImageResource(R.drawable.ic_circle_white)
            movecross.setImageResource(R.drawable.ic_cross_secondary)
            flag2 = 1
        })

        play.setOnClickListener(View.OnClickListener {
            moveFirst(flag, flag1, flag2)
        })
        quit.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun moveFirst(flag: Int, flag1: Int, flag2: Int) {
        val intent = Intent(this, VsJarvis::class.java)
        intent.putExtra("Flag", flag)
        intent.putExtra("Flag1", flag1)
        intent.putExtra("Flag2", flag2)
        startActivity(intent)
    }
}
