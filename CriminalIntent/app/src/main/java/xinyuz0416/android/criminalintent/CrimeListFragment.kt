package xinyuz0416.android.criminalintent

import android.os.*
import android.util.*
import androidx.fragment.app.*

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {

    private  val crimeListViewModel: CrimeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }
}