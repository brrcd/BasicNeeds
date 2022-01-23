package com.example.basicneeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basicneeds.DetailsFragment.Companion.DETAILS_FRAGMENT_TAG
import com.example.basicneeds.databinding.HomeFragmentBinding

class HomeFragment: Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageViews = initListOfImageViews()
        val imageResources = initListOfImageResources()
        val navController = this.findNavController()
        imageViews.forEachIndexed { index, imageView ->
            val imageRes = imageResources[index]
            imageView.setImageResource(imageRes)
            imageView.setOnClickListener {
                val bundle = bundleOf(DETAILS_FRAGMENT_TAG to imageResources[index])
                navController.navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun initListOfImageResources(): List<Int> =
        listOf(
            R.drawable.ic_airport,
            R.drawable.ic_bus,
            R.drawable.ic_charge,
            R.drawable.ic_food,
            R.drawable.ic_hotel,
            R.drawable.ic_money,
            R.drawable.ic_taxi,
            R.drawable.ic_train,
            R.drawable.ic_wc
        )

    private fun initListOfImageViews(): List<ImageView> =
        with(binding) {
            listOf(
                image1,
                image2,
                image3,
                image4,
                image5,
                image6,
                image7,
                image8,
                image9
            )
        }
}