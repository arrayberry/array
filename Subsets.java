import java.util.*;

public class Subsets {

    public List<List<Integer>> subsets(List<Integer> inputSet) {
        if (inputSet.isEmpty()) {
            List<List<Integer>> rtn = new ArrayList<>();
            rtn.add(Collections.emptyList());
            return rtn;
        }
        Integer first = inputSet.get(0);
        List<Integer> rest = inputSet.subList(1, inputSet.size());
        List<List<Integer>> restSet = subsets(rest);
        List<List<Integer>> withFirstSet = insertAll(restSet, first);
        return concat(restSet, withFirstSet);
    }

    private List<List<Integer>> insertAll(List<List<Integer>> a, Integer b) {
        List<List<Integer>> rtn = new ArrayList<>();
        for (List<Integer> l: a) {
            List<Integer> copy = new ArrayList<>(l);
            copy.add(b);
            rtn.add(copy);
        }
        return rtn;
    }

    private List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> rtn = new ArrayList<>(a);
        rtn.addAll(b);
        return rtn;
    }

    public static void main(String[] argv) {
        System.out.println(new Subsets().subsets(new ArrayList<Integer>(Arrays.asList(1,4,9))));
    }
}
