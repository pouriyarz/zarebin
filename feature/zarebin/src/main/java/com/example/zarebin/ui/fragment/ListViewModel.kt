package com.example.zarebin.ui.fragment

import androidx.lifecycle.MutableLiveData
import com.example.base.BaseViewModel
import com.example.base.behaviour.invoke
import com.example.base.behaviour.parseResponse
import com.example.base.behaviour.switchContext
import com.example.zarebin.data.model.ZarebinModel
import com.example.zarebin.data.repository.ZarebinRepository
import com.example.zarebin.ui.state.ListViewState
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val zarebinRepository: ZarebinRepository,
) : BaseViewModel() {
    var listViewState: MutableLiveData<ListViewState<ArrayList<ZarebinModel>>> =
        MutableLiveData(ListViewState())

    fun getList() = invoke {
        parseResponse(zarebinRepository.getList())
    }

    override fun loading(isLoading: Boolean) {
        switchContext {
            listViewState.apply {
                value?.let {
                    value = it.copy(
                        response = it.response,
                        isLoading = isLoading,
                        message = it.message
                    )
                }
            }
        }
    }

    override fun <T> success(body: T) {
        switchContext {
            listViewState.apply {
                value?.let {
                    value = it.copy(
                        response = body as ArrayList<ZarebinModel>,
                        isLoading = it.isLoading,
                        message = it.message
                    )
                }
            }
        }
    }

    override fun failed(message: String) {
        switchContext {
            listViewState.apply {
                value?.let {
                    value = it.copy(
                        isLoading = it.isLoading,
                        response = it.response,
                        message = message
                    )
                }
            }
        }
    }
}