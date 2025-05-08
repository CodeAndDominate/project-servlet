package com.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Field {
    private final Map<Integer, Sign> innerField;

    public Field() {
        innerField = new HashMap<>();
        innerField.put(0, Sign.EMPTY);
        innerField.put(1, Sign.EMPTY);
        innerField.put(2, Sign.EMPTY);
        innerField.put(3, Sign.EMPTY);
        innerField.put(4, Sign.EMPTY);
        innerField.put(5, Sign.EMPTY);
        innerField.put(6, Sign.EMPTY);
        innerField.put(7, Sign.EMPTY);
        innerField.put(8, Sign.EMPTY);
    }

    public Map<Integer, Sign> getInnerField() {
        return innerField;
    }

    public int getEmptyFieldIndex() {
        return innerField.entrySet().stream()
                .filter(e -> e.getValue() == Sign.EMPTY)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }

    public List<Sign> getInnerFieldData() {
        return innerField.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Sign checkWin() {
        List<List<Integer>> winPossibilities = List.of(
                List.of(0, 1, 2),
                List.of(3, 4, 5),
                List.of(6, 7, 8),
                List.of(0, 3, 6),
                List.of(1, 4, 7),
                List.of(2, 5, 8),
                List.of(0, 4, 8),
                List.of(2, 4, 6)
        );

        for (List<Integer> winPossibility : winPossibilities) {
            if (innerField.get(winPossibility.get(0)) == innerField.get(winPossibility.get(1))
                    && innerField.get(winPossibility.get(0)) == innerField.get(winPossibility.get(2))) {
                return innerField.get(winPossibility.get(0));
            }
        }
        return Sign.EMPTY;
    }
}