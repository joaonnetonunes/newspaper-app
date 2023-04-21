package com.ct.newsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.material3.Snackbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ct.newsapp.databinding.FragmentNewsBinding
import com.ct.newsapp.model.HttpResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
    }

    private fun configureView() {
        newsViewModel.observeHeadlines().observe(requireActivity()) { httpResponse ->

            when (httpResponse) {
                is HttpResponse.Success -> {
                    httpResponse.data.apply {
                        this?.let {
                            val newsRecyclerView: RecyclerView = binding.rvNewsList
                            newsRecyclerView.adapter = NewsAdapter(it.articles!!, requireActivity() as MainActivity)
                            newsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                        }
                    }
                }

                is HttpResponse.Error -> {
                    Toast.makeText(requireContext(), httpResponse.exception.message.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
