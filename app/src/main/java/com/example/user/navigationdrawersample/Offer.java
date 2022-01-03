package com.example.user.navigationdrawersample;

public class Offer {
    private int id;
    private int nombrePost;
    private String date;
    private String titre;

    public Offer(int id, int nombrePost, String date, String titre) {
        this.id = id;
        this.nombrePost = nombrePost;
        this.date = date;
        this.titre = titre;
    }
    public int getId() { return id;  }

    public void setId(int id) { this.id = id; }

    public int getNombrePost() { return nombrePost; }

    public void setNombrePost(int nombrePost) { this.nombrePost = nombrePost; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTitre() { return titre;  }

    public void setTitre(String titre) { this.titre = titre;  }
}
