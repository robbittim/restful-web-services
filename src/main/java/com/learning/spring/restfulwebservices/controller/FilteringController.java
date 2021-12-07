package com.learning.spring.restfulwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learning.spring.restfulwebservices.model.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    /**
     * Dynamic Filter example
     * @return
     */
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){

        //field1, field2  -> ignore field3

        SomeBean someBean = new SomeBean("field1","field2","field3");

        //filter out all the fields except field1 and field2
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

        // add the filter to the FilterProvider
        // *** the filter we defined is "SomeBeanFilter", so add that filter into SomeBean class ***
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        //mappingJacksonValue with the bean that we want to send back
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        //configure the filter for mapping
        mapping.setFilters(filters);

        //return the mapping jackson value
        return mapping;
//        return new SomeBean("field1","field2","field3");
    }

    //field2, field3 -> ignore field1
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){

        List<SomeBean> list = Arrays.asList(new SomeBean("field1", "field2", "field3"), new SomeBean("field11", "field22", "field33"));

        //field1, field2  -> ignore field3

        SomeBean someBean = new SomeBean("field1","field2","field3");

        //filter out all the fields except field1 and field2
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

        // add the filter to the FilterProvider
        // *** the filter we defined is "SomeBeanFilter", so add that filter into SomeBean class ***
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        //mappingJacksonValue with the bean that we want to send back
        MappingJacksonValue mapping = new MappingJacksonValue(list);

        //configure the filter for mapping
        mapping.setFilters(filters);

        //return the mapping jackson value
        return mapping;

//        return list;
    }
}
