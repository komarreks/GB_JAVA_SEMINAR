package ru.komarreks;

import com.google.gson.Gson;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Иван", "Иванов", 25);
        Person person2 = new Person("Иван", "Иванов", 25);
        Person person3 = new Person("Петр", "Петров", 36);

        System.out.println(person);
        System.out.println(person.hashCode());
        System.out.println(person.equals(person));
        System.out.println(person.equals(person2));//Интересно, а объекты по сути разные
        System.out.println(person.equals(person3));

        File file = new File("person.json");
        FileWriter fileWriter = new FileWriter(file);

        Gson gson = new Gson();
        gson.toJson(person, fileWriter);
        fileWriter.flush();

        FileReader fileReader = new FileReader("person.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String strPerson = bufferedReader.readLine();

        Person person4 = gson.fromJson(strPerson, Person.class);

        System.out.println(person4);
    }
}