package com.isha.model;

import jakarta.persistence.*;


@Entity
@Table(name="StudentDetailForWithoutXML")
public class StudentDetailForWithoutXML
{
    @Id
    @Column(name="SID")
    // @GeneratedValue
    // identity : for increment (used for mysql)
    // sequence : generating sequence (for oracle)
    // auto : when u dont know which
    // the table in the db should have auto increment
    @GeneratedValue(generator = "my_seq", strategy = GenerationType.SEQUENCE) // for automatically generating the primary key
    @SequenceGenerator(name="my_seq",sequenceName = "My_OwnSequence",initialValue = 100,allocationSize = 1)
    public Integer sid;
    @Column(name="SNAME")
    public String sname;
    @Column(name="SEMAIL")
    public String semail;
    @Column(name="SCITY")
    public String scity;

    // constructor
    public StudentDetailForWithoutXML()
    {
        System.out.println("zero param constructor");
    }
    //getter setter
    public Integer getSid()
    {
        return sid;
    }
    public void setSid(Integer sid)
    {
        this.sid=sid;
    }
    public String getSname()
    {
        return sname;
    }
    public void setSname(String sname)
    {
        this.sname = sname;
    }

    public String getSemail()
    {
        return semail;
    }

    public void setSemail(String semail)
    {
        this.semail=semail;
    }

    public String getScity()
    {
        return scity;
    }
    public void setScity(String scity)
    {
        this.scity=scity;
    }
    // for printing in the console
    @Override
    public String toString()
    {
        return "Student [sid = "+sid+" , sname = "+sname+" , semail= "+semail+" scity = "+scity+" ]";
    }
}
