package api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name"})
public class Tag {

    private int id;
    private String name;

    // Getter
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    // Setter
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
}
