package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.free.your_mind.data.Tasks
import com.free.your_mind.databinding.TaskDetailsFragmentBinding


/**
 * A simple [Fragment] subclass.
 */
class TaskDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TaskDetailsFragmentBinding>(
            inflater,
            R.layout.task_details_fragment,
            container,
            false
        )

        val args = TaskDetailsFragmentArgs.fromBundle(arguments!!)
        val task = Tasks.challenges.get(args.taskId)
        if (task != null) {
            binding.name.text = task.name
            binding.description.text = task.description
        }

        binding.doneButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_taskDetailsFragment_to_congratulationFragment)
        }
        return binding.root
    }


}
