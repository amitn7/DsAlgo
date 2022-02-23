
import java.util.*;

public class ConnectedComponent {


//------------------------------------------------------------- USING DFS----------
    public static List<List<Integer>> findCommonPairsUsingGraph (List<List<Integer>> list) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i< list.size(); ++i) {
            int first = list.get(i).get(0);
            int second = list.get(i).get(1);
            if(graph.get(first) !=null) {
                graph.get(first).add(second);
            } else {
                Set<Integer> newSet = new HashSet<>();
                newSet.add(second);
                graph.put(first, newSet );
            }
            if(graph.get(second) !=null) {
                graph.get(second).add(first);
            } else {
                Set<Integer> newSet = new HashSet<>();
                newSet.add(first);
                graph.put(second, newSet );
            }
        }

        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()) {
            int key = entry.getKey();
            if(!visited.contains(key)) {
                List<Integer> res = new ArrayList<>();
                doDfs(visited, graph,key, res);
                result.add(res);
            }
        }

        return result;
    }

    public static void doDfs(Set<Integer> visited, Map<Integer, Set<Integer>> graph, int key, List<Integer> result  ) {
        if(visited.contains(key)) return;
        visited.add(key);
        result.add(key);
        for(Integer i: graph.get(key)) {
            doDfs(visited, graph,i, result );
        }
    }

  //------------------------------------------------------ USING UNION FIND ----------------
  // -------------------IT CAN BE OPTIMIZED FURTHER USING PATH COMPRESSION AND ADDING SMALL TREE TO ROOT OF LARGE TREE----------------
    public static int findRoot(Map<Integer, Integer> rootMap, int p) {
        while(rootMap.get(p)!= p) {
            p = rootMap.get(p);
        }
        return p;
    }

    public static void findConnectedComponentUnion(List<List<Integer>> list) {
        Map<Integer, Integer> rootMap = new HashMap<>();
        for(int i = 0; i< list.size(); ++i) {
            int first = list.get(i).get(0);
            int second = list.get(i).get(1);
            rootMap.put(first,first);
            rootMap.put(second, second);
        }

        for(int i = 0; i< list.size(); ++i) {
            int first = list.get(i).get(0);
            int second = list.get(i).get(1);
            union(first, second, rootMap);
        }
        Map<Integer, Set<Integer>> resultMap = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry: rootMap.entrySet()) {
            int x = findRoot(rootMap, entry.getKey());
            if(resultMap.get(x)!= null) {
                resultMap.get(x).add(entry.getKey());
            } else {
               Set<Integer> set = new HashSet<>();
               set.add(entry.getKey());
               resultMap.put(x, set);
            }
        }

        for(Map.Entry<Integer, Set<Integer>> entry: resultMap.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for(Integer i: entry.getValue()) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public static void union(int p, int q, Map<Integer, Integer> rootMap) {
        int firstRoot = findRoot(rootMap, p);
        int secondRoot = findRoot(rootMap, q);
        rootMap.put(firstRoot, secondRoot);
    }
    
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l1 = Arrays.asList(1,5);
        List<Integer> l2 = Arrays.asList(7,2);
        List<Integer> l3 = Arrays.asList(3,4);
        List<Integer> l4 = Arrays.asList(4,8);
        List<Integer> l5 = Arrays.asList(6,3);
        List<Integer> l6 = Arrays.asList(5,2);
        List<Integer> l7 = Arrays.asList(1,3);
        List<Integer> l8 = Arrays.asList(9,10);
//        List<Integer> l9 = Arrays.asList(1,10);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        list.add(l7);
        list.add(l8);
//        list.add(l9);
        
//        System.out.println(findCommonPairsUsingGraph(list));
        findConnectedComponentUnion(list);

    }

}
