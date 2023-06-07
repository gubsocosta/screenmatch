package tech.gubs.screenmatch.entities;

import com.google.gson.annotations.SerializedName;
import tech.gubs.screenmatch.entities.omdb.TitleOmdb;

public class Title implements Comparable<Title> {
    private boolean includedInThePlan;
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private int runtimeInMinutes;
    private double totalRating;
    private int totalReviews;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb titleOmdb) {
        this.name = titleOmdb.title();
        String titleOmdbYear = titleOmdb.year();
        String titleOmdbRuntime = titleOmdb.runtime();
        this.releaseYear = Integer.valueOf(titleOmdbYear.substring(0, 4));
        this.runtimeInMinutes = Integer.valueOf(titleOmdbRuntime.substring(titleOmdbRuntime.length(), 4));
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

    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
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

    @Override
    public String toString() {
        return "Title{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
