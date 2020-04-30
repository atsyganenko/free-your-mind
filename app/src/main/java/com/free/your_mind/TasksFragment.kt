package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.free.your_mind.data.Task
import com.free.your_mind.data.TasksViewModel
import com.free.your_mind.databinding.TasksFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class TasksFragment : Fragment() {

    private val viewModel: TasksViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<TasksFragmentBinding>(
            inflater,
            R.layout.tasks_fragment, container, false
        )

        val adapter = TaskAdapter(TaskClickListener { taskId ->
            binding.tasks.findNavController()
                .navigate(
                    TasksFragmentDirections.actionTasksFragmentToTaskDetailsFragment(
                        taskId
                    )
                )
        })

        binding.tasks.adapter = adapter

        viewModel.tasks.observe(viewLifecycleOwner, Observer<List<Task>> {
            it.let {
                adapter.submitList(it)
            }
        })

        binding.lifecycleOwner = this

        return binding.root
    }

}
