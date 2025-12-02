package com.example.hybridapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Activity utama aplikasi yang menjadi host untuk fragment Navigation.
 *
 * Menyediakan `BottomNavigationView` untuk beralih antar fragment: Dashboard,
 * ListPasien, dan About. Pada start pertama, menampilkan `DashboardFragment`.
 */
class MainActivity : AppCompatActivity() {
    /**
     * Dipanggil saat Activity dibuat. Meng-inflate layout, menyiapkan fragment
     * awal (jika belum ada state sebelumnya) dan menginisialisasi
     * `BottomNavigationView` untuk menangani pergantian fragment.
     *
     * @param savedInstanceState Bundle dengan state sebelumnya, jika ada.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set initial fragment only on fresh start
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, DashboardFragment())
                .commit()
        }

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        // Listener untuk menu navigation: memilih fragment yang sesuai
        bottomNav.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.menu_dashboard -> DashboardFragment()
                R.id.menu_list_pasien -> ListPasienFragment()
                R.id.menu_about -> AboutFragment()
                else -> DashboardFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
            true
        }
    }
}
