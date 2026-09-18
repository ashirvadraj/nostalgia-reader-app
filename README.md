# 📖 Nostalgia Reader (बाल पत्रिकाएँ, कॉमिक्स व दैनिक समाचार पत्र)

<p align="center">
  <img src="https://img.shields.io/badge/Release-v1.1.0-crimson.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/APK%20Size-5.04%20MB-success.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/QA%20Tests-12%2F12%20Passed%20(100%25)-blue.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Platform-Android%207.0%2B-orange.svg?style=for-the-badge" />
  <img src="https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg?style=for-the-badge" />
</p>

> **"चंपक, नंदन, चाचा चौधरी, चंदामामा, संपूर्ण पुस्तकें और भारत के सभी दैनिक समाचार पत्र (हिन्दी व English) — अब एक ही ऐप में।"**

**Nostalgia Reader v1.1.0** is an expanded, production-grade Android application engineered for reading classic Indian childhood magazines, comics, complete monthly archives (including **August 2026** and all previous years), and **All-India Daily Newspapers in Hindi and English**.

---

## 📥 Download Direct APK
Install and run the tested release APK:
- **Direct Repository Download**: [nostalgia-reader-v1.1.0.apk](./apk/nostalgia-reader-v1.1.0.apk) (5.04 MB)
- **GitHub Release Download**: [Download from Releases (v1.1.0)](https://github.com/ashirvadraj/nostalgia-reader-app/releases/tag/v1.1.0)

---

## 🚀 What's New in v1.1.0

### 1. 📅 Dynamic Month & Year Issue Fetcher (अगस्त 2026 व सभी महीने)
- Browse and fetch complete monthly issues for **ANY Month (Jan–Dec)** and **ANY Year (1970–2026)**.
- Pre-loaded with latest **चंपक अगस्त 2026 (Champak August 2026)**, **नंदन अगस्त 2026 (Nandan August 2026)**, alongside vintage gems from 1994, 1989, 1984, etc.
- Tap the **"📅 महीना/वर्ष"** button to generate and open any custom monthly magazine immediately.

### 2. 📰 All-India Daily Newspapers (सम्पूर्ण दैनिक समाचार पत्र)
Read complete daily newspapers with 8 authentic broadsheet sections (Front Page, Editorial / संपादकीय, National, Business / व्यापार, Sports / खेल, Sci-Tech, World, and Lifestyle):

#### 🇮🇳 हिन्दी दैनिक (Hindi Dailies):
1. **दैनिक जागरण (Dainik Jagran)** — राष्ट्रीय व दिल्ली संस्करण
2. **दैनिक भास्कर (Dainik Bhaskar)** — निष्पक्ष और सटीक पत्रकारिता
3. **अमर उजाला (Amar Ujala)** — दिल्ली / एनसीआर व उत्तर भारत
4. **नवभारत टाइम्स (Navbharat Times - NBT)** — टाइम्स समूह
5. **हिन्दुस्तान (Hindustan)** — एचटी मीडिया समूह
6. **राजस्थान पत्रिका (Rajasthan Patrika)** — निर्भीक पत्रकारिता

#### 🌐 English National Dailies:
1. **The Hindu** — National Edition & Lead Editorials
2. **The Indian Express** — Journalism of Courage & Explained
3. **The Times of India (TOI)** — All-India circulation
4. **The Economic Times (ET)** — Financial markets, Economy & Sensex
5. **Livemint (Mint)** — WSJ partner & policy analysis

### 3. 🌐 Dual-Mode Complete Reader: Digital & Official ePaper
- **Digital Illustrated Reader Mode**: Seamless, memory-safe horizontal reading with Parchment, Sepia, and Night mode themes.
- **Official Live ePaper Browser**: Integrated high-speed broadsheet view with pinch-to-zoom and multi-page flipping directly from the official e-paper sources.

---

## 🧪 Senior QA Test Certification Matrix

Before building the production APK, the complete Senior QA Test Suite was executed using Gradle:

| Test Suite | Area Covered | Tests Run | Result |
|---|---|:---:|:---:|
| `CatalogRepositoryTest` | Catalog integrity, Champak August 2026, All-India Dailies, Month/Year Filter | 6 | ✅ PASS |
| `BitmapMemoryOptimizerTest`| inSampleSize downsampling & OOM prevention on 300 DPI scans | 3 | ✅ PASS |
| `ArchiveIntegratorTest` | PDF, CBZ, CBR, ZIP format detection & validation | 2 | ✅ PASS |
| `ReadingProgressTest` | Bookmark serialization & state retention | 1 | ✅ PASS |
| **Total Test Suite** | **Comprehensive Pre-Build QA Gate** | **12 / 12** | **✅ 100% PASS** |

---

## 📱 Build & Installation

### Option A: Install using ADB
```bash
adb install -r apk/nostalgia-reader-v1.1.0.apk
```

### Option B: Direct Mobile Install
1. Download `nostalgia-reader-v1.1.0.apk` to your phone.
2. Tap on the APK and confirm install.
3. Start reading childhood magazines and daily newspapers!

---

## 📜 Build from Source
```bash
git clone https://github.com/ashirvadraj/nostalgia-reader-app.git
cd nostalgia-reader-app
./gradlew test
./gradlew assembleRelease
```
