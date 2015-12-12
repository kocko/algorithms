package hackerrank.contests.indeedprime;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GretchenAndThePlay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();
        Map<Integer, Integer> actorToScene = new HashMap<>();
        Map<Integer, Integer> sceneToActors = new HashMap<>();
        for (int i = 0; i < m; i++) {
            sceneToActors.put(i, 0);
        }
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = n;
        }
        for (int i = 0; i < n; i++) {
            int scene = sc.nextInt();
            actorToScene.put(i, scene);
            Integer x = sceneToActors.get(scene) + 1;
            sceneToActors.put(scene, x);
            result[x]--;
        }

        for (int i = 0; i < q; i++) {
            int action = sc.nextInt();
            if (action == 1) {
                int ni = sc.nextInt();
                int mi = sc.nextInt();
                Integer currentScene = actorToScene.get(ni);
                Integer a = sceneToActors.get(currentScene) - 1;
                Integer b = sceneToActors.get(mi) + 1;
                result[a + 1]++;
                result[b]--;
                actorToScene.put(ni, mi);
                sceneToActors.put(currentScene, a);
                sceneToActors.put(mi, b);
            } else if (action == 2) {
                int p = sc.nextInt();
                System.out.println(result[p]);
            }
        }
        sc.close();
    }

}
