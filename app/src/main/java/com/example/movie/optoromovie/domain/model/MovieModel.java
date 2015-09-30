package com.example.movie.optoromovie.domain.model;

/**
 * Created by brai on 9/24/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MovieModel implements Parcelable{

    private Boolean adult;
    private Object backdrop_path;
    private List<Integer> genre_ids = new ArrayList<Integer>();
    private Integer id;
    private String original_language;
    private String original_title;
    private String overview;
    private String release_date;
    private Object poster_path;
    private Double popularity;
    private String title;
    private Boolean video;
    private Double vote_average;
    private float vote_count;

    /**
     *
     * @return
     * The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     *
     * @param adult
     * The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     *
     * @return
     * The backdropPath
     */
    public Object getBackdropPath() {
        return backdrop_path;
    }

    /**
     *
     * @param backdropPath
     * The backdrop_path
     */
    public void setBackdropPath(Object backdropPath) {
        this.backdrop_path = backdropPath;
    }

    /**
     *
     * @return
     * The genreIds
     */
    public List<Integer> getGenreIds() {
        return genre_ids;
    }

    /**
     *
     * @param genreIds
     * The genre_ids
     */
    public void setGenreIds(List<Integer> genreIds) {
        this.genre_ids = genreIds;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The originalLanguage
     */
    public String getOriginalLanguage() {
        return original_language;
    }

    /**
     *
     * @param originalLanguage
     * The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    /**
     *
     * @return
     * The originalTitle
     */
    public String getOriginalTitle() {
        return original_title;
    }

    /**
     *
     * @param originalTitle
     * The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     * The releaseDate
     */
    public String getReleaseDate() {
        return release_date;
    }

    /**
     *
     * @param releaseDate
     * The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    /**
     *
     * @return
     * The posterPath
     */
    public Object getPosterPath() {
        return poster_path;
    }

    /**
     *
     * @param posterPath
     * The poster_path
     */
    public void setPosterPath(Object posterPath) {
        this.poster_path = posterPath;
    }

    /**
     *
     * @return
     * The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The video
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     *
     * @param video
     * The video
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     *
     * @return
     * The voteAverage
     */
    public Double getVoteAverage() {
        return vote_average;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.vote_average = voteAverage;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public float getVoteCount() {
        return vote_count;
    }

    /**
     *
     * @param voteCount
     * The vote_count
     */
    public void setVoteCount(float voteCount) {
        this.vote_count = voteCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(String.valueOf(id));
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(String.valueOf(poster_path));
        parcel.writeString(String.valueOf(vote_average));
        parcel.writeString(String.valueOf(vote_count));
        parcel.writeString(release_date);
        parcel.writeString(String.valueOf(popularity));
        parcel.writeString(String.valueOf(backdrop_path));
    }

    public MovieModel(Parcel input){
        id = Integer.valueOf(input.readString());
        title = input.readString();
        overview = input.readString();
        poster_path = input.readString();
        vote_average = Double.valueOf(input.readString());
        vote_count = Float.parseFloat(input.readString());
        release_date = input.readString();
        popularity = Double.valueOf(input.readString());
        backdrop_path = input.readString();
    }

    public static final Parcelable.Creator<MovieModel> CREATOR
            = new Parcelable.Creator<MovieModel>() {
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

}
