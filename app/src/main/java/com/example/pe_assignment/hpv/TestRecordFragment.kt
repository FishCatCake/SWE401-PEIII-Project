package com.example.pe_assignment.hpv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R


class TestRecordFragment : Fragment() {

    private lateinit var adapter: RecordAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var recordArrayList: ArrayList<RecordModel>
    lateinit var index : Array<String>
    lateinit var date : Array<String>
    lateinit var brand : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_record, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_test_record)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RecordAdapter(recordArrayList)
        recyclerView.adapter = adapter

        var btnSend = view.findViewById<ImageButton>(R.id.left_arrow)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.hpvRecordFragment)
        }
        btnSend = view.findViewById<ImageButton>(R.id.back)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.hpvRecordFragment)
        }
        btnSend = view.findViewById<ImageButton>(R.id.profile)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.menstruationActivity)
        }

    }

    private fun dataInitialize(){
        recordArrayList = arrayListOf<RecordModel>()
        index = arrayOf(
            "1",
            "2",
            "3"
        )

        date = arrayOf(
            "2021.12.1",
            "2022.3.1",
            "2022.9.1"
        )
        brand = arrayOf(
            "ABC No.1, \n" +
                    "9vHPV",
            "ABC No.1, \n" +
                    "9vHPV",
            "ABC No.1 9, \n" +
                    "9vHPV"
        )

        for(i in index.indices){
            val record = RecordModel(index[i],brand[i],date[i])
            recordArrayList.add(record)
        }

    }
}