package model;

/**
 * Created by Marcin on 2015-01-18.
 */
public class Player {

    private Long id;
    private String name;

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player(String id, String name){
        Long idFromString = Long.parseLong(id);
        this.id = idFromString;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
