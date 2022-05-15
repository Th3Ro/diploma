package ru.doploma.idealcarprice.helper;

import ru.doploma.idealcarprice.model.Defect;
import ru.doploma.idealcarprice.model.Detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectedItemsByUserHelper {
    private static List<Detail> selectedDetails = new ArrayList<>();
    private static Map<Long, Defect> selectedDefects = new HashMap<>();

    public static void addToSelectedDetails(Detail detail) {
        SelectedItemsByUserHelper.selectedDetails.add(detail);
    }

    public static List<Detail> getSelectedDetails() {
        return SelectedItemsByUserHelper.selectedDetails;
    }

    public static void clearSelectedDetails() {
        SelectedItemsByUserHelper.selectedDetails.clear();
        SelectedItemsByUserHelper.clearSelectedDefects();
    }

    public static void addToSelectedDefects(Long detailId, Defect defect) {
        SelectedItemsByUserHelper.selectedDefects.put(detailId, defect);
    }

    public static Map<Long, Defect> getSelectedDefects() {
        return SelectedItemsByUserHelper.selectedDefects;
    }

    public static void setSelectedDefects() {
        SelectedItemsByUserHelper.selectedDefects.clear();
    }

    public static void clearSelectedDefects() {
        SelectedItemsByUserHelper.selectedDefects.clear();
    }
}
