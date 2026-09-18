package com.nostalgia.reader.data

import com.nostalgia.reader.model.PageContent
import com.nostalgia.reader.model.Publication
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object CatalogRepository {

    private val monthNamesHindi = listOf(
        "जनवरी", "फ़रवरी", "मार्च", "अप्रैल", "मई", "जून",
        "जुलाई", "अगस्त", "सितम्बर", "अक्टूबर", "नवम्बर", "दिसम्बर"
    )

    private val monthNamesEnglish = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    private val staticPublications: MutableList<Publication> = mutableListOf(
        Publication(
            id = "champak-2026-aug",
            title = "चंपक - अगस्त 2026 (चीकू और रोबोटिक वन)",
            category = "MAGAZINE",
            series = "Champak",
            year = 2026,
            month = 8,
            issueMonthName = "अगस्त 2026",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=400",
            description = "अगस्त 2026 का नवीनतम चंपक विशेषांक! चंपावन में तकनीक और प्रकृति का अनोखा मेल। चीकू खरगोश और एआई रोबोट की जुगलबंदी।",
            pageCount = 6,
            pages = listOf(
                PageContent(1, null, "चंपावन में अगस्त की रिमझिम", "अगस्त का महीना आते ही चंपावन में स्वतंत्रता दिवस की उमंग छा गई। चीकू खरगोश और शेरू राजा ने तिरंगा फहराया।", "संपादकीय"),
                PageContent(2, null, "चीकू खरगोश और स्मार्ट वन रोबोट", "शहर से एक नन्हा सौर-ऊर्जा संचालित रोबोट भटक कर चंपावन में आ पहुँचा। चीकू खरगोश ने अपनी समझदारी से वन को आग से बचा लिया!", "मुख्य कथा"),
                PageContent(3, null, "मीकू चूहा और रेन-वाटर हार्वेस्टिंग", "मीकू चूहे ने इस मानसून में अपनी बिल के पास बाँस की नलियों से वर्षा जल संचयन का मॉडल तैयार किया...", "बाल विज्ञान"),
                PageContent(4, null, "चित्र-कथा: डमडम बंदर का ड्रोन", "डमडम बंदर को एक पेड़ की डाल पर फंसा हुआ ड्रोन मिला...", "चित्र-कथा"),
                PageContent(5, null, "अगस्त 2026 नटखट पहेलियाँ व चुटकुले", "पानी से पैदा होता, पानी में ही खो जाता, बादल जब गरजें आसमान में, धरती पर मुस्काता? (उत्तर: वर्षा की बूँद)", "हास्य"),
                PageContent(6, null, "चंपक मासिक सीख (अगस्त 2026)", "प्रकृति हमारी माता है और तकनीक हमारा औजार। दोनों का संतुलन ही हमारी सुंदर धरती को हरा-भरा रख सकता है।", "सीख")
            )
        ),
        Publication(
            id = "champak-1994-jun",
            title = "चंपक - जून 1994 (चीकू और शिकारी भालू)",
            category = "MAGAZINE",
            series = "Champak",
            year = 1994,
            month = 6,
            issueMonthName = "जून 1994",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=400",
            description = "बचपन की सबसे प्रिय चंपक! इस अंक में चीकू खरगोश की चतुराई, चंपावन में शेरू सिंह का जन्मदिन।",
            pageCount = 6,
            pages = listOf(
                PageContent(1, null, "चंपावन का सवेरा और चीकू खरगोश", "चंपावन के घने जंगल में सवेरा होते ही चीकू खरगोश अपनी माँ से गाजर लेकर निकला।"),
                PageContent(2, null, "कालू कौवे की जासूसी और जादुई रस्सी", "कालू कौवा ऊँचे बरगद के पेड़ पर बैठकर पूरे जंगल पर नज़र रखता था।"),
                PageContent(3, null, "चंपावन में जश्न और शेरू राजा का इनाम", "जब शेरू राजा बाहर निकले, तो शिकारी भालू को जाल में छटपटाते देखकर दंग रह गए।"),
                PageContent(4, null, "चित्र-कथा: डमडम बंदर और चश्मे वाली नानी", "डमडम बंदर को एक दिन पेड़ के नीचे एक गोल फ्रेम वाला चश्मा मिला।"),
                PageContent(5, null, "नटखट पहेलियाँ और लोटपोट", "हरी थी मन भरी थी, लाख मोती जड़ी थी..."),
                PageContent(6, null, "सीख और संदेश", "मुसीबत के समय हिम्मत और बुद्धि ही मनुष्य और पशु का सच्चा मित्र होती है।")
            )
        ),
        Publication(
            id = "nandan-2026-aug",
            title = "नंदन - अगस्त 2026 (अमृत महोत्सव अंक)",
            category = "MAGAZINE",
            series = "Nandan",
            year = 2026,
            month = 8,
            issueMonthName = "अगस्त 2026",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1497633762265-9d179a990aa6?w=400",
            description = "अगस्त 2026 का विशेष नंदन अंक! भारत के गौरवशाली इतिहास, नंदन वन के अमर किस्से।",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "नंदन वन में स्वतंत्रता का उल्लास", "नंदन वन के विशाल सरोवर तट पर राष्ट्रीय ध्वज फहराया गया।"),
                PageContent(2, null, "बीरबल की चतुराई: बादलों का माप", "अकबर ने पूछा—बीरबल, इस सावन में कितने बादल बरसे?"),
                PageContent(3, null, "बाल वैज्ञानिक: सौर ऊर्जा नाव", "नन्हे पाठकों के लिए घर पर थर्माकोल और छोटी सोलर मोटर से स्वचालित नाव बनाने की विधि।"),
                PageContent(4, null, "नंदन कविता: रिमझिम सावन आया", "काले-काले बादल छाए, मोर पपीहा खुशी मनाए!"),
                PageContent(5, null, "नंदन बाल संदेश", "सच्ची आजादी वही है जो हमें ज्ञान और आत्मनिर्भरता की ओर ले जाए।")
            )
        ),
        Publication(
            id = "nandan-1989-bal",
            title = "नंदन - बाल विशेषांक 1989 (नंदन वन)",
            category = "MAGAZINE",
            series = "Nandan",
            year = 1989,
            month = 11,
            issueMonthName = "नवम्बर 1989",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1497633762265-9d179a990aa6?w=400",
            description = "हिन्दुस्तान टाइम्स पब्लिकेशन की अमर बाल पत्रिका 'नंदन'! राजा बीरबल के किस्से।",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "नंदन वन का जादुई घड़ा", "एक गरीब किसान रामू को अपने खेत में हल चलाते समय एक पुराना मिट्टी का घड़ा मिला।"),
                PageContent(2, null, "लालची मुखिया और न्याय", "गाँव के लालची मुखिया को जब इस घड़े का पता चला, तो उसने धोखे से रामू से घड़ा छीन लिया।"),
                PageContent(3, null, "अकबर-बीरबल: सबसे बड़ा हथियार", "बीरबल ने उत्तर दिया—जहाँपनाह, आत्मविश्वास ही सबसे बड़ा हथियार है।"),
                PageContent(4, null, "विज्ञान की दुनिया: पेरिस्कोप", "नन्हे दोस्तों! दो दर्पणों से आप घर में पेरिस्कोप बना सकते हैं।"),
                PageContent(5, null, "नंदन सीख", "सदा मीठी वाणी बोलो और सबकी सहायता करो।")
            )
        ),
        Publication(
            id = "chandamama-1984-jan",
            title = "चंदामामा - जनवरी 1984 (विक्रम और बेताल)",
            category = "MAGAZINE",
            series = "Chandamama",
            year = 1984,
            month = 1,
            issueMonthName = "जनवरी 1984",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1457369804613-52c61a468e7d?w=400",
            description = "भारतीय संस्कृति और पौराणिक कथाओं की कालजयी धरोहर 'चंदामामा'!",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "विक्रम और बेताल: तीन वरदान", "अमावस्या की घोर काली रात में राजा विक्रम श्मशान के प्रेत-वृक्ष से बेताल को कंधे पर लादकर ले जा रहे थे..."),
                PageContent(2, null, "बेताल का जटिल प्रश्न", "कुछ वर्षों बाद, धनवान युवक चोरों के डर से पागल हो गया। रूपवान युवक घमंड में अकेला रह गया..."),
                PageContent(3, null, "राजा विक्रम का न्याय", "राजा विक्रम ने निर्भीक होकर उत्तर दिया—पापी केवल वह धनवान था, जिसने समाज की उपेक्षा की..."),
                PageContent(4, null, "राजा भोज और किसान", "मालवा के अधिपति राजा भोज जब वेश बदलकर प्रजा का हाल जानने निकले..."),
                PageContent(5, null, "चंदामामा का संदेश", "सच्चा ज्ञान वही है जो मनुष्य को अहंकार से मुक्त करे और कर्मठ बनाए।")
            )
        ),
        Publication(
            id = "chacha-chaudhary-sabu",
            title = "चाचा चौधरी और साबू का दिमाग (प्राण कॉमिक्स)",
            category = "COMIC",
            series = "Chacha Chaudhary",
            year = 1991,
            month = 5,
            issueMonthName = "मई 1991",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1578632767115-351597cf2477?w=400",
            description = "कार्टूनिस्ट प्राण की अमर कृति! 'चाचा चौधरी का दिमाग कंप्यूटर से भी तेज़ चलता है' और 'जब साबू को गुस्सा आता है तो ज्वालामुखी फटता है!'",
            pageCount = 6,
            pages = listOf(
                PageContent(1, null, "पैनल 1: साबू की भूख", "चाचा चौधरी चौपाल पर बैठे हैं। साबू 108 पराठे खा रहा है..."),
                PageContent(2, null, "पैनल 2: डाकू गोबर सिंह", "बैंक का सायरन बजता है। डाकू गोबर सिंह थैलों में नोट भरकर भाग रहे हैं..."),
                PageContent(3, null, "पैनल 3: कंप्यूटर से तेज़ दिमाग", "चाचा चौधरी ने जीप के टायरों के निशान देखे और शॉर्टकट बताया..."),
                PageContent(4, null, "पैनल 4: साबू का क्रोध", "साबू दोनों हाथों से जीप को हवा में उठा लेता है!"),
                PageContent(5, null, "पैनल 5: चाची की डाँट", "चाची हाथ में बेलन लिए खड़ी हैं। दुनिया का हर कंप्यूटर यहाँ हैंग हो जाता है!"),
                PageContent(6, null, "प्राण कॉमिक्स यादगार नोट", "बिल्लू, पिंकी, रमन और साबू—भारतीय कॉमिक्स का अमर युग।")
            )
        ),
        Publication(
            id = "billoo-cricket-match",
            title = "बिल्लू का क्रिकेट मैच (प्राण कॉमिक्स 1993)",
            category = "COMIC",
            series = "Billoo",
            year = 1993,
            month = 4,
            issueMonthName = "अप्रैल 1993",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1540747913346-19e32dc3e97e?w=400",
            description = "माथे पर झूलते बालों वाला प्यारा बिल्लू, उसका दोस्त गबरू और बजरी!",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "मोहल्ले का विश्वकप", "बिल्लू अपनी टोली के साथ खाली मैदान में उतरा। बाल उसकी आँखों पर झूल रहे थे।"),
                PageContent(2, null, "कर्नल ढिल्लों की खिड़की", "बिल्लू ने पूरी ताकत से बल्ला घुमाया—गेंद सीधे कर्नल ढिल्लों के ड्राइंग रूम की खिड़की पर जा लगी!"),
                PageContent(3, null, "बिल्लू की हाज़िरजवाबी", "बिल्लू: कर्नल अंकल! मैंने तो आपकी खिड़की पर बैठी छिपकली को मारा था!"),
                PageContent(4, null, "जोजो कुत्ते का कमाल", "जोजो कुत्ता गेंद को मुँह में दबाकर बाउंड्री के पार दौड़ गया!"),
                PageContent(5, null, "बचपन की यादें", "90 के दशक का सच्चा और प्यारा बचपन।")
            )
        ),
        Publication(
            id = "panchatantra-mitrabhed",
            title = "अमर चित्र कथा: पंचतंत्र की अमर कहानियाँ",
            category = "COMIC",
            series = "Amar Chitra Katha",
            year = 1982,
            month = 10,
            issueMonthName = "अक्टूबर 1982",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1532012164546-f432f2e3777a?w=400",
            description = "अनंत पई (अंकल पई) द्वारा प्रस्तुत अमर चित्र कथा! पंडित विष्णु शर्मा द्वारा रचित पंचतंत्र की नीतिपरक कहानियाँ।",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "दो हंस और बातूनी कछुआ", "एक सुंदर सरोवर में संकट और विकट नाम के दो हंस और कंबुग्रीव कछुआ रहते थे।"),
                PageContent(2, null, "लकड़ी का सहारा और चेतावनी", "हंसों ने तरकीब निकाली: हम लकड़ी को चोंच में पकड़ेंगे और तुम बीच में दाँतों से पकड़ना।"),
                PageContent(3, null, "मौन का महत्व", "जब वे गाँव के ऊपर से उड़े तो कछुआ बोल पड़ा और नीचे गिरकर नष्ट हो गया।"),
                PageContent(4, null, "पंचतंत्र का श्लोक", "सुहृदां हितकामानां न करोतीह यो वचः। स कूर्म इव दुर्बुद्धिः काष्ठाद् भ्रष्टो विनश्यति॥"),
                PageContent(5, null, "अमर चित्र कथा विरासत", "भारतीय संस्कृति और इतिहास को हर बच्चे के दिल में अमर कर दिया।")
            )
        ),
        Publication(
            id = "tinkle-digest-shikari-shambu",
            title = "Tinkle Digest: Shikari Shambu & Suppandi",
            category = "COMIC",
            series = "Tinkle",
            year = 1995,
            month = 7,
            issueMonthName = "July 1995",
            language = "en",
            coverUrl = "https://images.unsplash.com/photo-1516979187457-637abb4f9353?w=400",
            description = "Classic English Tinkle comics by Uncle Pai! Featuring Shikari Shambu and Suppandi.",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "Shikari Shambu and the Rogue Tiger", "Shambu in his oversized pith helmet shakes with fright inside his hut..."),
                PageContent(2, null, "The Miraculous Capture", "Shambu falls onto a giant chilli net which traps the tiger!"),
                PageContent(3, null, "Suppandi's Brilliant Logic", "Suppandi buys two bottles of curd in his coat pockets!"),
                PageContent(4, null, "Tantri the Mantri", "Tantri's boomerang arrow pins himself to the tree!"),
                PageContent(5, null, "Tinkle Nostalgia", "Tinkle brought laughter to generations of kids across India.")
            )
        ),
        Publication(
            id = "newspaper-amar-ujala-1995",
            title = "अमर उजाला: नन्हे सम्राट रविवार विशेषांक 1995",
            category = "NEWSPAPER_SUNDAY",
            series = "Sunday Strips",
            year = 1995,
            month = 8,
            issueMonthName = "अगस्त 1995",
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",
            description = "रविवार की सुबह का वो दौर जब बच्चे 'नन्हे सम्राट' पन्ने के लिए लड़ पड़ते थे!",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "रविवार की सुबह का अखबार", "90 के दशक में रविवार की सुबह का अलग ही जादू था।"),
                PageContent(2, null, "रविवार कॉमिक स्ट्रिप: जासूस चीकू", "चीकू ने तोते के घोंसले से सेठ जी की हीरे जड़ी घड़ी खोज निकाली।"),
                PageContent(3, null, "दो चित्रों में 7 अंतर ढूँढें", "1. शेर की मूँछ का बाल गायब। 2. पेड़ पर तीसरे फल का रंग पीला..."),
                PageContent(4, null, "बाल प्रतिभा: चित्रकारी व कविताएँ", "संजय (कक्षा 5): 'सूरज निकला मिटा अंधेरा, देखो बच्चों हुआ सवेरा!'"),
                PageContent(5, null, "अखबार विशेषांक की सीख", "रविवार के उन पन्नों ने न केवल बच्चों में पढ़ने की आदत डाली बल्कि सोचने को प्रेरित किया।")
            )
        ),
        Publication(
            id = "newspaper-phantom-strip",
            title = "Phantom: The Ghost Who Walks (Sunday Strip 1982)",
            category = "NEWSPAPER_SUNDAY",
            series = "Sunday Strips",
            year = 1982,
            month = 3,
            issueMonthName = "March 1982",
            language = "en",
            coverUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=400",
            description = "The immortal newspaper comic strip of 'The Ghost Who Walks'!",
            pageCount = 5,
            pages = listOf(
                PageContent(1, null, "Old Jungle Saying", "When the Phantom moves, the wind stands still."),
                PageContent(2, null, "The Pirates of Morristown", "Smugglers attempt to capture relics from the Whispering Grove..."),
                PageContent(3, null, "The Mark of the Skull", "The Phantom delivers the lightning right hook with the Skull Ring."),
                PageContent(4, null, "The Good Mark of Peace", "The Bandar elders receive the Good Mark ring."),
                PageContent(5, null, "The Golden Age of Strips", "Lee Falk's Phantom was a staple of Indian Sunday newspapers.")
            )
        )
    )

    fun getDailyNewspapers(dateString: String = getCurrentDateFormatted()): List<Publication> {
        return listOf(
            Publication(
                id = "newspaper-dainik-jagran",
                title = "दैनिक जागरण (Dainik Jagran) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Dainik Jagran",
                year = 2026,
                month = 9,
                issueMonthName = "सितम्बर 2026",
                language = "hi",
                coverUrl = "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=400",
                description = "दैनिक जागरण — भारत का सर्वाधिक प्रसारित हिन्दी दैनिक समाचार पत्र। राष्ट्रीय, संपादकीय, राजनीति और खेल।",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "नई दिल्ली / राष्ट्रीय",
                epaperUrl = "https://epaper.jagran.com/",
                pages = generateNewspaperPages("दैनिक जागरण", dateString, "hi")
            ),
            Publication(
                id = "newspaper-dainik-bhaskar",
                title = "दैनिक भास्कर (Dainik Bhaskar) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Dainik Bhaskar",
                year = 2026,
                month = 9,
                issueMonthName = "सितम्बर 2026",
                language = "hi",
                coverUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",
                description = "दैनिक भास्कर — निष्पक्ष और सटीक पत्रकारिता। राष्ट्रीय घटनाक्रम, राज्यों की हलचल, नो-बकवास विश्लेषण।",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "दिल्ली व राष्ट्रीय",
                epaperUrl = "https://www.bhaskar.com/epaper/",
                pages = generateNewspaperPages("दैनिक भास्कर", dateString, "hi")
            ),
            Publication(
                id = "newspaper-amar-ujala",
                title = "अमर उजाला (Amar Ujala) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Amar Ujala",
                year = 2026,
                month = 9,
                issueMonthName = "सितम्बर 2026",
                language = "hi",
                coverUrl = "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=400",
                description = "अमर उजाला — उत्तर भारत का अग्रणी समाचार पत्र। सटीक खबरें, रोज़गार, संपादकीय और खेल।",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "दिल्ली / एनसीआर",
                epaperUrl = "https://epaper.amarujala.com/",
                pages = generateNewspaperPages("अमर उजाला", dateString, "hi")
            ),
            Publication(
                id = "newspaper-navbharat-times",
                title = "नवभारत टाइम्स (Navbharat Times) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Navbharat Times",
                year = 2026,
                month = 9,
                issueMonthName = "सितम्बर 2026",
                language = "hi",
                coverUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",
                description = "नवभारत टाइम्स (NBT) — टाइम्स समूह का प्रमुख हिन्दी दैनिक समाचार पत्र।",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "दिल्ली / मुंबई",
                epaperUrl = "https://navbharattimes.indiatimes.com/",
                pages = generateNewspaperPages("नवभारत टाइम्स", dateString, "hi")
            ),
            Publication(
                id = "newspaper-hindustan",
                title = "हिन्दुस्तान (Hindustan) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Hindustan",
                year = 2026,
                month = 9,
                issueMonthName = "सितम्बर 2026",
                language = "hi",
                coverUrl = "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=400",
                description = "हिन्दुस्तान — भरोसा नए हिन्दुस्तान का। ताज़ा खबरें और प्रामाणिक विश्लेषण।",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "राष्ट्रीय संस्करण",
                epaperUrl = "https://epaper.livehindustan.com/",
                pages = generateNewspaperPages("हिन्दुस्तान", dateString, "hi")
            ),
            Publication(
                id = "newspaper-rajasthan-patrika",
                title = "राजस्थान पत्रिका (Patrika) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Rajasthan Patrika",
                year = 2026,
                month = 9,
                issueMonthName = "सितम्बर 2026",
                language = "hi",
                coverUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",
                description = "राजस्थान पत्रिका — निर्भीक पत्रकारिता की मिसाल। बालहंस के प्रकाशक द्वारा प्रस्तुत प्रमुख हिन्दी दैनिक।",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "जयपुर / नई दिल्ली",
                epaperUrl = "https://epaper.patrika.com/",
                pages = generateNewspaperPages("राजस्थान पत्रिका", dateString, "hi")
            ),
            Publication(
                id = "newspaper-the-hindu",
                title = "The Hindu (National Edition) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "The Hindu",
                year = 2026,
                month = 9,
                issueMonthName = "September 2026",
                language = "en",
                coverUrl = "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=400",
                description = "The Hindu — India's premier national newspaper renowned for incisive journalism, authoritative editorials, and international affairs.",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "All-India National",
                epaperUrl = "https://epaper.thehindu.com/",
                pages = generateNewspaperPages("The Hindu", dateString, "en")
            ),
            Publication(
                id = "newspaper-indian-express",
                title = "The Indian Express - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "The Indian Express",
                year = 2026,
                month = 9,
                issueMonthName = "September 2026",
                language = "en",
                coverUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",
                description = "The Indian Express — Journalism of Courage. Famous for its Explained section, investigative journalism, and op-ed pages.",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "New Delhi / Mumbai",
                epaperUrl = "https://indianexpress.com/todays-paper/",
                pages = generateNewspaperPages("The Indian Express", dateString, "en")
            ),
            Publication(
                id = "newspaper-times-of-india",
                title = "The Times of India (TOI) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Times of India",
                year = 2026,
                month = 9,
                issueMonthName = "September 2026",
                language = "en",
                coverUrl = "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=400",
                description = "The Times of India — India's largest circulating English-language daily newspaper. Complete national and business coverage.",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "Metro Editions",
                epaperUrl = "https://epaper.indiatimes.com/",
                pages = generateNewspaperPages("The Times of India", dateString, "en")
            ),
            Publication(
                id = "newspaper-economic-times",
                title = "The Economic Times (ET) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Economic Times",
                year = 2026,
                month = 9,
                issueMonthName = "September 2026",
                language = "en",
                coverUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",
                description = "The Economic Times — India's #1 financial and business daily. Stock markets, macroeconomics, tech startups, and wealth.",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "Financial Capital Mumbai",
                epaperUrl = "https://epaper.indiatimes.com/timesepaper/publication-the-economic-times.cms",
                pages = generateNewspaperPages("The Economic Times", dateString, "en")
            ),
            Publication(
                id = "newspaper-livemint",
                title = "Mint (WSJ Partner) - $dateString",
                category = "NEWSPAPER_DAILY",
                series = "Mint",
                year = 2026,
                month = 9,
                issueMonthName = "September 2026",
                language = "en",
                coverUrl = "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=400",
                description = "Mint — Premium business daily providing sharp analysis on policy, technology, macroeconomic indicators, and personal finance.",
                pageCount = 8,
                isDailyNewspaper = true,
                editionCity = "National Edition",
                epaperUrl = "https://epaper.livemint.com/",
                pages = generateNewspaperPages("Mint", dateString, "en")
            )
        )
    }

    private fun generateNewspaperPages(paperName: String, dateString: String, lang: String): List<PageContent> {
        return if (lang == "hi") {
            listOf(
                PageContent(1, null, "$paperName : आज की प्रमुख सुर्खियाँ ($dateString)", "■ भारतीय अर्थव्यवस्था में रिकॉर्ड वृद्धि: जीडीपी दर में निरंतर उछाल।\n■ सेमीकंडक्टर निर्माण में भारत की ऐतिहासिक छलांग, लाखों नए रोजगार के अवसर।\n■ संसद सत्र: जनहित से जुड़े महत्वपूर्ण विधेयकों पर चर्चा।\n■ मानसून की संतोषजनक स्थिति से किसानों के चेहरे खिले।", "मुखपृष्ठ"),
                PageContent(2, null, "$paperName संपादकीय : आत्मनिर्भरता का पथ", "संपादकीय दृष्टिकोण: वर्तमान वैश्विक परिदृश्य में आत्मनिर्भरता ही देश की सुरक्षा और आर्थिक स्वतंत्रता का मूल आधार है।", "संपादकीय"),
                PageContent(3, null, "देश भर के प्रमुख राष्ट्रीय घटनाक्रम", "1. इसरो के आगामी सौर एवं अंतरिक्ष मिशन की तैयारियां पूर्ण।\n2. वंदे भारत एक्सप्रेस नेटवर्क का तेज विस्तार।\n3. राष्ट्रीय राजमार्गों पर नई तकनीक का प्रयोग।", "राष्ट्रीय"),
                PageContent(4, null, "बाजार व अर्थव्यवस्था: सेंसेक्स में तेजी", "■ बीएसई सेंसेक्स और निफ्टी नए रिकॉर्ड स्तर पर पहुंचे।\n■ भारतीय रिजर्व बैंक की मौद्रिक नीति ने मुद्रास्फीति को नियंत्रित रखा।", "व्यापार"),
                PageContent(5, null, "खेल मैदान: भारतीय खिलाड़ियों का परचम", "■ अंतरराष्ट्रीय क्रिकेट श्रृंखला में भारतीय टीम की शानदार जीत।\n■ विश्व एथलेटिक्स में भारतीय धावकों ने जीते पदक।", "खेल"),
                PageContent(6, null, "नवाचार: अगली पीढ़ी का सुपरकंप्यूटिंग", "वैज्ञानिकों ने स्वास्थ्य और कृषि क्षेत्र के लिए स्वदेशी आर्टिफिशियल इंटेलिजेंस मॉडल का सफल परीक्षण किया।", "विज्ञान"),
                PageContent(7, null, "वैश्विक मंच: भारत की कूटनीतिक सफलता", "संयुक्त राष्ट्र में भारत ने शांति और ग्लोबल साउथ के हितों की जोरदार वकालत की।", "विदेश"),
                PageContent(8, null, "रविवार विशेषांक, साहित्य व स्वास्थ्य", "आयुर्वेद और योग से आधुनिक तनाव को दूर करने के प्रामाणिक उपाय। सुडोकू और वर्ग पहेली।", "जीवनशैली")
            )
        } else {
            listOf(
                PageContent(1, null, "$paperName : National Headlines ($dateString)", "■ Macroeconomic Resilience: Global rating agencies reaffirm India's robust growth trajectory.\n■ Semiconductor Revolution: Major indigenous fabrication units commence pilot production.\n■ Digital Public Infrastructure: Record UPI and digital payment milestones achieved.", "Front Page"),
                PageContent(2, null, "$paperName Editorial : Technological Sovereignty", "Lead Editorial: As the global order transitions toward multi-polarity, technological independence in AI and green energy represents the cornerstone of national autonomy.", "Editorial"),
                PageContent(3, null, "Governance, Judiciary & State Round-up", "1. Supreme Court delivers crucial verdict on digital rights.\n2. National Green Hydrogen Mission receives accelerated state investments.\n3. Infrastructure corridors achieve 98% electrification milestones.", "National"),
                PageContent(4, null, "Financial Markets : Sensex, Nifty & Tech Trends", "■ Benchmark indices trade near record highs led by automobile and tech sectors.\n■ RBI keeps monetary policy stance aligned with sustainable growth.", "Business"),
                PageContent(5, null, "Sports Arena : Indian Champions on Global Stage", "■ Cricket & Olympic disciplines: Indian athletes score historic podium finishes.\n■ Chess Grandmasters: Indian prodigies dominate world championship tournaments.", "Sports"),
                PageContent(6, null, "Innovation : Space Station & Quantum Tech", "ISRO finalizes architecture modules for the Bharatiya Antariksh Station (BAS). High-altitude satellite links validated.", "Science"),
                PageContent(7, null, "Geopolitics : Multilateral Summits", "India underscores non-violent conflict resolution and food security at the global summit.", "World"),
                PageContent(8, null, "Arts, Literature & Weekend Puzzles", "Exhibition of Indian classic folk paintings. Daily cryptic crossword, chess puzzle, and reviews.", "Life")
            )
        }
    }

    fun getOrFetchMonthlyIssue(series: String, month: Int, year: Int): Publication {
        val safeMonth = month.coerceIn(1, 12)
        val monthNameHi = monthNamesHindi[safeMonth - 1]
        val monthNameEn = monthNamesEnglish[safeMonth - 1]

        val id = "${series.lowercase().replace(" ", "-")}-$year-${monthNameEn.lowercase().take(3)}"

        val existing = staticPublications.find { it.id == id }
        if (existing != null) return existing

        val matched = staticPublications.find {
            it.series.equals(series, ignoreCase = true) && it.year == year && it.month == safeMonth
        }
        if (matched != null) return matched

        val isHindi = !series.equals("Tinkle", ignoreCase = true)
        val lang = if (isHindi) "hi" else "en"
        val title = if (isHindi) "$series - $monthNameHi $year" else "$series - $monthNameEn $year"
        val monthLabel = if (isHindi) "$monthNameHi $year" else "$monthNameEn $year"

        val generatedPub = Publication(
            id = id,
            title = title,
            category = if (series.contains("Comics", ignoreCase = true) || series == "Tinkle" || series.contains("Chaudhary")) "COMIC" else "MAGAZINE",
            series = series,
            year = year,
            month = safeMonth,
            issueMonthName = monthLabel,
            language = lang,
            coverUrl = "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=400",
            description = "$monthLabel का संपूर्ण विशेषांक! इसमें $series की सभी लोकप्रिय कहानियाँ, बाल कथाएँ, चित्र-कथाएँ, ज्ञान-विज्ञान और पहेलियाँ पूर्ण रूप से संकलित हैं।",
            pageCount = 6,
            sourceUrl = "https://archive.org/search?query=${series.replace(" ", "+")}+$year+$monthNameEn",
            pages = listOf(
                PageContent(1, null, "$monthLabel का संपादकीय व स्वागत", "$series के प्रिय दोस्तों! $monthLabel के इस अंक में आप सबका हार्दिक स्वागत है। इस महीने आपके लिए चंपावन और बाल संसार की सबसे मनपसंद कहानियाँ संजोई गई हैं।", "संपादकीय"),
                PageContent(2, null, "$series : चीकू और चालाक लोमड़ी की कहानी", "जंगल में सवेरा होते ही सभी जानवर इकट्ठा हुए। लोमड़ी ने सोचा कि आज वह मीकू चूहे को बहकाएगी। लेकिन चीकू खरगोश ने समय रहते लोमड़ी की चाल पहचान ली।", "कहानी 1"),
                PageContent(3, null, "$series : बीरबल और जादुई रस्सी का रहस्य", "गाँव में हुई चोरी का पता लगाने के लिए बीरबल ने सभी संदिग्धों को बराबर लंबाई की रस्सियाँ दीं। चोर ने डर के मारे रात में अपनी रस्सी दो इंच काट ली और सुबह पकड़ा गया!", "कहानी 2"),
                PageContent(4, null, "$series : डमडम बंदर की नई शरारत", "डमडम बंदर ने सोचा कि आज वह जंगल का राजा बनेगा। उसने शेर की खाल ओढ़ ली। लेकिन जैसे ही उसने बात की, उसकी आवाज़ ने उसका राज खोल दिया।", "चित्र-कथा"),
                PageContent(5, null, "$monthLabel की चुनिंदा पहेलियाँ व चुटकुले", "1. एक ऐसा नाम बताओ जो एक फल भी है और एक रंग भी? (उत्तर: संतरा)\n2. दो अक्षर का मेरा नाम, सिर पर मेरे ताज? (उत्तर: मोर)\n\nलोटपोट: टीचर: बताओ भारत की राजधानी कहाँ है? छात्र: सर, जहाँ सरकार चाहे!", "हास्य"),
                PageContent(6, null, "$series संदेश व सीख", "सदैव सत्य और परिश्रम के मार्ग पर चलें। कठिन परिस्थितियों में शांत मन और बुद्धिमानी से काम लेने पर हर समस्या का हल निकल आता है।", "सीख")
            )
        )

        staticPublications.add(generatedPub)
        return generatedPub
    }

    fun getAllPublications(includeDailyNewspapers: Boolean = true): List<Publication> {
        val list = mutableListOf<Publication>()
        list.addAll(staticPublications)
        if (includeDailyNewspapers) {
            list.addAll(getDailyNewspapers())
        }
        return list
    }

    fun getPublicationById(id: String): Publication? {
        val all = getAllPublications(true)
        return all.find { it.id == id }
    }

    fun filterByCategory(category: String): List<Publication> {
        if (category == "ALL") return getAllPublications(true)
        val all = getAllPublications(true)
        return all.filter { it.category.equals(category, ignoreCase = true) }
    }

    fun filterBySeries(series: String): List<Publication> {
        val all = getAllPublications(true)
        return all.filter { it.series.contains(series, ignoreCase = true) }
    }

    fun filterByDecade(decade: String): List<Publication> {
        val all = getAllPublications(true)
        return when (decade) {
            "1970s" -> all.filter { it.year in 1970..1979 }
            "1980s" -> all.filter { it.year in 1980..1989 }
            "1990s" -> all.filter { it.year in 1990..1999 }
            "2000s" -> all.filter { it.year in 2000..2009 }
            "2020s" -> all.filter { it.year in 2020..2029 }
            else -> all
        }
    }

    fun filterByMonthAndYear(month: Int?, year: Int?): List<Publication> {
        val all = getAllPublications(true)
        return all.filter { pub ->
            val matchesMonth = month == null || pub.month == month
            val matchesYear = year == null || pub.year == year
            matchesMonth && matchesYear
        }
    }

    fun searchPublications(query: String): List<Publication> {
        val q = query.trim().lowercase()
        val all = getAllPublications(true)
        if (q.isEmpty()) return all
        return all.filter {
            it.title.lowercase().contains(q) ||
            it.series.lowercase().contains(q) ||
            it.description.lowercase().contains(q) ||
            it.year.toString().contains(q) ||
            (it.issueMonthName ?: "").lowercase().contains(q) ||
            (it.editionCity ?: "").lowercase().contains(q) ||
            it.pages.any { p -> (p.storyTitle ?: "").lowercase().contains(q) || (p.storyText ?: "").lowercase().contains(q) }
        }
    }

    fun getCurrentDateFormatted(): String {
        return try {
            val sdf = SimpleDateFormat("dd MMMM yyyy", Locale("hi", "IN"))
            sdf.format(Date())
        } catch (e: Exception) {
            "19 September 2026"
        }
    }

    fun getMonthNamesHindi(): List<String> = monthNamesHindi
    fun getMonthNamesEnglish(): List<String> = monthNamesEnglish
}
