package com.mycompany.game;

public enum Color {
    R,
    B,
    NULL;

    public boolean isNull(){
        return this == NULL;
    }

    public boolean equals(Color color){
        return this == color;
    }

    public String show(){
        return (this == NULL) ? Constants.FREE : this.toString();
    }
}
