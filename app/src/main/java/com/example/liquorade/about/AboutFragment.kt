package com.example.liquorade.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.liquorade.R

class AboutFragment : Fragment() {
    /**
     * Method gets called once the fragment should inflate a view
     *
     * @param inflater The layoutInflater
     * @param container The ViewGroup
     * @param savedInstanceState The bundle created in onSaveInstanceState
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
}