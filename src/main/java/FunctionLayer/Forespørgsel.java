package FunctionLayer;

public class Forespørgsel {

    private int forespørgselsId;
    private String fornavn;
    private String efternavn;
    private String adresse;
    private String email;
    private String telefonnummer;
    private int carportId;
    private int tagId;
    private int skurId;
    private int status;

    public Forespørgsel(int forespørgselsId, String fornavn, String efternavn, String adresse, String email, String telefonnummer, int carportId, int tagId, int skurId, int status) {
        this.forespørgselsId = forespørgselsId;
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

    public Forespørgsel(String fornavn, String efternavn, String adresse, String email, String telefonnummer) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresse = adresse;
        this.email = email;
        this.telefonnummer = telefonnummer;
    }

    public int getForespørgselsId() {
        return forespørgselsId;
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

    public void setCarportId(int carportId) {
        this.carportId = carportId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public void setSkurId(int skurId) {
        this.skurId = skurId;
    }

    @Override
    public String toString() {
        return "Forespørgsel{" +
                "id=" + forespørgselsId +
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
