package com.example.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class ApiController {
    @Autowired
    private lateinit var repository: ApiRepository

    @GetMapping(value = ["/item/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllItems(): Iterable<Item> {
        return repository.findAll()
    }

    @GetMapping(value = ["/item/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getItemById(@PathVariable id: Long): Item {
        return repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid item id: $id") }
    }

    @GetMapping(
        value = ["/item"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getItem(@RequestParam source: String, @RequestParam target: String, @RequestParam input: String): ResultItem {
        val list = repository.findByInput(source, input)
        val result = if (list.isNotEmpty()) {
            list[0]
        } else {
            // papago translation api로 db update
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "not exist in db: $source, target: $target, input: $input"
            )
        }

        val map = ObjectMapper().convertValue(result, Map::class.java)
        return if ((map[source] as String) == input && (map[target] as String).isNotEmpty()) {
            ResultItem(
                sourceLanguage = source,
                input = (map[source] as String),
                targetLanguage = target,
                result = (map[target] as String)
            )
        } else {
            // papago translation api로 db update()
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "not exist in db record: $source, target: $target, input: $input"
            )
        }
    }

}