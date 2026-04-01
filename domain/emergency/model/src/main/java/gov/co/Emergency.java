package gov.co;


public class Emergency{
    private Long id;
    private Double lat;
    private Double lon;
    private Long idcitizen;
    private String fechaOcurrido;
    private Long unitID;

    public Emergency(){}
    public Emergency(Long id, Double lat, Double lon, Long idcitizen, String fechaOcurrido, Long unitID) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.idcitizen = idcitizen;
        this.fechaOcurrido = fechaOcurrido;
        this.unitID = unitID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;}
    public Double getLat() {
        return lat;}
    public void setLat(Double lat) {
        this.lat = lat;}
    public Double getLon() {
        return lon;}
    public void setLon(Double lon) {
        this.lon = lon;}
    public Long getIdcitizen() {
        return idcitizen;}
    public void setIdcitizen(Long idcitizen) {
        this.idcitizen = idcitizen;}
    public String fechaOcurrido() {
        return fechaOcurrido;}
    public void fechaOcurrido(String fechaOcurrido) {
        this.fechaOcurrido = fechaOcurrido;}
    public Long getUnitID() {
        return unitID;}
    public void setUnitID(Long unitID) {
        this.unitID = unitID;}




}