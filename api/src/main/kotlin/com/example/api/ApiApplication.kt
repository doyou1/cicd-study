package com.example.api

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [ApiRepository::class])
@ComponentScan(basePackages = ["com.example.*"])
@EntityScan("com.example.*")
class ApiApplication {
    @Bean
    fun sampleData(repository: ApiRepository): CommandLineRunner {
        return CommandLineRunner { _: Array<String?>? ->
            repository.save(
                Item(
                    ko = "구름",
                    en = "cloud",
                    ja = "雲",
                    zh_CN = "云",
                    zh_TW = "雲",
                    es = "nube",
                    fr = "nuage, nuée",
                    ru = "облако, облачко",
                    vi = "đám mây",
                    th = "เมฆ, ก้อนเมฆ",
                    id = "awan",
                    de = "die Wolke",
                    it = "nuvola",
                )
            )
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}

