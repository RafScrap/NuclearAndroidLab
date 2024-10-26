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


class FragmentBA()  : Fragment() {
    private var color: Int = 0;
    private lateinit var viewOfLayout : View;
    private var FragmentBBIsOpen: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") {
                requestKey, bundle -> color = bundle.getInt("color");
            val cl = viewOfLayout.findViewById<ConstraintLayout>(R.id.constraint_layout_fragment_b_a)
            cl.setBackgroundColor(color);
        }
        if (savedInstanceState == null) {
            color = arguments?.getInt("color") ?: 0
            FragmentBBIsOpen = arguments?.getBoolean("FragmentBBIsOpen") ?: false
        }
        else {
            color = savedInstanceState.getInt("color")
            FragmentBBIsOpen = savedInstanceState.getBoolean("FragmentBBIsOpen")
        }
    }


    override fun onCreateView
    (inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater.inflate(R.layout.fragment_b_a, container, false)
        val cl = viewOfLayout.findViewById<ConstraintLayout>(R.id.constraint_layout_fragment_b_a)
        cl.setBackgroundColor(color);
        val buttonOpenFragmentBA = viewOfLayout.findViewById<Button>(R.id.fragment_ba_open_fragment_bb)
        buttonOpenFragmentBA.setOnClickListener {
            if (!FragmentBBIsOpen) {
                val fm = this@FragmentBA.parentFragmentManager;
                fm.commit{
                    add(R.id.fragment_container_view_bb, FragmentBB())
                };
                FragmentBBIsOpen = true;
            }
        }
        return viewOfLayout;
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        outState.putInt("color", color)
        outState.putBoolean("FragmentBBIsOpen", FragmentBBIsOpen)
    }

}