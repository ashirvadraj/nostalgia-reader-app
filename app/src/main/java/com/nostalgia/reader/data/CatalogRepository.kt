package com.nostalgia.reader.data

import com.nostalgia.reader.model.PageContent
import com.nostalgia.reader.model.Publication

object CatalogRepository {

    private val publications: List<Publication> = listOf(
        // ================= CHAMPAR / चंपक =================
        Publication(
            id = "champak-1994-jun",
            title = "चंपक - जून 1994 (चीकू और शिकारी भालू)",
            category = "MAGAZINE",
            series = "Champak",
            year = 1994,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=400",
            description = "बचपन की सबसे प्रिय चंपक! इस अंक में चीकू खरगोश की चतुराई, चंपावन में शेरू सिंह का जन्मदिन, मीकू चूहे की शरारतें, और मजेदार पहेलियाँ व चित्र-कथाएँ शामिल हैं।",
            pageCount = 6,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "चंपावन का सवेरा और चीकू खरगोश",
                    storyText = "चंपावन के घने जंगल में सवेरा होते ही चीकू खरगोश अपनी माँ से गाजर लेकर निकला। रास्ते में उसे मीकू चूहा मिला, जो घबराया हुआ था। मीकू ने कहा—'चीकू भाई! जंगल में शिकारी भालू आया है और उसने शेरू राजा की गुफा के पास जाल बिछाया है!'\n\nचीकू ने मुस्कुराते हुए कहा—'घबराओ मत मीकू! ताकत से बड़ी समझदारी होती है। चलो, कालू कौवे से मिलकर एक योजना बनाते हैं।'"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "कालू कौवे की जासूसी और जादुई रस्सी",
                    storyText = "कालू कौवा ऊँचे बरगद के पेड़ पर बैठकर पूरे जंगल पर नज़र रखता था। चीकू ने उसे इशारा किया। कालू ने ऊपर से काँव-काँव करके शिकारी भालू का सटीक ठिकाना बता दिया।\n\nचीकू ने जंगल के सभी नन्हे जानवरों को इकट्ठा किया और शिकारी के जाल के चारों ओर सूखे पत्ते और कांटे बिछा दिए। शिकारी भालू भारी कदमों से आगे बढ़ा, लेकिन जैसे ही उसने कदम रखा, वह खुद अपने ही जाल में उलझ गया!"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "चंपावन में जश्न और शेरू राजा का इनाम",
                    storyText = "जब शेरू राजा बाहर निकले, तो शिकारी भालू को जाल में छटपटाते देखकर दंग रह गए। पूरे चंपावन में चीकू की जय-जयकार होने लगी।\n\nशेरू राजा ने चीकू को 'चंपावन का सबसे चतुर सलाहकार' घोषित किया और उसे मीठी गाजरों की एक टोकरी भेंट की। चीकू ने वो सारी गाजरें मीकू और अपने सभी दोस्तों में बाँट दीं।"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "चित्र-कथा: डमडम बंदर और चश्मे वाली नानी",
                    storyText = "डमडम बंदर को एक दिन पेड़ के नीचे एक गोल फ्रेम वाला चश्मा मिला। उसने तुरंत चश्मा अपनी नाक पर टिकाया और सोचा कि अब वह जंगल का सबसे बड़ा डॉक्टर बन गया है!\n\nवह भालू के पास गया और बोला—'तुम्हें शहद से परहेज़ करना चाहिए!' भालू ने एक घुड़की दी और डमडम चश्मा फेंककर पेड़ पर चढ़ गया। सभी जानवर खिलखिलाकर हँस पड़े।"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "नटखट पहेलियाँ और लोटपोट",
                    storyText = "1. हरी थी मन भरी थी, लाख मोती जड़ी थी, राजा जी के बाग में दुशाला ओढ़े खड़ी थी? (उत्तर: भुट्टा)\n2. वो कौन सी चीज़ है जो जितनी खींची जाए, उतनी ही छोटी होती जाती है? (उत्तर: बीड़ी/सिगरेट)\n3. लाल गाय लकड़ी खाए, पानी पिए तो मर जाए? (उत्तर: आग)\n\nलोटपोट चुटकुला:\nमास्टर जी: चीकू, बताओ न्यूटन ने गुरुत्वाकर्षण की खोज कैसे की?\nचीकू: मास्टर जी, अगर न्यूटन पेड़ के नीचे न बैठकर स्कूल में पढ़ रहे होते, तो हम आज आराम कर रहे होते!"
                ),
                PageContent(
                    pageNumber = 6,
                    storyTitle = "सीख और संदेश",
                    storyText = "इस अंक की प्रेरणा:\n'मुसीबत के समय हिम्मत और बुद्धि ही मनुष्य और पशु का सच्चा मित्र होती है। संकट में घबराएं नहीं, विचार करके उपाय खोजें।'\n\nअगले अंक में पढ़ें: चीकू और जादुई झील का रहस्य!"
                )
            )
        ),

        Publication(
            id = "champak-1998-diwali",
            title = "चंपक - दिवाली विशेषांक 1998",
            category = "MAGAZINE",
            series = "Champak",
            year = 1998,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1512820790803-83ca734da794?w=400",
            description = "दिवाली 1998 का सबसे लोकप्रिय अंक! चंपावन में दीपों का उत्सव, चीकू और मीकू का रंगोली प्रतियोगिता में प्रथम पुरस्कार, और पटाखों से पर्यावरण बचाने का प्यारा संदेश।",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "चंपावन की जगमगाती दिवाली",
                    storyText = "कार्तिक मास की अमावस्या की रात थी। चंपावन का हर कोना मिट्टी के दीयों से जगमगा रहा था। चीकू खरगोश ने फूलों से अपनी गुफा के बाहर एक सुंदर रंगोली बनाई थी।\n\nतभी मीकू चूहा दौड़ता हुआ आया—'चीकू भाई, देखो मैंने सूखे पत्तों और रंग-बिरंगे बीजों से एक अनोखा दीप बनाया है!'"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "खोया खजाना और परोपकार",
                    storyText = "उत्सव के दौरान गिलहरी दादी का मोतियों का हार कहीं खो गया। सभी जानवर ढूंढने लगे। चीकू ने देखा कि एक कौवा उसे अपनी चोंच में दबाकर ले जा रहा था।\n\nचीकू ने अपनी बांसुरी की मीठी धुन बजाई। धुन सुनकर कौवा पेड़ की डाल पर बैठ गया और हार नीचे गिर पड़ा। चीकू ने दादी को हार लौटा दिया।"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "पर्यावरण मित्र दिवाली का संकल्प",
                    storyText = "शेरू राजा ने पूरे जंगल में घोषणा करवाई कि इस वर्ष कोई भी जानवर ज़हरीला धुआँ करने वाले पटाखे नहीं फोड़ेगा। केवल दीप जलेंगे और मीठे पकवान बँटेंगे।\n\nसभी जानवरों ने मिलकर आम के पत्तों और गेंदे के फूलों से पूरे जंगल को सजाया। यह चंपावन की सबसे खुशहाल दिवाली थी।"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "बाल हास्य: रोहन की दिवाली की मिठाई",
                    storyText = "रोहन की माँ ने दिवाली पर गुलाब जामुन बनाए और डिब्बे में बंद कर दिए।\nमाँ: रोहन, इस डिब्बे को मत छूना, इसमें चींटियाँ आ जाएँगी!\nरोहन (दो घंटे बाद मुँह पोंछते हुए): माँ, मैंने चींटियों से बचाने के लिए सारे गुलाब जामुन अपने पेट में छुपा दिए हैं!"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "चंपावन विशेषांक सीख",
                    storyText = "पर्व और त्योहार केवल सजावट का नाम नहीं, बल्कि अपनों के साथ खुशियाँ बाँटने और प्रकृति की रक्षा करने का पावन अवसर हैं।"
                )
            )
        ),

        // ================= NANDAN / नंदन =================
        Publication(
            id = "nandan-1989-bal",
            title = "नंदन - बाल विशेषांक 1989 (नंदन वन)",
            category = "MAGAZINE",
            series = "Nandan",
            year = 1989,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1497633762265-9d179a990aa6?w=400",
            description = "हिन्दुस्तान टाइम्स पब्लिकेशन की अमर बाल पत्रिका 'नंदन'! इसमें राजा बीरबल के किस्से, नंदन वन की शिक्षाप्रद कथा और बाल वैज्ञानिकों के रोचक प्रयोग शामिल हैं।",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "नंदन वन का जादुई घड़ा",
                    storyText = "एक गरीब किसान रामू को अपने खेत में हल चलाते समय एक पुराना मिट्टी का घड़ा मिला। जब उसने उसमें एक रोटी रखी, तो कुछ ही पलों में घड़े से सौ ताज़ा रोटियाँ निकल आईं!\n\nरामू ने लालच नहीं किया। उसने उन रोटियों से पूरे गाँव के भूखे लोगों को भोजन कराया। गाँव में अकाल का संकट टल गया।"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "लालची मुखिया और न्याय",
                    storyText = "गाँव के लालची मुखिया को जब इस घड़े का पता चला, तो उसने धोखे से रामू से घड़ा छीन लिया। मुखिया ने उसमें सोने का सिक्का डाला।\n\nलेकिन घड़े ने लालच पहचान लिया! सोने के सिक्के के बदले उसमें से मधुमक्खियों का झुंड निकला जिसने मुखिया को पूरे गाँव में दौड़ाया। मुखिया ने कान पकड़कर क्षमा माँगी।"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "अकबर-बीरबल: सबसे बड़ा हथियार",
                    storyText = "बादशाह अकबर ने दरबार में पूछा—'बीरबल, दुनिया का सबसे बड़ा हथियार क्या है?'\n\nबीरबल ने उत्तर दिया—'जहाँपनाह, आत्मविश्वास और सूझबूझ ही सबसे बड़ा हथियार है।' जब अगले दिन एक पागल हाथी दरबार की ओर छोड़ा गया, तो बीरबल ने भागने के बजाय पास लेटे कुत्ते को पूँछ से पकड़कर हाथी के मुँह पर उछाल दिया। हाथी चौंककर उल्टे पाँव भाग खड़ा हुआ।"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "विज्ञान की अनोखी दुनिया: घर में बनाएं पेरिस्कोप",
                    storyText = "नन्हे दोस्तों! दो समतल दर्पण और एक गत्ते के डिब्बे से आप पनडुब्बी में इस्तेमाल होने वाला पेरिस्कोप बना सकते हैं।\n\nदोनों दर्पणों को 45 डिग्री के कोण पर इस तरह लगाएं कि ऊपर का दृश्य नीचे बैठे-बैठे आपकी आँखों तक परावर्तित होकर पहुँच सके। आज ही इसे आजमाएं!"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "नंदन कविता: तितली और फूल",
                    storyText = "रंग-बिरंगी प्यारी तितली,\nफूल-फूल पर उड़ती फिरती।\nकलियों को मुस्काना सिखाती,\nमीठा-मीठा रस पी जाती!\n\nनन्हे बच्चों को नंदन की सीख: सदा मीठी वाणी बोलो और सबकी सहायता करो।"
                )
            )
        ),

        // ================= CHANDAMAMA / चंदामामा =================
        Publication(
            id = "chandamama-1984-jan",
            title = "चंदामामा - जनवरी 1984 (विक्रम और बेताल)",
            category = "MAGAZINE",
            series = "Chandamama",
            year = 1984,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1457369804613-52c61a468e7d?w=400",
            description = "भारतीय संस्कृति और पौराणिक कथाओं की कालजयी धरोहर 'चंदामामा'। इस अंक में विक्रम-बेताल का गूढ़ न्याय, राजा भोज की उदारता और विजयनगर साम्राज्य की वीरगाथा।",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "विक्रम और बेताल: तीन वरदान और सच्चा साधक",
                    storyText = "अमावस्या की घोर काली रात में राजा विक्रम श्मशान के प्रेत-वृक्ष से बेताल को कंधे पर लादकर ले जा रहे थे। बेताल ने कहा—'राजन! रास्ता लम्बा है, इसलिए मैं तुम्हें एक कथा सुनाता हूँ। लेकिन याद रहे, अगर तूने मौन तोड़ा, तो मैं वापस पेड़ पर जा लटकूँगा!'\n\nकथा: एक नगर में तीन युवकों ने कठोर तपस्या करके देवी से वरदान माँगे—पहले ने अकूत धन माँगा, दूसरे ने अमर सौंदर्य, और तीसरे ने केवल जन-सेवा और संतोष माँगा।"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "बेताल का जटिल प्रश्न",
                    storyText = "कुछ वर्षों बाद, धनवान युवक चोरों के डर से पागल हो गया। रूपवान युवक घमंड में अकेला रह गया। लेकिन संतोषी युवक ने कुएं खुदवाए और सदा सुखी रहा।\n\nबेताल हँसकर बोला—'बोल विक्रम! इन तीनों में सबसे बड़ा पापी कौन था? यदि जानते हुए भी तूने उत्तर नहीं दिया, तो तेरे सिर के सौ टुकड़े हो जाएँगे!'"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "राजा विक्रम का न्याय",
                    storyText = "राजा विक्रम ने निर्भीक होकर उत्तर दिया—'पापी केवल वह धनवान था, जिसने धन पाकर भी समाज और धर्म की उपेक्षा की और केवल संचय में जीवन व्यर्थ किया।'\n\nराजा के बोलते ही बेताल खिलखिलाकर हँसा और फिर से उड़कर पेड़ की डाल पर जा लटका। राजा विक्रम पुनः तलवार खींचकर शव को उतारने चल पड़े।"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "राजा भोज और विद्वान किसान",
                    storyText = "मालवा के अधिपति राजा भोज जब वेश बदलकर प्रजा का हाल जानने निकले, तो खेत में एक किसान को कठिन धूप में कविता पाठ करते सुना।\n\nराजा ने प्रसन्न होकर उसे स्वर्ण मुद्राएँ दीं। किसान ने कहा—'महाराज! परिश्रम का अन्न ही सच्चा सुख देता है, दान का धन नहीं।' राजा किसान के स्वाभिमान के कायल हो गए।"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "चंदामामा का संदेश",
                    storyText = "सच्चा ज्ञान वही है जो मनुष्य को अहंकार से मुक्त करे और कर्मठ बनाए। धर्म, धैर्य और सत्य ही जीवन के वास्तविक आधार हैं।"
                )
            )
        ),

        // ================= CHACHA CHAUDHARY & PRAN COMICS =================
        Publication(
            id = "chacha-chaudhary-sabu",
            title = "चाचा चौधरी और साबू का दिमाग (प्राण कॉमिक्स)",
            category = "COMIC",
            series = "Chacha Chaudhary",
            year = 1991,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1578632767115-351597cf2477?w=400",
            description = "कार्टूनिस्ट प्राण की अमर कृति! 'चाचा चौधरी का दिमाग कंप्यूटर से भी तेज़ चलता है' और 'जब साबू को गुस्सा आता है तो कहीं ज्वालामुखी फटता है!' बैंक डकैती और राका के षड्यंत्र का पर्दाफाश।",
            pageCount = 6,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "पैनल 1: शहर में सनसनी और साबू की भूख",
                    storyText = "[दृश्य: चाचा चौधरी अपनी लाल पगड़ी और छड़ी लिए चौपाल पर बैठे हैं। साबू पास ही 108 पराठे और एक ड्रम लस्सी पी रहा है।]\n\nचाचा चौधरी: 'साबू! जल्दी करो, आज शहर के सेंट्रल बैंक में कोई बड़ी हलचल होने की आशंका है।'\nसाबू: 'हूश! चाचा जी, जब तक पेट में सौ पराठे न जाएं, तब तक जुपिटर ग्रह जैसी ऊर्जा कैसे आएगी?'"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "पैनल 2: डाकू गोबर सिंह का हमला",
                    storyText = "[दृश्य: बैंक का सायरन बजता है। चार नकाबपोश बंदूकधारी थैलों में नोट भरकर जीप में भाग रहे हैं।]\n\nगोबर सिंह: 'हा हा हा! अब कोई माई का लाल हमें नहीं पकड़ सकता! पुलिस को तो हमने चकमा दे दिया!'\nचाचा चौधरी दूर खड़े मुस्कुराते हैं: 'अपराधी हमेशा कोई न कोई सुराग छोड़ ही जाता है।'"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "पैनल 3: कंप्यूटर से तेज़ दिमाग का वार",
                    storyText = "चाचा चौधरी ने सड़क के किनारे की लाल मिट्टी और जीप के टायरों के निशान देखे।\n\nचाचा चौधरी: 'साबू! जीप पुरानी पुलिया की तरफ जा रही है जहाँ वजन सहने की क्षमता कम है। तुम शॉर्टकट वाले पहाड़ से छलांग लगाओ!'\nसाबू: 'जो आज्ञा चाचा जी!' [धड़ाम! साबू पहाड़ से कूदता है, धरती हिल जाती है!]"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "पैनल 4: जब साबू को गुस्सा आया!",
                    storyText = "[दृश्य: साबू दोनों हाथों से डाकुओं की जीप को खिलौने की तरह हवा में उठा लेता है!]\n\nगोबर सिंह: 'बाप रे बाप! यह आदमी है या दानव? छोड़ दो हमें!'\nसाबू की आँखें लाल: 'जब साबू को गुस्सा आता है, तो दूर कहीं प्रशांत महासागर में ज्वालामुखी फटता है!'\nसाबू ने जीप को सीधा पुलिस स्टेशन के आंगन में पटक दिया!"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "पैनल 5: चाची की डाँट और रॉकेट कुत्ता",
                    storyText = "[दृश्य: घर पहुँचने पर चाची हाथ में बेलन लिए खड़ी हैं।]\n\nचाची: 'आ गए दोनों दुनिया जीत कर! सब्जी लाने को कहा था, वो कहाँ है?'\nरॉकेट कुत्ता 'भौंक-भौंक' करके चाची के पैर चाटने लगता है।\nचाचा चौधरी सिर खुजलाते हुए: 'चाची! दुनिया का हर कंप्यूटर तुम्हारी इस डांट के आगे हैंग हो जाता है!'\n[सभी खिलखिलाकर हँस पड़ते हैं—समाप्त]"
                ),
                PageContent(
                    pageNumber = 6,
                    storyTitle = "प्राण कॉमिक्स यादगार नोट",
                    storyText = "कार्टूनिस्ट प्राण के अन्य अमर किरदार:\n- बिल्लू और उसका जोजो कुत्ता\n- पिंकी और कुटकुट गिलहरी\n- रमन और श्रीमती जी\n- चन्नी चाची\nभारतीय कॉमिक्स का स्वर्ण युग सदा अमर रहेगा।"
                )
            )
        ),

        Publication(
            id = "billoo-cricket-match",
            title = "बिल्लू का क्रिकेट मैच (प्राण कॉमिक्स 1993)",
            category = "COMIC",
            series = "Billoo",
            year = 1993,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1540747913346-19e32dc3e97e?w=400",
            description = "माथे पर झूलते बालों वाला प्यारा बिल्लू, उसका दोस्त गबरू और बजरी! मोहल्ले के क्रिकेट मैच में कर्नल ढिल्लों की खिड़की का कांच टूटने का हास्यप्रद हंगामा।",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "मोहल्ले का विश्वकप",
                    storyText = "बिल्लू अपनी टोली के साथ खाली मैदान में उतरा। बाल उसकी आँखों पर झूल रहे थे।\nबजरी: 'बिल्लू, आज का मैच जीतना ज़रूरी है, सामने वाली गली की टीम ने हमें चुनौती दी है!'\nबिल्लू ने बल्ला घुमाते हुए कहा: 'चिंता मत कर बजरी, आज मेरा बल्ला आग उगलेगा!'"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "कर्नल ढिल्लों की खिड़की और छक्का",
                    storyText = "गेंदबाज ने तेज़ गेंद फेंकी। बिल्लू ने पूरी ताकत से बल्ला घुमाया—गेंद सीधे कर्नल ढिल्लों के ड्राइंग रूम की खिड़की पर जा लगी—छनन्न!\nकर्नल ढिल्लों अपनी मूँछें ताव देते हुए डंडा लेकर बाहर निकले: 'किस बदमाश ने मेरी खिड़की तोड़ी?'"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "बिल्लू की हाज़िरजवाबी",
                    storyText = "पूरी टीम भाग गई, लेकिन बिल्लू शांति से खड़ा रहा।\nबिल्लू: 'कर्नल अंकल! मैंने खिड़की नहीं तोड़ी, मैंने तो आपकी खिड़की पर बैठी जहरीली छिपकली को मारा था! वो देखिए गेंद के नीचे छिपकली!'\nकर्नल अंकल ने चश्मा उतारकर देखा और बिल्लू को शाबाशी दे दी।"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "जोजो कुत्ते का कमाल",
                    storyText = "मैच के आखिरी ओवर में जीत के लिए 4 रन चाहिए थे। जोजो कुत्ता गेंद को मुँह में दबाकर बाउंड्री के पार दौड़ गया!\nएंपायर ने चौका घोषित कर दिया और बिल्लू की टीम जीत गई।"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "बचपन की यादें",
                    storyText = "गर्मियों की छुट्टियों में दुपहरी में छुपकर मोहल्ले में क्रिकेट खेलना और दोस्तों के साथ आइसक्रीम खाना—यह था 90 के दशक का सच्चा बचपन।"
                )
            )
        ),

        // ================= AMAR CHITRA KATHA & TINKLE =================
        Publication(
            id = "panchatantra-mitrabhed",
            title = "अमर चित्र कथा: पंचतंत्र की अमर कहानियाँ",
            category = "COMIC",
            series = "Amar Chitra Katha",
            year = 1982,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1532012164546-f432f2e3777a?w=400",
            description = "अनंत पई (अंकल पई) द्वारा प्रस्तुत अमर चित्र कथा! पंडित विष्णु शर्मा द्वारा रचित पंचतंत्र की नीतिपरक कहानियाँ—कछुआ और हंस, चालाक सियार और बगुले का न्याय।",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "दो हंस और बातूनी कछुआ",
                    storyText = "एक सुंदर सरोवर में संकट और विकट नाम के दो हंस रहते थे। उसी सरोवर में कंबुग्रीव नाम का एक बातूनी कछुआ भी उनका मित्र था।\nसूखा पड़ने पर हंसों ने दूसरे बड़े ताल पर जाने का निश्चय किया। कछुआ भी साथ जाने की जिद करने लगा।"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "लकड़ी का सहारा और चेतावनी",
                    storyText = "हंसों ने एक तरकीब निकाली: 'हम दोनों एक लकड़ी के दोनों सिरों को चोंच में पकड़ेंगे और तुम बीच में अपने दाँतों से उसे पकड़ लेना। लेकिन याद रखना—हवा में उड़ते समय एक शब्द भी मत बोलना, वरना नीचे गिर पड़ोगे!'"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "मौन का महत्व",
                    storyText = "जब वे गाँव के ऊपर से उड़े, तो नीचे लोग शोर मचाने लगे: 'देखो देखो! कछुआ उड़ रहा है!'\nकछुए से रहा नहीं गया। उसने कहा—'तुम सब राख खाओ!'\nमुँह खोलते ही कछुआ नीचे गिरा और अपने प्राण गँवा बैठा।"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "पंचतंत्र का अमर श्लोक",
                    storyText = "सुहृदां हितकामानां न करोतीह यो वचः।\nस कूर्म इव दुर्बुद्धिः काष्ठाद् भ्रष्टो विनश्यति॥\n\nअर्थ: जो व्यक्ति अपने हितैषी मित्रों की भलाई भरी बात पर ध्यान नहीं देता, वह लकड़ी से गिरे उस मूर्ख कछुए की तरह नष्ट हो जाता है।"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "अमर चित्र कथा विरासत",
                    storyText = "अमर चित्र कथा ने भारत की गौरवशाली संस्कृति, महापुरुषों और लोककथाओं को चित्रों के माध्यम से हर भारतीय बच्चे के दिल में अमर कर दिया।"
                )
            )
        ),

        Publication(
            id = "tinkle-digest-shikari-shambu",
            title = "Tinkle Digest: Shikari Shambu & Suppandi",
            category = "COMIC",
            series = "Tinkle",
            year = 1995,
            language = "en",
            coverUrl = "https://images.unsplash.com/photo-1516979187457-637abb4f9353?w=400",
            description = "Classic English Tinkle comics by Uncle Pai! Featuring the cowardly yet miraculously lucky Shikari Shambu, the simple-minded Suppandi, and Tantri the Mantri's failing conspiracies.",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "Shikari Shambu and the Rogue Tiger",
                    storyText = "Panel 1: The village headman panics: 'A fearsome tiger has entered the outskirts! Only the legendary Shikari Shambu can capture it without bloodshed!'\n\nShambu in his oversized pith helmet shakes with fright inside his hut: 'Oh no! Why does everyone think I am brave?! I just want to drink hot tea and sleep!'"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "The Miraculous Capture",
                    storyText = "Panel 2: Shambu climbs up a banyan tree to hide. Suddenly, the branch snaps! Shambu falls directly onto a giant net used to dry chillies.\n\nThe net collapses onto the tiger taking a nap underneath. The tiger gets thoroughly tangled in the chilli net and sneezes helplessly!\n\nVillagers rush in cheering: 'Incredible! Shambu captured the ferocious tiger with his bare hands!' Shambu sweatdrops: 'Heh... all in a day's work!'"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "Suppandi's Brilliant Logic",
                    storyText = "Master: 'Suppandi, take this money and buy two bottles of milk. If the shopkeeper doesn't have fresh milk, buy curd!'\n\nSuppandi goes to the grocery store.\nSuppandi: 'Do you have fresh milk?'\nShopkeeper: 'No, only curd is available.'\nSuppandi: 'Great! Give me two bottles of curd, and make sure you pour it directly into my coat pockets so it stays warm!'"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "Tantri the Mantri: The Boomerang Arrow",
                    storyText = "Tantri whispers to the royal weaponsmith: 'Craft me an arrow that strikes without sound so I can remove Raja Hooja and become King!'\n\nDuring the royal hunt, Tantri releases the secret arrow. A sudden gust of wind catches the feathers, turning the arrow 180 degrees backwards!\nThwack! Tantri gets pinned to the tree by his own royal turban while Raja Hooja enjoys his laddoos!"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "Tinkle Nostalgia",
                    storyText = "Tinkle brought laughter and timeless morality to generations of kids across India. Created by Anant Pai, it remains a jewel of Indian children's literature."
                )
            )
        ),

        // ================= SUNDAY NEWSPAPER STRIPS & RETRO SUPPLEMENTS =================
        Publication(
            id = "newspaper-amar-ujala-1995",
            title = "अमर उजाला: नन्हे सम्राट रविवार विशेषांक 1995",
            category = "NEWSPAPER",
            series = "Sunday Strips",
            year = 1995,
            language = "hi",
            coverUrl = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",
            description = "रविवार की सुबह का वो सुनहरा दौर जब अखबार आते ही बच्चे 'नन्हे सम्राट' और 'बाल संसार' पन्ने के लिए लड़ पड़ते थे! इसमें जादुई पहेलियाँ, चित्र जोड़ो और संडे कॉमिक स्ट्रिप शामिल हैं।",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "रविवार की सुबह का अखबार और बचपन",
                    storyText = "90 के दशक में रविवार की सुबह का अलग ही जादू था। दूरदर्शन पर सुबह 'रंगोली' और 'रामायण/महाभारत' के बाद जैसे ही दरवाजे पर अखबार गिरता था, घर के बच्चे सबसे पहले रविवार विशेषांक का रंगीन पन्ना खींच लेते थे।\n\n'नन्हे सम्राट' में जादुई भूलभुलैया, दो चित्रों में 7 अंतर ढूँढो, और नन्हे जासूस के किस्से हर बच्चे को रोमांचित कर देते थे।"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "रविवार कॉमिक स्ट्रिप: जासूस चीकू और खोई घड़ी",
                    storyText = "स्ट्रिप 1: सेठ करोड़ीमल की हीरे जड़ी घड़ी अलमारी से गायब थी। उन्होंने जासूस चीकू को बुलाया।\nस्ट्रिप 2: चीकू ने कमरे का मुआयना किया। खिड़की पर गीली मिट्टी के पंजे के निशान थे।\nस्ट्रिप 3: चीकू ने बगीचे में जाकर देखा तो तोते के घोंसले में चमचमाती घड़ी रखी थी! पक्षी चमकदार चीज़ों की ओर आकर्षित होते हैं।\nसेठ जी ने खुशी से चीकू को इनाम दिया।"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "दो चित्रों में 7 अंतर ढूँढें (Spot the Differences)",
                    storyText = "नन्हे पाठकों के लिए मजेदार चुनौती:\n1. शेर की मूँछ का एक बाल गायब है।\n2. पेड़ पर तीसरे फल का रंग लाल नहीं पीला है।\n3. बच्चे की टोपी पर बना सितारा उल्टा है।\n4. नदी में तैर रही बत्तख की चोंच खुली है।\n5. दूर पहाड़ पर सूरज की किरणें 6 हैं न कि 7।\n6. खरगोश के हाथ में गाजर की पत्ती गायब है।\n7. बाईं तरफ की झाड़ी में छिपा खरगोश मुस्कुरा रहा है।"
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "बाल प्रतिभा: पाठकों की चित्रकारी और कविताएँ",
                    storyText = "संजय (कक्षा 5, लखनऊ): 'सूरज निकला मिटा अंधेरा, देखो बच्चों हुआ सवेरा!'\nरिया (कक्षा 4, भोपाल): मोर का सुंदर जलरंग चित्र।\n\nउस दौर में अखबार में अपना नाम और शहर छपा देखना किसी नोबेल पुरस्कार से कम नहीं लगता था!"
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "अखबार विशेषांक का महत्व",
                    storyText = "रविवार के उन पन्नों ने न केवल बच्चों में पढ़ने की आदत डाली, बल्कि उन्हें सोचने, पहेलियाँ सुलझाने और कला के प्रति आकर्षित किया।"
                )
            )
        ),

        Publication(
            id = "newspaper-phantom-strip",
            title = "Phantom: The Ghost Who Walks (Sunday Retro Strip 1982)",
            category = "NEWSPAPER",
            series = "Sunday Strips",
            year = 1982,
            language = "en",
            coverUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=400",
            description = "The immortal newspaper comic strip of 'The Ghost Who Walks'! The legendary 21st Phantom with his trusty wolf Devil and stallion Hero defending the Deep Woods of Bangalla.",
            pageCount = 5,
            pages = listOf(
                PageContent(
                    pageNumber = 1,
                    storyTitle = "Old Jungle Saying: The Ghost Who Walks Never Dies",
                    storyText = "Panel 1: The Deep Woods of Bangalla. The Bandar Pygmy tribe gathers around the Skull Cave.\n\nOld Jungle Saying: 'There are times when the Phantom leaves the jungle and walks the city streets like an ordinary man. When the Phantom moves, the wind stands still.'"
                ),
                PageContent(
                    pageNumber = 2,
                    storyTitle = "The Pirates of Morristown",
                    storyText = "Panel 2: A ruthless syndicate of smugglers attempts to capture ancient golden relics from the Whispering Grove.\n\nLeader: 'Move fast! The natives are superstitious, they fear an imaginary ghost in purple!'\nSuddenly, out of the dense jungle mist emerges a majestic white stallion—Hero! And beside him, the great mountain wolf, Devil!"
                ),
                PageContent(
                    pageNumber = 3,
                    storyTitle = "The Mark of the Skull",
                    storyText = "Panel 3: The Phantom steps forward. His right fist bears the fearsome Skull Ring.\n\nThump! A lightning left hook, followed by a thunderous right! The pirate leader falls into the river.\nOn his jaw is permanently imprinted the dread Mark of the Skull—the sign that evil has met its justice."
                ),
                PageContent(
                    pageNumber = 4,
                    storyTitle = "The Good Mark of Peace",
                    storyText = "Panel 4: The Phantom presents the Bandar elders with the Good Mark ring. 'The Deep Woods are safe once more.'\n\nWith a salute, the masked rider gallops into the twilight forest."
                ),
                PageContent(
                    pageNumber = 5,
                    storyTitle = "The Golden Age of Newspaper Strips",
                    storyText = "Lee Falk's Phantom and Mandrake the Magician were staples of Indian Sunday newspapers (The Times of India, The Statesman, The Hindu) from the 1960s to the 1990s, cherished by millions."
                )
            )
        )
    )

    fun getAllPublications(): List<Publication> = publications

    fun getPublicationById(id: String): Publication? = publications.find { it.id == id }

    fun filterByCategory(category: String): List<Publication> {
        if (category == "ALL") return publications
        return publications.filter { it.category.equals(category, ignoreCase = true) }
    }

    fun filterBySeries(series: String): List<Publication> {
        return publications.filter { it.series.contains(series, ignoreCase = true) }
    }

    fun filterByDecade(decade: String): List<Publication> {
        return when (decade) {
            "1970s" -> publications.filter { it.year in 1970..1979 }
            "1980s" -> publications.filter { it.year in 1980..1989 }
            "1990s" -> publications.filter { it.year in 1990..1999 }
            "2000s" -> publications.filter { it.year in 2000..2009 }
            else -> publications
        }
    }

    fun searchPublications(query: String): List<Publication> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return publications
        return publications.filter {
            it.title.lowercase().contains(q) ||
            it.series.lowercase().contains(q) ||
            it.description.lowercase().contains(q) ||
            it.year.toString().contains(q) ||
            it.pages.any { p -> (p.storyTitle ?: "").lowercase().contains(q) || (p.storyText ?: "").lowercase().contains(q) }
        }
    }
}
