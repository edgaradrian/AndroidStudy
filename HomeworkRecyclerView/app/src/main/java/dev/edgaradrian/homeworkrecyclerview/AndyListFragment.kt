package dev.edgaradrian.homeworkrecyclerview

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AndyListFragment: Fragment() {

    private lateinit var andyRecyclerView: RecyclerView
    private var adapter: AndyAdapter? = null

    private val andyListViewModel: AndyListViewModel by lazy {
        ViewModelProviders.of(this).get(AndyListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_andy_list, container, false)
        andyRecyclerView = view.findViewById(R.id.andy_recycler_view)
        andyRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val andys = andyListViewModel.andys
        adapter = AndyAdapter(andys)
        andyRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(): AndyListFragment {
            return AndyListFragment()
        }
    }

    private inner class AndyHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var andy: Andy

        private val nameTextView: TextView = itemView.findViewById(R.id.andy_name_text_view)
        private val jobTextView: TextView = itemView.findViewById(R.id.andy_job_text_view)
        private val andyImageView: ImageView = itemView.findViewById(R.id.andy_image)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(andy: Andy) {
            this.andy = andy
            nameTextView.text = this.andy.name
            jobTextView.text = this.andy.job
            val imageResourceId = getAndyImage(this.andy.type)
            andyImageView.setImageResource(imageResourceId)
        }

        override fun onClick(v: View?) {
            //Toast.makeText(context, "${andy.name} pressed!", Toast.LENGTH_LONG).show()
            val container = itemView.findViewById<ViewGroup>(R.id.custom_toast_container)
            val layout = layoutInflater.inflate(R.layout.custom_toast, container)
            val text = layout.findViewById<TextView>(R.id.text_custom_toast)
            text.text = andy.name
            val image = layout.findViewById<ImageView>(R.id.image_custom_toast)
            val andyImage = getAndyImage(andy.type)
            image.setImageResource(andyImage)
            with ( Toast(context) ) {
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration = Toast.LENGTH_SHORT
                view = layout
                show()
            }
        }//onClick

        private fun getAndyImage(type: AndyType): Int {
            return when (type) {
                AndyType.YELLOW -> R.drawable.ic_yellow_green
                AndyType.ORANGE -> R.drawable.ic_orange_blue
                AndyType.GREEN -> R.drawable.ic_green_yellow
                AndyType.BLUE -> R.drawable.ic_blue_orange
                else -> R.drawable.ic_black_white
            }
        }//getAndyImage

    }//AndyHolder

    private inner class AndyAdapter(var andys: List<Andy>): RecyclerView.Adapter<AndyHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndyHolder {
            val view = layoutInflater.inflate(R.layout.list_item_andy, parent, false)
            return AndyHolder(view)
        }

        override fun getItemCount() = andys.size

        override fun onBindViewHolder(holder: AndyHolder, position: Int) {
            val andy = andys[position]
            holder.bind(andy)
        }

    }//AndyAdapter

}//AndyListFragment