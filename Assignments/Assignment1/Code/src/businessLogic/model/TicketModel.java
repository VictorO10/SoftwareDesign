package businessLogic.model;

public class TicketModel {

    private int idticket;

    private int idshow;

    private int seatNb;

    private int rowNb;

    private String onName;

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public int getIdshow() {
        return idshow;
    }

    public void setIdshow(int idshow) {
        this.idshow = idshow;
    }

    public int getSeatNb() {
        return seatNb;
    }

    public void setSeatNb(int seatNb) {
        this.seatNb = seatNb;
    }

    public int getRowNb() {
        return rowNb;
    }

    public void setRowNb(int rowNb) {
        this.rowNb = rowNb;
    }

    public String getOnName() {
        return onName;
    }

    public void setOnName(String onName) {
        this.onName = onName;
    }

    @Override
    public String toString() {
        return idticket + ". show: " + idshow + ". Sit: " + seatNb + " " + rowNb + ". For " + onName;
    }
}
