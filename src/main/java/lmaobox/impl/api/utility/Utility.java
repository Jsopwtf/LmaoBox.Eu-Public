package lmaobox.impl.api.utility;

import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

import java.util.*;

public class Utility {

    @SafeVarargs
    public static <T> Object2BooleanOpenHashMap<T> asO2BMap(T... checked) {
        Map<T, Boolean> map = new HashMap<>();
        for (T item : checked)
            map.put(item, true);
        return new Object2BooleanOpenHashMap<>(map);
    }
}
