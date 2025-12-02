package com.example.hybridapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Simple fragment yang menampilkan tampilan dashboard aplikasi.
 */
class DashboardFragment : Fragment() {
    /**
     * Inflates layout `fragment_dashboard` untuk fragment ini.
     *
     * @param inflater LayoutInflater untuk melakukan inflate.
     * @param container Parent ViewGroup.
     * @param savedInstanceState Bundle state sebelumnya.
     * @return View yang di-inflate.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}
