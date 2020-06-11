package com.example.byju

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.byju.data.network.MyApi
import com.example.byju.data.repositories.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this,R.id.fragment_container)
        NavigationUI.setupActionBarWithNavController(this,navController)
        val api = MyApi()
      val repository = NewsRepository(api)
      /*  GlobalScope.launch(Dispatchers.Main){
            val newsList = repository.getNewsList()
            Toast.makeText(this@MainActivity,newsList.toString(),Toast.LENGTH_LONG).show()
        }*/
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.fragment_container),null)
    }
}