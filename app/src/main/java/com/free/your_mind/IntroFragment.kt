package com.free.your_mind


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.free.your_mind.databinding.IntroFragmentBinding


/**
 * A simple [Fragment] subclass.
 */
class IntroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflate<IntroFragmentBinding>(
            inflater,
            R.layout.intro_fragment, container, false
        )

        setHasOptionsMenu(true)

        binding.start.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_introFragment_to_tasksFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        )
                || super.onOptionsItemSelected(item)
    }

}
