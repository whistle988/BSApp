package com.example.test

class Presenter (
    private val router: Router
){
    fun onNexButtonClicked() = router.navigateTo("Next screen")
    fun onBackButtonClicked() = router.exit()

}