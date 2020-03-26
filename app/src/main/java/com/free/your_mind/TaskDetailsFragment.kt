package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.free.your_mind.data.TasksViewModel
import com.free.your_mind.databinding.TaskDetailsFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


/**
 * A simple [Fragment] subclass.
 */
class TaskDetailsFragment : Fragment() {

    private val viewModel: TasksViewModel by activityViewModels()

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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

        val task = viewModel.tasks.value!!.find { it.id == args.taskId }
        if (task != null) {
            binding.name.text = task.name
            binding.description.text = task.description
        }

        binding.doneButton.setOnClickListener { view: View ->
            viewModel.markTaskAsDone(args.taskId)
            view.findNavController()
                .navigate(R.id.action_taskDetailsFragment_to_congratulationFragment)
        }

        return binding.root
    }

}
