package com.example.api

import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ApiRepository : CrudRepository<Item, Long> {

    @Query(
        "SELECT i FROM Item i WHERE " +
                "CASE " +
                "WHEN :source = 'ko' THEN i.ko " +
                "WHEN :source = 'en' THEN i.en " +
                "WHEN :source = 'ja' THEN i.ja " +
                "WHEN :source = 'zh_CN' THEN i.zh_CN " +
                "WHEN :source = 'zh_TW' THEN i.zh_TW " +
                "WHEN :source = 'es' THEN i.es " +
                "WHEN :source = 'fr' THEN i.fr " +
                "WHEN :source = 'ru' THEN i.ru " +
                "WHEN :source = 'vi' THEN i.vi " +
                "WHEN :source = 'th' THEN i.th " +
                "WHEN :source = 'id' THEN i.id " +
                "WHEN :source = 'de' THEN i.de " +
                "WHEN :source = 'it' THEN i.it " +
                "ELSE NULL " +
                "END = :input"
    )
    fun findByInput(
        @Param("source") source: String,
        @Param("input") input: String
    ): List<Item>
}