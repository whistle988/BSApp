package com.example.bsapp.mvp.presenter

import com.example.bsapp.mvp.MainContract
import com.example.bsapp.mvp.model.Bs


class MainPresenter(mainView:MainContract.MainView, getBsIntractor:MainContract.GetBsIntractor):MainContract.Presenter, MainContract.GetBsIntractor.OnFinishedListener {

    private var mainView:MainContract.MainView
    private val getBsIntractor:MainContract.GetBsIntractor

    init{
        this.mainView = mainView
        this.getBsIntractor = getBsIntractor
    }

    override fun onDestroy() {
        mainView
    }

    override fun onRefreshButtonClick() {
        mainView.showProgress()
        getBsIntractor.getBsList(this)
    }

    override fun requestDataFromServer() {
        getBsIntractor.getBsList(this)
    }


    override fun onFinished(bs_List: List<Bs>) {
        mainView.setDataToRecyclerView(bs_List)
        mainView.hideProgress()
    }

    override fun onFailure(t: Throwable) {
        mainView.onResponseFailure(t)
        mainView.hideProgress()
    }

}