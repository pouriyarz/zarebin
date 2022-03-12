package com.example.zarebin.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.base.BaseFragment
import com.example.viewmodel.ViewModelFactory
import com.example.zarebin.R
import com.example.zarebin.data.model.ZarebinModel
import com.example.zarebin.databinding.FragmentListBinding
import com.example.zarebin.di.component.ListComponent
import com.example.zarebin.di.factory.ListFactory
import com.example.zarebin.ui.adapter.HorizontalAdapter
import com.example.zarebin.ui.adapter.VerticalAdapter
import com.example.zarebin.ui.functionality.createHorizontalAdapter
import com.example.zarebin.ui.functionality.createVerticalAdapter
import com.example.zarebin.ui.functionality.render
import javax.inject.Inject

class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var listComponent: ListComponent? = null
    lateinit var listViewModel: ListViewModel
    lateinit var verticalAdapter: VerticalAdapter
    lateinit var horizontalAdapter: HorizontalAdapter
    var modelList: ArrayList<ZarebinModel> = ArrayList()

    override fun getViewBinding(): FragmentListBinding =
        FragmentListBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenToView()
        listenToViewModel()
    }

    override fun inject() {
        listComponent = ListFactory.create().also {
            it.inject(this)
        }
        listViewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
    }

    override fun release() {
        listComponent = null
    }

    override fun listenToView() = render()

    override fun listenToViewModel() {
        listViewModel.listViewState.observe(viewLifecycleOwner) {
            if (it.message != null) {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                it.message = null
            } else if (it.response != null) {
                modelList.clear()
                it.response?.let {
                    modelList.addAll(it)
                    createHorizontalAdapter()
                    createVerticalAdapter()
                }
            }
        }
    }
}