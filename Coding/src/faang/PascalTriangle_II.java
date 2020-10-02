package faang;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_II {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> pascal_list = new ArrayList<Integer>(rowIndex + 1);
        for(int i = 0; i <= rowIndex; i++) pascal_list.add(0);
        pascal_list.set(0, 1);
        for(int i = 1; i <= rowIndex; i++)
            for(int j = i; j > 0; j--)
                pascal_list.set(j, pascal_list.get(j) + pascal_list.get(j - 1));
        return pascal_list;
    }
}
