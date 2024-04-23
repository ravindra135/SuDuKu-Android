package com.rcube.suduku

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.rcube.suduku.databinding.FragmentGridGroupBinding
import org.json.JSONArray

class GridGroup : Fragment() {

    private lateinit var binding: FragmentGridGroupBinding
    private var callback: OnNumberSelectedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGridGroupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListenerForTextViews()
    }

    private fun setClickListenerForTextViews() {
        val textViews = listOf(binding.textView1,binding.textView2,binding.textView3,binding.textView4,binding.textView5,binding.textView6,binding.textView7,binding.textView8,binding.textView9)

        textViews.forEach { textView ->
            textView.setOnClickListener {
                callback?.onNumberSelected(textView)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? OnNumberSelectedListener
    }

    override fun onDetach() {
        super.onDetach()
        callback = null;
    }

    fun updateTextView(data: JSONArray) {
        val textViews = listOf(binding.textView1,binding.textView2,binding.textView3,binding.textView4,binding.textView5,binding.textView6,binding.textView7,binding.textView8,binding.textView9)

        for (i in 0 until 9) {
            if(data[i] != 0) {
                textViews[i].text = data[i].toString()
                textViews[i].isClickable = false
            }
        }
    }

    /**
     * This interface will provide a method for the fragment to notify the activity when the text view is clicked.
     */
    interface OnNumberSelectedListener {
        fun onNumberSelected(textView: TextView)
    }
}