package com.edgaradrian.listmaker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListSelectionRecyclerViewAdapter : RecyclerView.Adapter<ListSelectionViewHolder>() {

    val listTables = arrayOf("Shopping List", "Chores", "Android Tutorials")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listTables.size
    }//getItemCount

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}//ListSelectionRecyclerViewAdapter