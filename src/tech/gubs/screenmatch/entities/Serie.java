package tech.gubs.screenmatch.entities;

import tech.gubs.screenmatch.utils.Recommendable;

public class Serie extends Title implements Recommendable {
    private int seasonTotal;
    private int episodesPerSeason;
    private boolean active;
    private int minutesPerEpisode;

    public Serie(String name, int releaseYear) {
        super(name, releaseYear);
    }

    @Override
    public int getRuntimeInMinutes() {
        return seasonTotal * episodesPerSeason * episodesPerSeason;
    }

    @Override
    public void getRecommendation() {
        var ratting = getRating();
        if(ratting == 0) {
            System.out.println("No ratings yet");
        } else if (ratting >=4) {
            System.out.println("Highly recommended");
        } else if (ratting >=3) {
            System.out.println("Excellent");
        } else if(ratting >= 2){
            System.out.println("Very good");
        } else {
            System.out.println("Good");
        }
    }
}