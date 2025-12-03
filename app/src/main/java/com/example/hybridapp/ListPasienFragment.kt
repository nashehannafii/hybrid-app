package com.example.hybridapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

/**
 * Fragment yang menampilkan daftar pasien melalui sebuah `WebView`.
 *
 * WebView akan memuat halaman dari URL remote dan setelah halaman selesai
 * dimuat, JavaScript dijalankan untuk menyisakan hanya elemen dengan id
 * `list-pasien` pada body. Ini membuat tampilan lebih fokus hanya pada
 * bagian daftar pasien yang relevan.
 */
class ListPasienFragment : Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    /**
     * Inflates layout dan menyiapkan `WebView`.
     *
     * - Mengaktifkan JavaScript dan DOM storage.
     * - Menetapkan `WebViewClient` yang akan menjalankan JavaScript setelah
     *   halaman selesai dimuat untuk menyisakan elemen `list-pasien` saja.
     *
     * @param inflater Layout inflater dari fragment.
     * @param container ViewGroup parent, jika ada.
     * @param savedInstanceState Bundle state sebelumnya, jika ada.
     * @return View yang di-inflate untuk fragment ini.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_pasien, container, false)
        val webView: WebView = view.findViewById(R.id.webview_list)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.webViewClient = object : WebViewClient() {
            /**
             * Dipanggil ketika halaman selesai dimuat. Menjalankan JavaScript
             * untuk memodifikasi DOM sehingga hanya elemen `list-pasien`
             * yang tersisa di dalam body. Hal ini membantu menampilkan
             * konten yang diperlukan saja pada aplikasi hybrid.
             *
             * @param view WebView yang memuat halaman.
             * @param url URL halaman yang selesai dimuat.
             */
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                // Keep only the div with id 'list-pasien' by replacing body with that element
                val js = "(function(){var el=document.getElementById('list-pasien'); if(el){document.body.innerHTML=''; document.body.appendChild(el);} })();"
                view?.evaluateJavascript(js, null)
            }
        }

        webView.loadUrl("http://13.212.195.215:5173/")

        return view
    }
}
