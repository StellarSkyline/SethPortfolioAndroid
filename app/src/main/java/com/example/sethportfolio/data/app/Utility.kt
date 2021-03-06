package com.example.sethportfolio.data.app

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.Flowable

fun Context.log(message:String) {
    Log.d("STLog", "ST` ${message}" )
}

fun Context.toast(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

//fun AppCompatActivity.setupToolbar(title:String) {
//    var myToolbar: Toolbar = this.toolbar
//    myToolbar.title = title
//    this.setSupportActionBar(myToolbar)
//}

fun <T> LiveData<T>.onlyNew(lifecycleOwner: LifecycleOwner): LiveData<T> {
    if (this.value != null) {
        var x = Flowable.fromPublisher(LiveDataReactiveStreams.toPublisher(lifecycleOwner, this))
        x = x.skip(1)
        return LiveDataReactiveStreams.fromPublisher(x)
    }
    return this
}

fun ProgressBar.show() {
    this.visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    this.visibility = View.GONE
}