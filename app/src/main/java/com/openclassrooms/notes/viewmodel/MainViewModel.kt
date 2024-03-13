import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.openclassrooms.notes.model.Note
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.openclassrooms.notes.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel //indique que la classe MainViewModel est un ViewModel hitl injectable
class MainViewModel @Inject constructor(private val notesRepository: NotesRepository) : ViewModel() {
    //déclaration d'une LiveData mutable pour stocker la liste des notes
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    //init de la collecte des notes lors de la création du ViewModel
    init {
        collectNotes()
    }

    //fonction pour collecter les notes à partir du repository
    private fun collectNotes() {
        viewModelScope.launch {
            //utilise la coroutine pour collecter les notes à partir du flux du repository
            notesRepository.notes.collect { notesList -> _notes.postValue(notesList) } //met à jour les notes dans la LiveData mutable
        }
    }
}