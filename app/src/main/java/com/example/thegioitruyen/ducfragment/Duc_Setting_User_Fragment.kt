package com.example.thegioitruyen.ducfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thegioitruyen.databinding.FragmentDucSettingUserBinding
import com.example.thegioitruyen.ducactivity.DucLoginActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Duc_Setting_User_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Duc_Setting_User_Fragment : Fragment() {

    private lateinit var binding: FragmentDucSettingUserBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDucSettingUserBinding.inflate(layoutInflater)
        val view =binding.root
        binding.btnLogoutSettingUserFragment.setOnClickListener{
            var intent= Intent(view.context, DucLoginActivity::class.java)
            startActivity(intent)
        }


        return view
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_setting_user, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingUserFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Duc_Setting_User_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}