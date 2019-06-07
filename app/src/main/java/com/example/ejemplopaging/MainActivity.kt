package com.example.ejemplopaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        // add dividers between RecyclerView's row items
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        list.addItemDecoration(decoration)
        setupScrollListener()
        initAdapter()
    }

    private fun setupScrollListener() {
        val layoutManager = list.layoutManager as androidx.recyclerview.widget.LinearLayoutManager
        list.addOnScrollListener(object : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                Log.d("total", totalItemCount.toString())
                Log.d("visible", visibleItemCount.toString())
                Log.d("last", lastVisibleItem.toString())
                //viewModel.listScrolled(visibleItemCount, lastVisibleItem, totalItemCount)
            }
        })
    }

    private fun initAdapter() {
        list.adapter = adapter
        val items: ArrayList<Test> = ArrayList()
        for (i in 1..30)
            items.add(Test(i.toString()))
        adapter.submitList(items)
        /*    viewModel.repos.observe(this, Observer<List<Repo>> {
                Log.d("Activity", "list: ${it?.size}")
                showEmptyList(it?.size == 0)
                adapter.submitList(it)
            })
            viewModel.networkErrors.observe(this, Observer<String> {
                Toast.makeText(this, "\uD83D\uDE28 Wooops $it", Toast.LENGTH_LONG).show()
            })*/
    }

}
