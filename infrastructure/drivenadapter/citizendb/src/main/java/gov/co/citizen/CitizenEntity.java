package gov.co.citizen;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("citizens")
public class CitizenEntity{
    @Id
    private Long id;
    private String identification;
    private String kindof;
    private String name;
    private int age;
    private char gender;
    private String imageurl;

    public CitizenEntity(){}
    public CitizenEntity(Long id, String identification, String kindof, String name, int age, char gender, String imageurl){
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



}