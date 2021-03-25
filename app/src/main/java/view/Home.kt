package view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.corretagemapp.R

class Home: Fragment() {
    private val recyclerView: RecyclerView? = null
    private val brokerAdapter: CorretoraAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container,false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}