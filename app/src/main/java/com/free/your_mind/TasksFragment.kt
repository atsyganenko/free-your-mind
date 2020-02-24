package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.free.your_mind.data.Tasks
import com.free.your_mind.databinding.TasksFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class TasksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TasksFragmentBinding>(
            inflater,
            R.layout.tasks_fragment, container, false
        )

        Tasks.challenges.forEach { (id, task) ->
            val textView = TextView(this.context)
            textView.textSize = 20f
            textView.text = task.name
            textView.setOnClickListener { view: View ->
                view.findNavController().navigate(TasksFragmentDirections.actionTasksFragmentToTaskDetailsFragment(id))
            }
            binding.tasks.addView(textView)
        }

        return binding.root
    }


}
