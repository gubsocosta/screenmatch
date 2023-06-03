package tech.gubs.screenmatch.entities;

public class Title implements Comparable<Title> {
    private boolean includedInThePlan;
    private String name;
    private int releaseYear;
    private int runningTimeInMinutes;
    private double totalRating;
    private int totalReviews;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public boolean isIncludedInThePlan() {
        return includedInThePlan;
    }

    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRunningTimeInMinutes() {
        return runningTimeInMinutes;
    }

    public void setRunningTimeInMinutes(int runningTimeInMinutes) {
        this.runningTimeInMinutes = runningTimeInMinutes;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void rate(double rating) {
        totalRating += rating;
        totalReviews++;
    }

    public double getRating() {
        if (totalReviews != 0) {
            return totalRating / totalReviews;
        }
        return 0;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }
}
