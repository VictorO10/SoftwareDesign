package businessLogic.model;

import java.util.Date;

public class ShowModel {

    private int idshow;

    private String title;

    private String genre;

    private String distribution;

    private Date date;

    private int totalTickets;

    private int soldTickets;

    public int getIdshow() {
        return idshow;
    }

    public void setIdshow(int idshow) {
        this.idshow = idshow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(int soldTickets) {
        this.soldTickets = soldTickets;
    }

    @Override
    public String toString() {
        return idshow + ". " + title + ". Sold Tickets" + soldTickets + ". Date:" + date;
    }
}
