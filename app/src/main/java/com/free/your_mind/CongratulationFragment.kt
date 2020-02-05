package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.free.your_mind.databinding.CongratulationFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class CongratulationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<CongratulationFragmentBinding>(
            inflater,
            R.layout.congratulation_fragment,
            container,
            false
        )
        return binding.root
    }

}
