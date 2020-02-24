package com.free.your_mind


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.free.your_mind.data.*
import com.free.your_mind.databinding.TaskDetailsFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


/**
 * A simple [Fragment] subclass.
 */
class TaskDetailsFragment : Fragment() {

    private lateinit var dataSource: TaskDatabaseDao

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

        val application = requireNotNull(this.activity).application
        val dataSource = TaskDatabase.getInstance(application).taskDatabaseDao
        val viewModelFactory = DoneTaskViewModelFactory(dataSource, application)
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(DoneTaskViewModel::class.java)

        val args = TaskDetailsFragmentArgs.fromBundle(arguments!!)

        val task = Tasks.challenges.get(args.taskId)
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
