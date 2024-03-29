package com.example.pe_assignment.cancer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.pe_assignment.R


class TimelineUploadFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timeline_upload, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnins= view.findViewById<Button>(R.id.create_ins)
        btnins.setOnClickListener {
            view.findNavController().navigate(R.id.cervicalCancerTimeline02fragment3)
        }
        val btnSend = view.findViewById<Button>(R.id.create_res)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.cervicalCancerTimeline02fragment3)
        }

        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.cancerTimelineCalendar)
        }
    }

}