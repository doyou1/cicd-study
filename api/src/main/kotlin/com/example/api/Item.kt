package com.example.api

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var _id: Long? = null

    // 한국어
    var ko: String = ""

    // 영어
    var en: String = ""

    // 일본어
    var ja: String = ""

    // 중국어 간체(중국)
    var zh_CN: String = ""

    // 중국어 번체(대만, 홍콩, 마카오)
    var zh_TW: String = ""

    // 스페인어
    var es: String = ""

    // 프랑스어
    var fr: String = ""

    // 러시아어
    var ru: String = ""

    // 베트남어
    var vi: String = ""

    // 태국어
    var th: String = ""

    // 인도네시아어
    var id: String = ""

    // 독일어
    var de: String = ""

    // 이탈리아어
    var it: String = ""

    // 기본 생성자
    constructor()

    // 나머지 필드와 메서드들...

    constructor(
        ko: String,
        en: String,
        ja: String,
        zh_CN: String,
        zh_TW: String,
        es: String,
        fr: String,
        ru: String,
        vi: String,
        th: String,
        id: String,
        de: String,
        it: String
    ) {
        this.ko = ko
        this.en = en
        this.ja = ja
        this.zh_CN = zh_CN
        this.zh_TW = zh_TW
        this.es = es
        this.fr = fr
        this.ru = ru
        this.vi = vi
        this.th = th
        this.id = id
        this.de = de
        this.it = it
    }

}