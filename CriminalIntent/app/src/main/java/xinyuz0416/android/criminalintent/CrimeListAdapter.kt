package xinyuz0416.android.criminalintent

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import xinyuz0416.android.criminalintent.databinding.ListItemCrimeBinding

class CrimeHolder(val binding: ListItemCrimeBinding): RecyclerView.ViewHolder(binding.root) {
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.apply {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
        }
    }

    override fun getItemCount() = crimes.size
}