package com.kartik.iTechapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ITechController {
    @RequestMapping(value = "/test")
    public String test()
    {
        return "Hello world !";
    }
    @RequestMapping(value = "/test-json")
    public Map testJson()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Kartik");
        map.put("city","Thanjavur");
        map.put("Workplace","chennai");
        map.put("pincode",600006);
        return map;
    }
    @RequestMapping(value = "/karthik")
    public Map getKarthik()
    {
        Address address = new Address();
        address.city = "Thanjavur";
        address.state = "Chennai";
        address.pincode = 600006;
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","karthik");
        map.put("address",address);
        return map;
    }
    @RequestMapping(value = "/kartik")
    public person getKartik()
    {
        Address address = new Address();
        address.city = "Thanjavur";
        address.state = "Chennai";
        address.pincode = 600006;
        List<String> languages = new ArrayList<>();
        languages.add("ta");
        languages.add("en");
        languages.add("hi");
        person person1 = new person();
        person1.id = 1;
        person1.name = "Karthik";
        person1.address = address;
        person1.languages = languages;
        return person1;
    }
}
