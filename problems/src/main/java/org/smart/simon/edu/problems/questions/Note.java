package org.smart.simon.edu.problems.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * What will the program output?
 */
public class Note {

    public static void main(String[] args) {
        List<String> notes = new ArrayList<>();
        notes.add("This is a note 1");

        notes.addAll(Collections.emptyList());

        List<String> notes2 = new ArrayList<>();
        notes2.add("This is a note 2");

        notes.addAll(notes2);

        List<String> notes3 = Collections.emptyList(); //!!!!!!
        notes3.add("This is a note 3");

        notes.addAll(notes3);

        System.out.println(notes.size());
        notes.stream().forEach(note -> System.out.println(note));
    }
}
