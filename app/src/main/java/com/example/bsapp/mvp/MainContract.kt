package com.example.bsapp.mvp

import com.example.bsapp.mvp.model.Bs

interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     */
    interface Presenter {

        fun onDestroy()

        fun onRefreshButtonClick()

        fun requestDataFromServer()

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     */
    interface MainView {

        fun showProgress()

        fun hideProgress()

        fun setDataToRecyclerView(bs_List: List<Bs>)

        fun onResponseFailure(throwable: Throwable)

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     */
    interface GetBsIntractor {

        interface OnFinishedListener {
            fun onFinished(bs_List: List<Bs>)
            fun onFailure(t: Throwable)
        }

        fun getBsList(onFinishedListener: OnFinishedListener)
    }
}