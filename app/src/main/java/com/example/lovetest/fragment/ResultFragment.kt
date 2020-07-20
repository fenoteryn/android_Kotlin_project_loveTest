package com.example.lovetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {
    var option = -1
    lateinit var navController : NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        option = arguments?.getInt("index") ?: -1

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        setResult(option)

        btn_home.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }
    fun setResult(option : Int){
        when(option){
            1 -> {tv_main.text = "수리수리 마수리 마술사"
            tv_sub.text = getString(R.string.magician)
            resultIcon.setImageResource(R.drawable.magician)}
            2 -> {tv_main.text = "분장을 하고 저글링을 하는 삐에로"
            tv_sub.text = getString(R.string.clown)
                resultIcon.setImageResource(R.drawable.clown)}
            3 -> {tv_main.text = "화려하게 줄타기와 기술을 보여주는 곡예사"
                tv_sub.text = getString(R.string.model)
                resultIcon.setImageResource(R.drawable.model)}
            4 -> {tv_main.text = "사자와 호랑이를 단숨에 제압하는 맹수조련사"
                tv_sub.text = getString(R.string.circusstunt)
                resultIcon.setImageResource(R.drawable.circusstunt)}
        }
    }
}
