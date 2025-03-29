package com.example.mono

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val backButton = view.findViewById<ImageView>(R.id.back_view)
        val logoutButton = view.findViewById<Button>(R.id.btnLogout)

        backButton.setOnClickListener {
            Toast.makeText(requireContext(), "Going back to Home", Toast.LENGTH_SHORT).show()
        }

        logoutButton.setOnClickListener {
            logoutButton.isEnabled = false // Prevent multiple clicks

            Toast.makeText(requireContext(), "Logging out", Toast.LENGTH_SHORT).show()

            val intent = Intent(requireActivity(), SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

            requireActivity().finish() // Close the current activity
        }


        return view
    }
}
