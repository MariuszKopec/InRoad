package com.ocado.feature.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ocado.feature.base.BaseFragment
import kotlinx.android.synthetic.main.frament_calculator.*
import javax.inject.Inject

class CalculatorFragment : BaseFragment() {

    @Inject
    lateinit var presenter: CalculatorPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frament_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_calculator_keyboard.onButtonClick = presenter::onKeyboardButtonClick
    }
}