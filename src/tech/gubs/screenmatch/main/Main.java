package tech.gubs.screenmatch.main;

import tech.gubs.screenmatch.entities.Movie;
import tech.gubs.screenmatch.entities.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Movie movie001 = new Movie("Batman - Begins", 2008);
        movie001.setIncludedInThePlan(true);

        Movie movie002 = new Movie("Batman - The Dark Knight", 2010);
        movie002.setIncludedInThePlan(true);
        movie002.setReleaseYear(2010);

        Movie movie003 = new Movie("Batman - The Dark Knight Rises", 2012);
        movie003.setIncludedInThePlan(true);

        ArrayList<Movie> nolanTrilogy = new ArrayList<>();
        nolanTrilogy.add(movie001);
        nolanTrilogy.add(movie002);
        nolanTrilogy.add(movie003);

        nolanTrilogy.forEach(movie -> {
            System.out.println(movie.getName());
        });

        Collections.sort(nolanTrilogy);
        System.out.println("Sorted list by name");
        System.out.println(nolanTrilogy);

        nolanTrilogy.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Sorted list by release year");
        System.out.println(nolanTrilogy);
    }
}
