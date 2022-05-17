package ru.doploma.idealcarprice.helper;

import ru.doploma.idealcarprice.model.City;
import ru.doploma.idealcarprice.model.Defect;
import ru.doploma.idealcarprice.model.PartCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectedItemsByUserHelper {
    private static City selectedCity;
    private static List<PartCode> selectedPartCodes = new ArrayList<>();
    private static Map<Long, Defect> selectedDefects = new HashMap<>();

    public static void setSelectedCity(City city) {
        selectedCity = city;
    }

    public City getSelectedCity(City city) {
        return selectedCity;
    }

    public static void addToSelectedDetails(PartCode partCode) {
        selectedPartCodes.add(partCode);
    }

    public static List<PartCode> getSelectedPartCodes() {
        return selectedPartCodes;
    }

    public static void clearSelectedDetails() {
        selectedPartCodes.clear();
        clearSelectedDefects();
    }

    public static void addToSelectedDefects(Long detailId, Defect defect) {
        selectedDefects.put(detailId, defect);
    }

    public static Map<Long, Defect> getSelectedDefects() {
        return selectedDefects;
    }

    public static void setSelectedDefects() {
        selectedDefects.clear();
    }

    public static void clearSelectedDefects() {
        selectedDefects.clear();
    }
}
