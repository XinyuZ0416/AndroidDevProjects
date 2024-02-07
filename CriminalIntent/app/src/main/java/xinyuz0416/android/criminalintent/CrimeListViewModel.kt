package xinyuz0416.android.criminalintent

import androidx.lifecycle.*
import java.util.*

class CrimeListViewModel: ViewModel() {
    val crimes = mutableListOf<Crime>()

    init{
        for(i in 0 until 100){
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #" + i,
                date = Date(),
                isSolved = false
            )

            crimes += crime
        }
    }

}