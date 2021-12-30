package com.eurostudios.game_engine_classes;

import java.util.ArrayList;

public class Phase {

    private ArrayList<Entity> entityArrayList; // stores the entities

    public Phase(ArrayList<Entity> entityArrayList) {
        this.entityArrayList = entityArrayList;
    }

    public ArrayList<Entity> getEntityArrayList() {
        return entityArrayList;
    }


}
