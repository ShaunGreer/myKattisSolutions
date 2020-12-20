import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double fatCals = 0.0;
        double allOtherCals = 0.0;
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            //End of day
            if (line.equals("-")) {
                if (Double.compare(fatCals, 0.0) == 0 && Double.compare(allOtherCals, 0.0) == 0){
                    scanner.close();
                    return;
                }
                System.out.println(Math.round((fatCals/(fatCals + allOtherCals)) * 100) + "%");
                fatCals = 0.0;
                allOtherCals = 0.0;
                continue;
            }
            //Process item
            String[] eachQuantity = line.split(" ");
            double[] newValues = (calculateCals(eachQuantity));
            fatCals += newValues[0];
            allOtherCals += newValues[1];
        }
    }
    private static double[] calculateCals(String[] values){
        double fatCals = 0.0;
        double allOtherCals = 0.0;
        double totalPercent = 0;
        boolean[] isPercentage = new boolean[5];

        //Fat
        char fatType = values[0].charAt(values[0].length()-1);
        double fatValue = Double.parseDouble(values[0].substring(0, values[0].length()-1));
        double fatCalVal = fatCalorieValue(fatType, fatValue);
        if (Double.compare(fatCalVal, -1) == 0) {
            totalPercent += fatValue;
            isPercentage[0] = true;
        }
        else
            fatCals += fatCalorieValue(fatType, fatValue);

        //Protein
        char proType = values[1].charAt(values[1].length()-1);
        double proValue = Double.parseDouble(values[1].substring(0, values[1].length()-1));
        double proCalVal = otherCalorieValues(proType, proValue);
        if (Double.compare(proCalVal, -1) == 0) {
            totalPercent += proValue;
            isPercentage[1] = true;
        }
        else
            allOtherCals += otherCalorieValues(proType, proValue);

        //Sugar
        char sugType = values[2].charAt(values[2].length()-1);
        double sugValue = Double.parseDouble(values[2].substring(0, values[2].length()-1));
        double sugCalVal = otherCalorieValues(sugType, sugValue);
        if (Double.compare(sugCalVal, -1) == 0) {
            totalPercent += sugValue;
            isPercentage[2] = true;
        }
        else
            allOtherCals += otherCalorieValues(sugType, sugValue);

        //Starch
        char starType = values[3].charAt(values[3].length()-1);
        double starValue = Double.parseDouble(values[3].substring(0, values[3].length()-1));
        double starCalVal = otherCalorieValues(starType, starValue);
        if (Double.compare(starCalVal, -1) == 0) {
            totalPercent += starValue;
            isPercentage[3] = true;
        }
        else
            allOtherCals += otherCalorieValues(starType, starValue);

        //Alcohol
        char alcType = values[4].charAt(values[4].length()-1);
        double alcValue = Double.parseDouble(values[4].substring(0, values[4].length()-1));
        double alcCalVal = alcoholCalorieValue(alcType, alcValue);
        if (Double.compare(alcCalVal, -1) == 0) {
            totalPercent += alcValue;
            isPercentage[4] = true;
        }
        else
            allOtherCals += alcoholCalorieValue(alcType, alcValue);

        double totalCaloriesInItem = (fatCals + allOtherCals) / ((100 - totalPercent) / 100);
        if (isPercentage[0])
            fatCals += (fatValue / 100) * totalCaloriesInItem;
        if (isPercentage[1])
            allOtherCals += (proValue / 100) * totalCaloriesInItem;
        if (isPercentage[2])
            allOtherCals += (sugValue / 100) * totalCaloriesInItem;
        if (isPercentage[3])
            allOtherCals += (starValue / 100) * totalCaloriesInItem;
        if (isPercentage[4])
            allOtherCals += (alcValue / 100) * totalCaloriesInItem;
        return new double[]{fatCals, allOtherCals};
    }

    private static double fatCalorieValue(double fatType, double fatValue){
        if (fatType == 'C')
            return fatValue;
        else if (fatType == 'g')
            return (fatValue * 9);
        else
            return -1;  //Indicating percentage
    }

    private static double alcoholCalorieValue(double alcType, double alcValue){
        if (alcType == 'C')
            return alcValue;
        else if (alcType == 'g')
            return (alcValue * 7);
        else
            return -1;  //Indicating percentage
    }

    private static double otherCalorieValues(double type, double value){
        if (type == 'C')
            return value;
        else if (type == 'g')
            return value * 4;
        else
            return -1;
    }
}