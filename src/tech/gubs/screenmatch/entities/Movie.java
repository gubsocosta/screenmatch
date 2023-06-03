package tech.gubs.screenmatch.entities;

import tech.gubs.screenmatch.utils.Recommendable;

public class Movie extends Title implements Recommendable {
    private String directorName;

    public Movie(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public void getRecommendation() {
        var ratting = getRating();
        if (ratting == 0) {
            System.out.println("No ratings yet");
        } else if (ratting >= 4) {
            System.out.println("Highly recommended");
        } else if (ratting >= 3) {
            System.out.println("Excellent");
        } else if (ratting >= 2) {
            System.out.println("Very good");
        } else {
            System.out.println("Good");
        }
    }

    @Override
    public String toString() {
        return "Movie: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }
}