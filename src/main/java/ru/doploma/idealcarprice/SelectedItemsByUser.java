package ru.doploma.idealcarprice;

import ru.doploma.idealcarprice.model.Defect;
import ru.doploma.idealcarprice.model.Detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectedItemsByUser {
    private static List<Detail> selectedDetails = new ArrayList<>();
    private static Map<Long, Defect> selectedDefects = new HashMap<>();

    public static void addToSelectedDetails(Detail detail) {
        SelectedItemsByUser.selectedDetails.add(detail);
    }

    public static List<Detail> getSelectedDetails() {
        return SelectedItemsByUser.selectedDetails;
    }

    public static void clearSelectedDetails() {
        SelectedItemsByUser.selectedDetails.clear();
        SelectedItemsByUser.clearSelectedDefects();
    }

    public static void addToSelectedDefects(Long detailId, Defect defect) {
        SelectedItemsByUser.selectedDefects.put(detailId, defect);
    }

    public static Map<Long, Defect> getSelectedDefects() {
        return SelectedItemsByUser.selectedDefects;
    }

    public static void setSelectedDefects() {
        SelectedItemsByUser.selectedDefects.clear();
    }

    public static void clearSelectedDefects() {
        SelectedItemsByUser.selectedDefects.clear();
    }
}
