package com.team.dbgo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var networkService: NetworkService? = null
    private var requestManager: RequestManager? = null

    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        networkService = ApplicationController.instance!!.networkService
        requestManager = Glide.with(this)

        loginButton.setOnClickListener{
            networkService!!.getUserInfo(
                    idInput.text.toString(),
                    passwordInput.text.toString()
            ).enqueue(object : Callback<UserInfoResponse> {
                override fun onResponse(call: Call<UserInfoResponse>?, response: Response<UserInfoResponse>?) {
                    response?.let {
                        if (it.isSuccessful) {
                            if (it.body().code == 200) {
                                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            }
                        } else {
                            ApplicationController.instance!!.makeToast("아이디 혹은 비밀번호를 확인하세요!")
                        }
                    }
                }

                override fun onFailure(call: Call<UserInfoResponse>?, t: Throwable?) {
                    ApplicationController.instance!!.makeToast("통신 확인")
                }

            })
        }

    }



}