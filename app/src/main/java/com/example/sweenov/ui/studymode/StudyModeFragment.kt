package com.example.sweenov.ui.studymode

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sweenov.App
import com.example.sweenov.ForLoading
import com.example.sweenov.R
import com.example.sweenov.ui.assignment_management.TaskAdapter
import kotlinx.android.synthetic.main.fragment_a_m.view.*
import kotlinx.android.synthetic.main.fragment_studymode.view.*
import kotlin.concurrent.thread

class StudyModeFragment : Fragment() {

    private lateinit var studyModeViewModel: StudyModeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        studyModeViewModel =
                ViewModelProvider(this).get(StudyModeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_studymode, container, false)

        App.m0 = MediaPlayer.create(context, R.raw.firesound2)
        App.m1 = MediaPlayer.create(context, R.raw.rain)
        App.m2 = MediaPlayer.create(context, R.raw.naturesound)
        App.m3 = MediaPlayer.create(context, R.raw.office)


        val btn0 = root.toggleButton0 // btn1에 과제목록 레이아웃에 있는 월요일 버튼을 대입해 줍니다.
        btn0.setOnClickListener(View.OnClickListener {
            if(btn0.isChecked == true) {

                App.m0.start()

            }else{

                App.m0.pause()
            }
        })


        val btn1 = root.toggleButton // btn1에 과제목록 레이아웃에 있는 월요일 버튼을 대입해 줍니다.
        btn1.setOnClickListener(View.OnClickListener {
            if(btn1.isChecked == true) {
                App.m1.start()

            }else{
                App.m1.pause()

            }
        })

        val btn2 = root.toggleButton2 // btn1에 과제목록 레이아웃에 있는 월요일 버튼을 대입해 줍니다.
        btn2.setOnClickListener(View.OnClickListener {
            if(btn2.isChecked == true) {

                App.m2.start()

            }else{

                App.m2.pause()
            }
        })

        val btn3 = root.toggleButton3 // btn1에 과제목록 레이아웃에 있는 월요일 버튼을 대입해 줍니다.
        btn3.setOnClickListener(View.OnClickListener {
            if(btn3.isChecked == true) {

                App.m3.start()

            }else{

                App.m3.pause()
            }
        })

        val minute = String.format("%02d", App.total/60)
        val second = String.format("%02d", App.total%60)
        root.textTimer.text = "$minute:$second"

        val handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                val minute2 = String.format("%02d", App.total/60)
                val second2 = String.format("%02d", App.total%60)
                root.textTimer.text = "$minute2:$second2"
            }

        }
        handler?.sendEmptyMessage(0)

        val btnForStart = root.toggleButton4Time
        btnForStart.setOnClickListener {
            if(btnForStart.isChecked == true) {
                App.started = true
                App.ForTime = 1

                thread(App.started == true) {
                    while (App.started){
                        Thread.sleep(1000)
                        if(App.started){
                            App.total = App.total + 1
                            handler?.sendEmptyMessage(0)
                        }
                    }
                }


            }else{

                App.started = false
                App.ForTime = 0
            }



        }




        return root
    }
}