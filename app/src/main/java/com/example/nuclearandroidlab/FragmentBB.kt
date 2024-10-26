package com.example.nuclearandroidlab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import kotlin.random.Random

class FragmentBB : Fragment() {

    private lateinit var viewOfLayout : View;
    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater.inflate(R.layout.fragment_b_b, container, false)
        val constraintLayoutBB = viewOfLayout.findViewById<ConstraintLayout>(R.id.constraint_layout_fragment_b_b)
        constraintLayoutBB.setBackgroundColor(Color.Yellow.toArgb());
        val buttonOpenFragmentBA = viewOfLayout.findViewById<Button>(R.id.fragment_bb_send_color_ba)
        buttonOpenFragmentBA.setOnClickListener {
            Log.d("BA", "setFragmentResult");
            setFragmentResult("requestKey", bundleOf("color" to Random.nextInt()))

        }
        return viewOfLayout;
    }

}