package com.geeks.emil_maldybaev_hw3_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.geeks.emil_maldybaev_hw3_5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var num = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOperation.setOnClickListener {
            num++
            binding.tvCounter.text=num.toString()
            if (binding.tvCounter.text.toString().equals("10")){
                binding.btnOperation.text="-"
                binding.btnOperation.setOnClickListener {
                    num--
                    binding.tvCounter.text = num.toString()
                    if (binding.tvCounter.text.toString().equals("0")){
                    val bundle = Bundle()
                        bundle.putString("key1", binding.tvCounter.text.toString())
                        var secondFragment = SecondFragment()
                        secondFragment.arguments=bundle
                        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,secondFragment).commit()
                    }
                }
            }
        }
    }
}
