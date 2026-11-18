# PlayStation Rental Mobile Application

An Android-based mobile application designed to simplify PlayStation console rental and booking. Users can browse available console models, select rental durations, schedule bookings, and choose payment methods through a simple mobile interface.

Aplikasi mobile berbasis Android yang dirancang untuk mempermudah proses penyewaan dan pemesanan konsol PlayStation. Pengguna dapat melihat pilihan konsol, menentukan durasi sewa, menjadwalkan pemesanan, dan memilih metode pembayaran melalui antarmuka mobile yang sederhana.

---

## 📱 About the Project | Tentang Proyek

**English**

This project was developed as an Android mobile application using Java and XML in Android Studio. It provides a digital platform for managing the PlayStation rental booking process, from selecting a console to completing payment confirmation.

**Indonesia**

Proyek ini dikembangkan sebagai aplikasi mobile Android menggunakan Java dan XML melalui Android Studio. Aplikasi ini menyediakan platform digital untuk mengelola proses pemesanan rental PlayStation, mulai dari pemilihan konsol hingga konfirmasi pembayaran.

## ✨ Features | Fitur

- **User Authentication | Autentikasi Pengguna** – Login and registration interfaces / Antarmuka login dan registrasi.
- **Dashboard | Halaman Utama** – Main dashboard with promotional banners and navigation / Halaman utama dengan banner promosi dan navigasi.
- **Console Selection | Pemilihan Konsol** – Browse PlayStation 2, 3, 4, and 5 rental options / Pilihan rental PlayStation 2, 3, 4, dan 5.
- **Game Catalog | Katalog Game** – Game selections for different PlayStation consoles / Pilihan game berdasarkan jenis konsol PlayStation.
- **Rental Booking | Pemesanan Rental** – Select rental duration, booking date, and customer details / Pemilihan durasi sewa, tanggal pemesanan, dan data pelanggan.
- **Delivery Options | Opsi Pengantaran** – Choose between home delivery and self-pickup / Pilihan pengantaran ke rumah atau pengambilan mandiri.
- **Payment Methods | Metode Pembayaran** – Cash on Delivery (COD) and bank transfer options / Pilihan pembayaran COD dan transfer bank.
- **Payment Confirmation | Konfirmasi Pembayaran** – Upload transfer payment proof through the application interface / Pengunggahan bukti transfer melalui antarmuka aplikasi.
- **Rental History | Riwayat Penyewaan** – View and manage previous booking records / Melihat dan mengelola riwayat pemesanan.
- **User Profile | Profil Pengguna** – Access profile and logout functionality / Mengakses profil dan fitur logout.

## 🛠️ Tech Stack | Teknologi

| Component | Technology |
|---|---|
| Programming Language | Java |
| Development Environment | Android Studio |
| UI Design | XML |
| Build System | Gradle |
| Libraries | AndroidX, Material Components, ConstraintLayout |
| Local Storage | SharedPreferences |

## 📂 Project Structure | Struktur Proyek

```text
app/
└── src/
    └── main/
        ├── java/
        │   └── com/example/aplikasisplashscreen/
        │       ├── MainActivity.java
        │       ├── SplashScreen.java
        │       ├── dashboard.java
        │       ├── pesan.java
        │       ├── pembayaran.java
        │       ├── histori.java
        │       ├── akun.java
        │       ├── register.java
        │       ├── HistoriHelper.java
        │       └── Adapters/
        ├── res/
        │   ├── drawable/
        │   ├── layout/
        │   ├── mipmap/
        │   └── values/
        └── AndroidManifest.xml
```

## ⚙️ Requirements | Persyaratan

- Android Studio
- JDK 11 or compatible Gradle JDK
- Android SDK 35
- Minimum Android Version: Android 9.0 (API 28)

**Persyaratan:**
- Android Studio
- JDK 11 atau Gradle JDK yang kompatibel
- Android SDK 35
- Versi minimum Android: Android 9.0 (API 28)

## 🚀 Getting Started | Cara Menjalankan

1. Clone this repository.
2. Open the project in Android Studio.
3. Allow Gradle to sync and download the required dependencies.
4. Connect an Android device or start an emulator.
5. Build and run the application.

**Langkah menjalankan aplikasi:**

1. Clone repository ini.
2. Buka project menggunakan Android Studio.
3. Tunggu proses sinkronisasi Gradle dan pengunduhan dependencies selesai.
4. Hubungkan perangkat Android atau jalankan emulator.
5. Build dan jalankan aplikasi.

## 📝 Notes | Catatan

**English**

This repository contains the Android application source code. The project uses local storage for certain application data and does not currently include a verified remote backend integration.

**Indonesia**

Repository ini berisi source code aplikasi Android. Proyek menggunakan penyimpanan lokal untuk beberapa data aplikasi dan belum memiliki integrasi backend jarak jauh yang terverifikasi.

---

**Developed as an Android Mobile Application Project.**

**Dikembangkan sebagai Proyek Aplikasi Mobile Android.**
