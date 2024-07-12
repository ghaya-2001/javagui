package org.example.Connexion1ALINF7.Entite;

public class Food {
    private int id;
    private String name,image;
    private float prix;

    public Food(int id, String name,String image, float prix) {
        this.id = id;
        this.name = name;
        this.prix = prix;
        this.image=image;
    }

    public Food(String name, float prix, String image) {
        this.name = name;
        this.prix = prix;
        this.image=image;
    }

    public Food() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }


}
