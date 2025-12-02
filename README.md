# HybridApp

Aplikasi Android sederhana (Hybrid) yang menampilkan beberapa fragment:
- `DashboardFragment`
- `ListPasienFragment` (memuat konten web di `WebView` dan mengekstrak elemen dengan id `list-pasien`)
- `AboutFragment`

Repository ini berisi proyek Android (Gradle Kotlin DSL).

## Prasyarat
- Android Studio (terbaru direkomendasikan)
- JDK 11+ (tergantung konfigurasi Gradle)
- Perangkat Android atau emulator

## Menjalankan di Android Studio
1. Buka Android Studio.
2. Pilih `Open` lalu arahkan ke folder proyek ini (`HybridApp`).
3. Tunggu Gradle sync selesai.
4. Jalankan app pada perangkat atau emulator.

## Menjalankan dari command-line
- Build debug APK:

```bash
./gradlew assembleDebug
```

- Install debug ke perangkat yang terhubung:

```bash
./gradlew installDebug
```

Catatan: pastikan perangkat terhubung dan `adb` mendeteksinya.

## Struktur singkat
- `app/src/main/java/com/example/hybridapp/` — kode sumber Kotlin untuk Activity dan Fragment.
- `app/src/main/res/layout/` — layout XML untuk Activity dan Fragment.

## Catatan penting
- `ListPasienFragment` memuat URL `http://xxx.xxx.xxx.xx:xxxx/` pada `WebView` dan menjalankan JavaScript untuk hanya menampilkan elemen dengan id `list-pasien`.
- Jika URL atau struktur HTML berubah, fragment tersebut mungkin perlu penyesuaian.

## Kontribusi
Silakan buka issue atau pull request pada repository GitHub: https://github.com/nashehannafii/hybrid-app

## Lisensi
Gunakan sesuai kebutuhan Anda. Tidak ada lisensi khusus yang didefinisikan di repo ini.
