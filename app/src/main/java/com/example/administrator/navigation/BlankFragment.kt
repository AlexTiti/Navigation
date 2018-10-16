package com.example.administrator.navigation


import android.app.Activity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.ActivityNavigator
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val btnFragment = view.findViewById<Button>(R.id.btnFragment)
        val btnActivity = view.findViewById<Button>(R.id.btnActivity)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        btnFragment.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("name", "Blank")
            bundle.putInt("number", 10)

            val extras = FragmentNavigator.Extras.Builder()
                .addSharedElement(imageView, "image")
                .build()
            Navigation.findNavController(btnFragment)
                .navigate(R.id.action_blankFragment_to_secondFragment, bundle, null, extras)

        }

        btnActivity.setOnClickListener {
            val option = ActivityOptionsCompat.makeSceneTransitionAnimation(activity as Activity, imageView, "image")

            val exeras = ActivityNavigator.Extras(option)
            Navigation.findNavController(btnFragment)
                .navigate(R.id.action_blankFragment_to_secondActivity2, null, null, exeras)
        }

        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
