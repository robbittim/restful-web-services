package com.learning.spring.restfulwebservices.controller;

import com.learning.spring.restfulwebservices.model.PersonV1;
import com.learning.spring.restfulwebservices.model.Name;
import com.learning.spring.restfulwebservices.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    /**
     * URLversioning
     */
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bod Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bod","Charlie"));
    }

    /**
     * Request Parameter versioning
     */
    @GetMapping(value = "person/param", params="version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Bod Charlie");
    }

    @GetMapping(value ="person/param", params="version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Bod","Charlie"));
    }

    /**
     * Header versioning
     */
    @GetMapping(value = "person/header", headers="X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bod Charlie");
    }

    @GetMapping(value ="person/header", headers="X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Bod","Charlie"));
    }

    /**
     * Produces versioning / Accept Header versioning
     */
    @GetMapping(value = "person/produces", produces="application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Bod Charlie");
    }

    @GetMapping(value ="person/produces", produces="application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Bod","Charlie"));
    }

}
