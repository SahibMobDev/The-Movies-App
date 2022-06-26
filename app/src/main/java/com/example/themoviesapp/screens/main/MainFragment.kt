package com.example.themoviesapp.screens.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.MAIN
import com.example.themoviesapp.R
import com.example.themoviesapp.databinding.FragmentMainBinding
import com.example.themoviesapp.models.MovieItemModel


class MainFragment : Fragment() {

    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       mBinding = FragmentMainBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        var viewModel = ViewModelProvider(this).get(MainFragmentViewModel:: class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getMoviesRetrofit()
        viewModel.myMovies.observe(viewLifecycleOwner, {list -> adapter.setList(list.body()!!.results)} )
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.item_favorite -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_favoriteFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun clickMovie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }

}