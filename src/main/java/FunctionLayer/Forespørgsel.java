package FunctionLayer;

public class Forespørgsel {

    private int id;
    private String fornavn;
    private String efternavn;
    private String adresse;
    private String email;
    private String telefonnummer;
    private int carportId;
    private int tagId;
    private int skurId;
    private int status;

    public Forespørgsel(int id, String fornavn, String efternavn, String adresse, String email, String telefonnummer, int carportId, int tagId, int skurId, int status) {
        this.id = id;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresse = adresse;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.carportId = carportId;
        this.tagId = tagId;
        this.skurId = skurId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public int getCarportId() {
        return carportId;
    }

    public int getTagId() {
        return tagId;
    }

    public int getSkurId() {
        return skurId;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Forespørgsel{" +
                "id=" + id +
                ", fornavn='" + fornavn + '\'' +
                ", efternavn='" + efternavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", carportId=" + carportId +
                ", tagId=" + tagId +
                ", skurId=" + skurId +
                ", status=" + status +
                '}';
    }
}
