package com.openclassrooms.notes

import MainViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.activity.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.openclassrooms.notes.databinding.ActivityMainBinding
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.widget.NoteItemDecoration
import com.openclassrooms.notes.widget.NotesAdapter
import dagger.hilt.android.AndroidEntryPoint


/**
 * The main activity for the app.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     * The binding for the main layout.
     */
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels() //déclare une propriété viewModel qui obtient le ViewModel à partir du scope

    private val notesAdapter = NotesAdapter(emptyList()) //déclaration d'un adaptateur pour la liste de notes

    //private val notesRepository = NotesRepository() //déclaration d'une instance du repository de notes



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.notes.observe(this) { notes -> notesAdapter.updateNotes(notes) } //observer sur les notes du ViewModel pour mettre à jour l'adaptateur

        initRecyclerView()
        initFABButton()
        //collectNotes()
    }

    /**
     * Collects notes from the repository and updates the adapter.
     */
   /* private fun collectNotes() {
        lifecycleScope.launch {
            notesRepository.notes.collect {
                notesAdapter.updateNotes(it)
            }
        }
    }*/

    /**
     * Initializes the FAB button.
     */
    private fun initFABButton() {
        binding.btnAdd.setOnClickListener {
            MaterialAlertDialogBuilder(this).apply {
                setTitle(R.string.coming_soon)
                setMessage(R.string.not_available_yet)
                setPositiveButton(android.R.string.ok, null)
            }.show()
        }
    }

    /**
     * Initializes the RecyclerView.
     */
    private fun initRecyclerView() {
        with(binding.recycler) {
            addItemDecoration(
                NoteItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.default_margin),
                    resources.getInteger(R.integer.span_count)
                )
            )

            adapter = notesAdapter
        }

    }

}
