package com.ct.newsapp.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ct.newsapp.databinding.FragmentDetailedNewsBinding
import com.ct.newsapp.model.Article

class DetailedNewsFragment : Fragment() {

    private lateinit var binding: FragmentDetailedNewsBinding
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailedNewsBinding.inflate(inflater, container, false)
        bundle = this.requireArguments()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundleSerializable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getSerializable("article", Article::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getSerializable("article")
        }
        val article: Article
        bundleSerializable?.let {
            article = it as Article
            article.apply {
                Glide.with(requireActivity()).load(it.urlToImage).into(binding.ivNewsPicture)
                binding.tvTitle.text = it.title
                binding.tvNewsContent.text = it.description
            }
        }
    }
}
