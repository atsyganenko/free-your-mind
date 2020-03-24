package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.free.your_mind.data.DoneTaskViewModel
import com.free.your_mind.data.Tasks
import com.free.your_mind.databinding.TasksFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class TasksFragment : Fragment() {

    private val viewModel: DoneTaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TasksFragmentBinding>(
            inflater,
            R.layout.tasks_fragment, container, false
        )

        viewModel.doneTasks.observe(viewLifecycleOwner, Observer {
            Tasks.challenges.forEach { (id, task) ->
                val textView = TextView(this.context)
                textView.textSize = 20f
                textView.text =
                    if (viewModel.doneTasks.value?.contains(id) == true) task.name.plus(" #DONE") else task.name
                textView.setOnClickListener { view: View ->
                    view.findNavController()
                        .navigate(
                            TasksFragmentDirections.actionTasksFragmentToTaskDetailsFragment(
                                id
                            )
                        )
                }
                binding.tasks.addView(textView)
            }
        })

        return binding.root
    }

}
