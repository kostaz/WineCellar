package org.coenraets.cellar;

import java.util.ArrayList;
import java.util.List;

public class WineDAO {

    private int nextWineId = 0;
    private List<Wine> wines = new ArrayList<Wine>();

    public WineDAO() {
        Wine wine = new Wine();

        wine.setId(nextWineId++);
        wine.setName("DummyName");
        wine.setGrapes("DummyGrapes");
        wine.setCountry("DummyCountry");
        wine.setRegion("DummyRegion");
        wine.setYear("DummyYear");
        wine.setPicture("DummyPicture");
        wine.setDescription("DummyDescription");

        wines.add(wine);
    }

    public List<Wine> findAll() {
        return wines;
    }

    public Wine findByName(String query) {
        for (Wine wine : wines) {
            if (query.equals(wine.getName())) {
                return wine;
            }
        }

        throw new RuntimeException("Wine Not Found: " + query);
    }

    public Wine findById(int id) {
        for (Wine wine : wines) {
            if (wine.getId() == id) {
                return wine;
            }
        }

        throw new RuntimeException("Wine Not Found: " + id);
    }

    public Wine create(Wine wine) {
        wine.setId(nextWineId++);
        wines.add(wine);
        return wine;
    }

    public Wine update(Wine newWine) {
        Wine wine = findById(newWine.getId());

        wine.setId(newWine.getId());
        wine.setName(newWine.getName());
        wine.setGrapes(newWine.getGrapes());
        wine.setCountry(newWine.getCountry());
        wine.setRegion(newWine.getRegion());
        wine.setYear(newWine.getYear());
        wine.setPicture(newWine.getPicture());
        wine.setDescription(newWine.getDescription());

        return  wine;
    }

    public void remove(int id) {
        Wine wine = findById(id);
        wines.remove(wine);
    }

}
