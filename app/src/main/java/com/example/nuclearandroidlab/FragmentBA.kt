package com.example.nuclearandroidlab

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import kotlin.random.Random


class FragmentBA()  : Fragment() {
    private var color: Int = Random.nextInt();
    private lateinit var viewOfLayout : View;
    private var fragmentBBIsOpen: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") {
                requestKey, bundle -> color = bundle.getInt("color");
            val constraintLayoutBA = viewOfLayout.findViewById<ConstraintLayout>(R.id.constraint_layout_fragment_b_a)
            constraintLayoutBA.setBackgroundColor(color);
        }
        if (savedInstanceState == null) {
            color = arguments?.getInt("color") ?: Random.nextInt()
            fragmentBBIsOpen = arguments?.getBoolean("fragmentBBIsOpen") ?: false
        }
        else {
            color = savedInstanceState.getInt("color")
            fragmentBBIsOpen = savedInstanceState.getBoolean("fragmentBBIsOpen")
        }
    }


    override fun onCreateView
    (inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater.inflate(R.layout.fragment_b_a, container, false)
        val constraintLayoutBA = viewOfLayout.findViewById<ConstraintLayout>(R.id.constraint_layout_fragment_b_a)
        constraintLayoutBA.setBackgroundColor(color);
        val buttonOpenFragmentBA = viewOfLayout.findViewById<Button>(R.id.fragment_ba_open_fragment_bb)
        buttonOpenFragmentBA.setOnClickListener {
            if (!fragmentBBIsOpen) {
                val fm = this@FragmentBA.parentFragmentManager;
                fm.commit{
                    add(R.id.fragment_container_view_bb, FragmentBB())
                };
                fragmentBBIsOpen = true;
            }
        }
        return viewOfLayout;
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        outState.putInt("color", color)
        outState.putBoolean("fragmentBBIsOpen", fragmentBBIsOpen)
    }

}