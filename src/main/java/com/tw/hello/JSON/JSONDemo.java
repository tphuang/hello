package com.tw.hello.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class JSONDemo {

    public String createJSON() {
        Gson gson = new Gson();
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("name" + i);
            p.setAge(i * 5);
            persons.add(p);
        }
        String str = gson.toJson(persons);
        return str;
    }

    public List<Person> readJSON(String str) {
        Gson gson = new Gson();
        List<Person> personList = gson.fromJson(str, new TypeToken<List<Person>>(){}.getType());
        System.out.println("Output the JSON: ---------------- \n");
        for(int i = 0; i < personList.size() ; i++)
        {
            Person person = personList.get(i);
            System.out.println(person.getName() + "  " + person.getAge() + ";");
        }
        return personList;
    }


    public static void main(String[] args) {
        JSONDemo jsonDemo = new JSONDemo();
        String json = jsonDemo.createJSON();
        System.out.printf("The created JSON is: " + json);

        Gson gson = new Gson();
        String singleJson = "{'name':'name0','age':0}";
        Person person = gson.fromJson(singleJson, Person.class);
        System.out.println("\nThe person is: " + person);

        jsonDemo.readJSON(json);

    }

}
