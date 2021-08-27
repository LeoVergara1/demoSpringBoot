package com.example.demo.controller

import com.example.demo.entity.Person
import com.example.demo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persons")
class PersonController {

    @Autowired
    PersonRepository personRepository

    @GetMapping
    List<Person> findAllPersons(){
        personRepository.findAll()
    }

    @GetMapping("/edad/{edad}")
    List<Person> findAllPersonsByEdad(@PathVariable Integer edad){
        personRepository.findAllByEdad(edad)
    }

    @GetMapping("/id/{id}")
    Person findById(@PathVariable Long id){
        def persona = personRepository.findById(id)
        persona.get() as Person
    }

    @PostMapping
    String create(@RequestBody Person person){
        personRepository.save(person)
    }

}
