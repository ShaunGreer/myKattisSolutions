import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Reading input
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        String[] carpark = new String[rows];
        for (int i = 0; i < rows; i++) {
            carpark[i] = scanner.next();
        }

        for (int k = 0; k < 5; k++) {   //Loop 5 times for output
            int rowsIndex = 0;
            int result = 0;
            for (int i = 0; i < rows - 1; i++) {  //Each row
                int columnsIndex = 0;
                for (int j = 0; j < columns - 1; j++) {   //Each column in that row
                    int xCount = 0;
                    //No cars squashed
                    if (k == 0) {
                        if (noBuildings(carpark, rowsIndex, columnsIndex)) {
                            xCount = countCars(carpark, rowsIndex, columnsIndex);
                            if (xCount == 0)
                                result++;
                        }
                    } //1 car squashed
                    else if (k == 1){
                        if (noBuildings(carpark, rowsIndex, columnsIndex)){
                            xCount = countCars(carpark, rowsIndex, columnsIndex);
                            if (xCount == 1)
                                result++;
                        }
                    } //2 cars squashed
                    else if (k == 2){
                        if (noBuildings(carpark, rowsIndex, columnsIndex)){
                            xCount = countCars(carpark, rowsIndex, columnsIndex);
                            if (xCount == 2)
                                result++;
                        }
                    } //3 cars squashed
                    else if (k == 3){
                        if (noBuildings(carpark, rowsIndex, columnsIndex)){
                            xCount = countCars(carpark, rowsIndex, columnsIndex);
                            if (xCount == 3)
                                result++;
                        }
                    } //4 cars squashed
                    else if (k == 4){
                        if (noBuildings(carpark, rowsIndex, columnsIndex)){
                            xCount = countCars(carpark, rowsIndex, columnsIndex);
                            if (xCount == 4)
                                result++;
                        }
                    }
                    columnsIndex++;
                }
                rowsIndex++;
            }
            System.out.println(result);
        }

        scanner.close();
    }

    private static int countCars(String[] carpark, int rowIndex, int columnIndex){
        int xCount = 0;
        if (carpark[rowIndex].charAt(columnIndex) == 'X')
            xCount++;
        if (carpark[rowIndex].charAt(columnIndex + 1) == 'X')
            xCount++;
        if (carpark[rowIndex + 1].charAt(columnIndex) == 'X')
            xCount++;
        if (carpark[rowIndex + 1].charAt(columnIndex +1) == 'X')
            xCount++;
        return xCount;
    }

    private static boolean noBuildings(String[] carpark, int rowIndex, int columnIndex){
        if (carpark[rowIndex].charAt(columnIndex) != '#'
        && carpark[rowIndex].charAt(columnIndex + 1) != '#'
        && carpark[rowIndex + 1].charAt(columnIndex) != '#'
        && carpark[rowIndex + 1].charAt(columnIndex +1) != '#')
            return true;
        return false;
    }
}