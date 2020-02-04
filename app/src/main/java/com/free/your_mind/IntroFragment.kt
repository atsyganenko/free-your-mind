package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import com.free.your_mind.databinding.IntroFragmentBinding
import androidx.navigation.findNavController


/**
 * A simple [Fragment] subclass.
 */
class IntroFragment : Fragment() {

    companion object {
        val challenges = listOf("Draw a picture", "Make a poem")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflate<IntroFragmentBinding>(
            inflater,
            R.layout.intro_fragment, container, false
        )

        challenges.forEach {
            val textView = TextView(this.context)
            textView.textSize = 20f
            textView.text = it
            binding.allChallenges.addView(textView)
        }

        binding.start.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.taskFragment)}

        return binding.root
    }
}
