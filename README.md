# 📖 Nostalgia Reader (बाल पत्रिकाएँ व कॉमिक्स)

<p align="center">
  <img src="https://img.shields.io/badge/Release-v1.0.0-crimson.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/APK%20Size-4.99%20MB-success.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/QA%20Tests-11%2F11%20Passed%20(100%25)-blue.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Platform-Android%207.0%2B-orange.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg?style=for-the-badge" />
</p>

> **"चंपक, नंदन, चाचा चौधरी, चंदामामा और रविवार के अखबार का वो जादुई बचपन—अब आपकी जेब में।"**

**Nostalgia Reader** is an Android application engineered to preserve, celebrate, and read classic Indian childhood magazines, vintage comics, and retro Sunday newspaper comic strips.

---

## 📥 Download Direct APK
You can install and run the tested release APK right away:
- **Direct Repository Download**: [nostalgia-reader-v1.0.0.apk](./apk/nostalgia-reader-v1.0.0.apk)
- **GitHub Release Download**: [Download from Releases](https://github.com/ashirvadraj/nostalgia-reader-app/releases/tag/v1.0.0)

---

## 🌟 Featured Magazines & Collections

### 1. 🐰 चंपक (Champak Collection)
- **जून 1994 विशेषांक**: चीकू खरगोश और शिकारी भालू की चतुराई
- **दिवाली विशेषांक 1998**: चंपावन की रंगोली और खोया खजाना
- **Classic English Edition**: Cheeku the Clever Rabbit & Friends

### 2. 🌳 नंदन (Nandan Archives)
- **बाल विशेषांक 1989**: नंदन वन का जादुई घड़ा और लालची मुखिया का न्याय
- **अकबर और बीरबल**: दुनिया का सबसे बड़ा हथियार (आत्मविश्वास)
- **बाल वैज्ञानिक**: घर पर बनाएं अपना पेरिस्कोप

### 3. 🌙 चंदामामा (Chandamama Classics)
- **जनवरी 1984 विशेषांक**: विक्रम और बेताल — तीन वरदान और सच्चा साधक
- **राजा भोज और स्वाभिमानी किसान**: मालवा साम्राज्य की नैतिक कथाएँ

### 4. ⚡ चाचा चौधरी व प्राण कॉमिक्स (Pran Comics)
- **चाचा चौधरी और साबू का दिमाग**: *"चाचा चौधरी का दिमाग कंप्यूटर से भी तेज़ चलता है"* और *"जब साबू को गुस्सा आता है तो ज्वालामुखी फटता है!"*
- **बिल्लू का क्रिकेट मैच**: माथे पर झूलते बालों वाला बिल्लू, बजरी और कर्नल ढिल्लों की खिड़की!

### 5. 🏹 अमर चित्र कथा व टिंकल (Amar Chitra Katha & Tinkle)
- **अमर चित्र कथा**: पंचतंत्र की अमर कथाएँ (बातूनी कछुआ और दो हंस)
- **Tinkle Digest**: Shikari Shambu (शिकारी शम्भू) & Suppandi's Classic Logic

### 6. 📰 रविवार अखबार विशेषांक (Sunday Newspaper Strips)
- **अमर उजाला - नन्हे सम्राट 1995**: जासूस चीकू, 2 चित्रों में 7 अंतर ढूँढो, और संडे कॉमिक्स
- **The Phantom (वेताल) 1982 संडे स्ट्रिप**: *The Ghost Who Walks Never Dies* — दीप वुड्स का रक्षक

---

## 🛠️ Architecture Blueprint (Senior Architect Design)

- **Memory-Safe Bitmap Engine**: Childhood magazines are heavy 300 DPI scanned pages. The `BitmapMemoryOptimizer` utilizes power-of-two `inSampleSize` downsampling and `Bitmap.Config.RGB_565` decoding to reduce memory usage by **50%**, ensuring **zero OutOfMemory (OOM) crashes**.
- **Ultra-Smooth ViewPager2 Reader**: Page flip transitions with edge taps, horizontal swipes, and page jump slider.
- **Reading Themes**:
  - 📜 **कागज़ (Parchment)**: Warm authentic 90s vintage paper tint.
  - 🍂 **सीपिया (Sepia)**: Relaxed reading with reduced blue light.
  - 🌙 **नाइट मोड (Night Mode)**: Deep contrast for dark-room reading.
- **Offline Storage & Reading Progress**:
  - Automatic progress tracker: picks up on the exact page you left on.
  - "Continue Reading" prompt on home screen.
  - Offline save toggle: reads downloaded magazines with no active internet connection.
- **Storage Access Framework (SAF)**:
  - Local import: open any `.pdf`, `.cbz`, `.cbr`, or `.zip` archives directly from device storage.

---

## 🧪 Senior QA Test Certification Matrix

Before building the production APK, the Senior QA Test Suite was executed using Gradle:

| Test Suite | Area Covered | Tests Run | Result |
|---|---|:---:|:---:|
| `CatalogRepositoryTest` | Catalog integrity, Champak/Nandan/Comics presence | 5 | ✅ PASS |
| `BitmapMemoryOptimizerTest`| inSampleSize downsampling & OOM prevention | 3 | ✅ PASS |
| `ArchiveIntegratorTest` | PDF, CBZ, CBR, ZIP format detection & validation | 2 | ✅ PASS |
| `ReadingProgressTest` | Bookmark serialization & state retention | 1 | ✅ PASS |
| **Total Test Suite** | **Comprehensive Pre-Build QA Gate** | **11 / 11** | **✅ 100% PASS** |

---

## 📱 Build & Installation

### Option A: Install using ADB
```bash
adb install -r apk/nostalgia-reader-v1.0.0.apk
```

### Option B: Direct Mobile Install
1. Download `nostalgia-reader-v1.0.0.apk` from the repository or GitHub Releases to your Android device.
2. Tap on the downloaded APK and select **Install**.
3. Enjoy your favorite childhood magazines!

---

## 📜 Build from Source
```bash
git clone https://github.com/ashirvadraj/nostalgia-reader-app.git
cd nostalgia-reader-app
./gradlew test
./gradlew assembleRelease
```
