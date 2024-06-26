package com.nareshit.fragmentscommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    private var param1: String = "Go To next"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)!!
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_first, container, false)
        val et = v.findViewById<EditText>(R.id.my_data)
        val b = v.findViewById<Button>(R.id.button)
        b.text = param1
        b.setOnClickListener {
            // get the data
            val s:String = et.text.toString()
            val sf:SecondFragment = SecondFragment.newInstance(s)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fcv,sf)?.commit()
        }
        return v
    }

    companion object{
        fun myIntializationBlock(myreply:String)=
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, myreply)
                }
            }
    }
}