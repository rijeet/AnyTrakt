package com.example.anytrakt;

public class Read_List_OnStatus {


    String Title;
    String Author;
    String Publish_Year;
    String Genre;
    String Rating;
    String OnStatus;

    public Read_List_OnStatus() {
    }

    public Read_List_OnStatus(String title, String author, String publish_Year, String genre, String rating, String onStatus) {
        Title = title;
        Author = author;
        Publish_Year = publish_Year;
        Genre = genre;
        Rating = rating;
        OnStatus = onStatus;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublish_Year() {
        return Publish_Year;
    }

    public void setPublish_Year(String publish_Year) {
        Publish_Year = publish_Year;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getOnStatus() {
        return OnStatus;
    }

    public void setOnStatus(String onStatus) {
        OnStatus = onStatus;
    }

    @Override
    public String toString() {
        return "Read_List_OnStatus{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Publish_Year='" + Publish_Year + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Rating='" + Rating + '\'' +
                ", OnStatus='" + OnStatus + '\'' +
                '}';
    }
}

/*
Ahsanullah University of Science and Technology
Department of Computer Science and Engineering
Project Name: AnyTrakt (TV Series, Book, Movies Recommendation System)
Course Name : Database Lab
Course Number : CSE3104
Semester : 3.1
Section : B
Group : B2-06
Team Members
Name : Yousuf Hossen
ID : 1901040094
Name : Rijeet Bin Anis
ID : 190104095
Motivation
Sometime we saw a trailer of a movie or series and made a mental note 
to watch it only to remember after it finishes its theatrical run or TV air.
Again, we lose track of which episode we are currently bingeing on or 
which series is coming out each season.
There are many who watch too much TV. From drama series, Anime, 
movies to reality TV shows, there is always something one need to catch 
up on when finally one gets home from work. As for movies, series, and 
other shows, many personally prefer having a catalogue of all the things
they have ever watched in their life. It can also help to keep every book 
one has read. That, and the option of keeping an personal watch list for 
future reference to share with friends.
Prospective Clients for Software
Our prospective clients are all the people who wants to keep track of 
everything they have watched or read and wants to be up to date with 
everything that is coming every season.
 */