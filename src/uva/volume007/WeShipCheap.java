package uva.volume007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeShipCheap {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        boolean newLine = false;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            HashMap<String, ArrayList<String>> adjList = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String n1 = st.nextToken();
                String n2 = st.nextToken();

                if (!adjList.containsKey(n1)) adjList.put(n1, new ArrayList<>());
                if (!adjList.containsKey(n2)) adjList.put(n2, new ArrayList<>());

                adjList.get(n1).add(n2);
                adjList.get(n2).add(n1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<String, String> prevNode = new HashMap<>();
            String src = st.nextToken();
            String dest = st.nextToken();

            Queue<String> queue = new ArrayDeque<>();
            prevNode.put(src, null);
            queue.offer(src);

            while (!queue.isEmpty()) {
                String curr = queue.poll();
                if (curr.equals(dest)) break;
                else if (adjList.containsKey(curr)) {
                    for (String neighbour : adjList.get(curr))
                        if (!prevNode.containsKey(neighbour)) {
                            queue.offer(neighbour);
                            prevNode.put(neighbour, curr);
                        }
                }
            }

            if (!newLine) newLine = true;
            else System.out.println();

            if (!prevNode.containsKey(dest)) System.out.println("No route");
            else {
                ArrayList<String> list = new ArrayList<>();
                while (dest != null) {
                    list.add(0, dest);
                    dest = prevNode.getOrDefault(dest, null);
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i));
                    sb.append(" ");
                    sb.append(list.get(i + 1));
                    sb.append("\n");
                }
                System.out.print(sb.toString());
            }

            br.readLine();
        }
    }

}