package com.example.pruebakosmosandroid.ui.fragment


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakosmosandroid.R
import com.example.pruebakosmosandroid.databinding.ProfileFragmentBinding
import com.example.pruebakosmosandroid.domain.model.Characters
import com.example.pruebakosmosandroid.ui.adapter.ListCharactersAdapter
import com.example.pruebakosmosandroid.ui.interfaces.FragmentListener
import com.example.pruebakosmosandroid.ui.viewmodel.ProfileViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment(), FragmentListener {

    private val profileViewModel: ProfileViewModel by viewModels()

    private val characters:MutableList<Characters> = ArrayList()
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var listCharactersAdapter : ListCharactersAdapter
    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
    private var _binding: ProfileFragmentBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel(){

        profileViewModel.characters.observe(viewLifecycleOwner){
            characters.addAll(it)
            setUpRecyclerView(characters)
        }
        profileViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loadingProfile.isVisible = it
        }
        profileViewModel.getAllCharacters()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView(characters:MutableList<Characters>?){
        listCharactersAdapter = ListCharactersAdapter(this)
        mRecyclerView = binding.rvListMoviesProfile
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        mRecyclerView.adapter = listCharactersAdapter
        listCharactersAdapter.submitList(characters)
        mRecyclerView.adapter?.notifyDataSetChanged()
    }

    override fun setAlertDialog(characters: Characters) {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)

        // Initialize views from the custom layout
        val ivMovie = dialogView.findViewById<ImageView>(R.id.ivMovie2)
        val tvStatus = dialogView.findViewById<TextView>(R.id.tvStatus)
        val tvSpecies = dialogView.findViewById<TextView>(R.id.tvSpecies)
        val tvType = dialogView.findViewById<TextView>(R.id.tvType)
        val tvGender = dialogView.findViewById<TextView>(R.id.tvGender)
        val tvOrigin = dialogView.findViewById<TextView>(R.id.tvOrigin)
        val tvLocation = dialogView.findViewById<TextView>(R.id.tvLocation)

        tvStatus.text = characters.status
        tvSpecies.text = characters.species
        tvType.text = characters.type
        tvGender.text = characters.gender
        tvOrigin.text = characters.origin!!.name
        tvLocation.text = characters.location!!.name
        Picasso.get().load(characters.image).into(ivMovie)

        // Create the dialog
        val dialog = AlertDialog.Builder(requireActivity())
            .setTitle("Detalle")
            .setView(dialogView)
            .create()
        // Show the dialog
        dialog.show()

    }



}