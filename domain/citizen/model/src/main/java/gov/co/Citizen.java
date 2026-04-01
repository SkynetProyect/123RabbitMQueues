package gov.co;


public class Citizen{
    private Long id;
    private String identification;
    private String kindof;
    private String name;
    private int age;
    private char gender;
    private String imageurl;

    public Citizen(){}
    public Citizen(Long id, String identification, String kindof, String name, int age, char gender, String imageurl){
        this.id = id;
        this.identification = identification;
        this.kindof = kindof;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.imageurl = imageurl;
    }

    public String getIdentification(){ return identification; }
    public String getKindof(){ return kindof;}
    public String getName(){ return name;}
    public int getAge(){ return age;}
    public char getGender(){ return gender;}
    public String getImageurl(){return imageurl;}
    public Long getId(){return id;}

    public void setIdentification(String identification){ this.identification = identification;}
    public void setKindof(String kindof){ this.kindof = kindof;}
    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setGender(char gender){this.gender = gender;}
    public void setImageurl(String imageurl){this.imageurl = imageurl;}
    


}