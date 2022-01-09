package com.example.profile_api_call;

public class Profiles {

private String name;
private  String id;
private String slug;
private String imges;

public  Profiles() {}
public  Profiles (String name,String id, String slug,String imges){

    this.name = name;
    this.id = id;
    this.slug = slug;
    this.imges = imges;


}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImges() {
        return imges;
    }

    public void setImges(String imges) {
        this.imges = imges;
    }
}
