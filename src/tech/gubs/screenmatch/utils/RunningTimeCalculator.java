package tech.gubs.screenmatch.utils;

import tech.gubs.screenmatch.entities.Movie;

public class RunningTimeCalculator {
    private int totalRunningTime;

    public int getTotalRunningTime() {
        return totalRunningTime;
    }

    public void addTitle(Movie movie) {
        totalRunningTime += movie.getRunningTimeInMinutes();
    }
}
