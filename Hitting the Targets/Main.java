import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();  //Number of targets
        List<int[]> targets = new ArrayList<>(m);
        for (int i = 0; i < m; i++){
            String shape = scanner.next();
            int[] points;
            if (shape.equals("rectangle")){
                points = new int[4];
                for (int j = 0; j < 4; j++) {
                    int point = scanner.nextInt();
                    points[j] = point;
                }
            } else {
                points = new int[3];
                for (int j = 0; j < 3; j++){
                    int point = scanner.nextInt();
                    points[j] = point;
                }
            }
            targets.add(points);
        }

        List<Point> allPointsInside = new ArrayList<>();
        for (int i = 0; i < targets.size(); i++){
            int[] temp = targets.get(i);
            if (temp.length == 4){  //It's a rectangle
                int y1 = temp[1];
                int x2 = temp[2];
                int y2 = temp[3];

                while(y1 <= y2) {
                    int x1 = temp[0];
                    while (x1 <= x2) {
                        allPointsInside.add(new Point(x1, y1));
                        x1++;
                    }
                    y1++;
                }
            }
        }

        int n = scanner.nextInt();  //Number of shots
        for (int i = 0; i < n; i++) {
            int hitCount = 0;
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int k = 0; k < targets.size(); k++){
                int[] temp = targets.get(k);
                if (temp.length == 3){  //It's a circle
                    int centreX = temp[0];
                    int centreY = temp[1];
                    int radiusSqaured = temp[2] * temp[2];

                    int differenceXsquared = (x - centreX) * (x - centreX);
                    int differenceYsquared = (y - centreY) * (y - centreY);
                    if (differenceXsquared + differenceYsquared <= radiusSqaured)
                        hitCount++;
                }
            }

            for (int j = 0; j < allPointsInside.size(); j++){
                int xx = allPointsInside.get(j).getX();
                int yy = allPointsInside.get(j).getY();
                if (xx == x && yy == y)
                    hitCount++;
            }
            System.out.println(hitCount);
        }

        scanner.close();
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
    }
}
