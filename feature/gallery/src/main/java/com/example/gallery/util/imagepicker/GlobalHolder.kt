package com.example.gallery.util.imagepicker

class GlobalHolder {
    companion object {
        @JvmStatic
        private val ourInstance = GlobalHolder()
        fun getInstance(): GlobalHolder {
            return ourInstance
        }
    }

    private var pickerManager: PickerManager? = null

    fun getPickerManager(): PickerManager? {
        return pickerManager
    }

    fun setPickerManager(pickerManager: PickerManager?) {
        this.pickerManager = pickerManager
    }
}