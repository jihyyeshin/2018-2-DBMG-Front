package com.team.dbgo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_mypage.*

class MypageActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        my_info.setOnClickListener{
            var intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        my_pokemon.setOnClickListener{
            var intent = Intent(this, MypokemonActivity::class.java)
            startActivity(intent)
        }

        my_item.setOnClickListener{
            var intent = Intent(this, ItemActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener{
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }


}
