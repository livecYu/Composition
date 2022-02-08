package com.example.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composition.R
import com.example.composition.databinding.FragmentGameBinding
import com.example.composition.domain.entity.Level


class GameFragment : Fragment() {
    private lateinit var lavel: Level
    private var _binding : FragmentGameBinding? = null
    private val binding : FragmentGameBinding
    get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs(){
        lavel = requireArguments().getSerializable(KEY_LEVEL) as Level
    }

    companion object{
        private const val KEY_LEVEL = "level"

        fun newInstance(level:Level): GameFragment{
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_LEVEL,level)
                }
            }
        }
    }
}