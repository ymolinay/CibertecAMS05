package com.cibertec.myciberapps05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cibertec.myciberapps05.databinding.ActivityMainBinding
import com.cibertec.myciberapps05.databinding.ActivityNewTaskBinding
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewTaskActivity : AppCompatActivity() {

    // lateinit definir una variable a la que asignaremos valor luego
    private lateinit var binding: ActivityNewTaskBinding
//    private var tagSelected: List<String> = emptyList()
    private var tagSelected: MutableList<String> = mutableListOf()
    private var prioritySelected: String = ""
    private var dateSelected: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllTags()
    }

    fun getAllTags() {
        // obtener la lista desde REST
        // llamar makeTagsChips(resultado)
        ClientIRetrofit.api.getAllTags()
            .enqueue(object : Callback< List<Tag> > {
                override fun onResponse(call: Call<List<Tag>>, response: Response<List<Tag>>) {
                    if (response.isSuccessful) {
                        val listTags = response.body() ?: emptyList()
                        makeTagsChips(listTags)
                    }
                }

                override fun onFailure(call: Call<List<Tag>>, t: Throwable) {
                    // Toast/AlertDialog para indicar al usuario que hubo un error
                    // finish
                }

            })
    }

    fun makeTagsChips(listTags: List<Tag>) {

        listTags.forEach { tag ->
            val newChip = Chip(this)
            newChip.text = tag.name
            newChip.isCheckable = true

            //newChip.setOnCheckedChangeListener { viewChip, isChecked ->
            newChip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    tagSelected.add(tag.name)
                } else {
                    tagSelected.remove(tag.name)
                }
            }

            binding.chTags.addView(newChip)
        }

    }
}