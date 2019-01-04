package com.team.dbgo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Response

class ItemActivity : AppCompatActivity(), View.OnClickListener {

    private var itemList : RecyclerView? = null
    private var itemDatas : ArrayList<ItemInfoData>? = null
    private var adapter : ItemAdapter? = null

    private var networkService: NetworkService? = null
    private var requestManager: RequestManager? = null

    override fun onClick(v: View?) {

        val idx : Int = itemList!!.getChildAdapterPosition(v!!)

        val name : String? = itemDatas!!.get(idx).item_name
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myitem)

        networkService = ApplicationController.instance!!.networkService
        requestManager = Glide.with(this)

        itemList = findViewById(R.id.item_list) as RecyclerView
        itemList!!.layoutManager = LinearLayoutManager(this)

        val getItemInfoResponse =  networkService!!.getItemInfo()
        getItemInfoResponse.enqueue(object : retrofit2.Callback<ItemInfoResponse>{
            override fun onFailure(call: Call<ItemInfoResponse>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 확인")
            }

            override fun onResponse(call: Call<ItemInfoResponse>?, response: Response<ItemInfoResponse>?) {
                if(response!!.isSuccessful){
                    if(response!!.body().items != null){
                        adapter = ItemAdapter(response!!.body().items !!, requestManager!!)
                        itemDatas = response!!.body().items
                        itemList!!.adapter = adapter
                    }
                }
            }

        })

        //adapter!!.setOnItemClickListener(this)
    }
}
