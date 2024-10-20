package com.automation;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public Map<String, String> generateFormArray(){
        Map<String, String> person = new HashMap<>();
        person.put("name", "Tcc");
        person.put("last_name", "Gabriel");
        person.put("contact_first_name", "Teste");
        person.put("phone", "92 9999-9999");
        person.put("addressLine1", "Av Darcy Vargas, 1200");
        person.put("addressLine2", "Stem");
        person.put("city", "Manaus");
        person.put("state", "AM");
        person.put("postal_code", "69050-020");
        person.put("country", "Brasil");
        person.put("from_employeer", "Fixter");
        person.put("credit_limit", "200");
        return person;
    }
    public Map<String, String> generateUpdateArray(){
        Map<String, String> person = new HashMap<>();
        person.put("name", "UEA");
        person.put("last_name", "TCC");
        person.put("contact_first_name", "Teste");
        person.put("phone", "92 9999-9999");
        person.put("addressLine1", "Av Darcy Vargas, 1200");
        person.put("addressLine2", "Stem");
        person.put("city", "Manaus");
        person.put("state", "AM");
        person.put("postal_code", "69050-020");
        person.put("country", "Brasil");
        person.put("from_employeer", "Fixter");
        person.put("credit_limit", "200");
        return person;
    }
}
