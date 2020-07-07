package com.example.sethportfolio.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.Config
import com.example.sethportfolio.data.app.log
import com.example.sethportfolio.data.model.Graphics
import com.google.firebase.database.*
import java.lang.Error
import javax.inject.Inject
import javax.inject.Singleton

class FragmentRepo() {

    init {
        App.component.inject(this)
    }


    //Home Fragment===================================
    val introString = "Seth Torralba is a Filipino born, Chicago based Mobile Developer and Designer." +
            " He is a double degree holder having a degree in Mutlimedia Arts and Design from De La Salle College of St Benilde" +
            " in the Philippines and a degree in Computer Science from Lewis University from Illinois. He has experience in" +
            " Graphic Design and Advertising with TELUS International Philippines, a local branch of TELUS International and experience in" +
            " IT Project Management with United Airlines."




    //Graphics Fragment =======================================
    val graphicsList by lazy{
        val x = MutableLiveData<ArrayList<Graphics>>()
        x.value = ArrayList()
        x
    }

    //var firebaseDB = FirebaseDatabase.getInstance().getReference(Config.COLLECTION_NAME)
    @Inject
    lateinit var firebaseDB:DatabaseReference

    suspend fun getGraphics():Boolean {
        var list:ArrayList<Graphics> = ArrayList()
         try{
             firebaseDB.addValueEventListener(object: ValueEventListener{
                 override fun onCancelled(error: DatabaseError) {
                     App.instance.log(error.toString())
                 }
                 override fun onDataChange(data: DataSnapshot) {
                     if(data.exists()) {list.clear()}

                     for(i in data.children){
                         var x = i.getValue(Graphics::class.java)
                         list.add(x!!)
                     }
                     graphicsList.value = list
                 }
             })
             return true
         } catch(e:Error) {
             return false
         }
    }

    //================================================================================



    //Functions

}