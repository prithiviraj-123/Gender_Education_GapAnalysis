//GenderEducation Gap ANalysis//

import java.util.Scanner;

public class GenderEducationGapSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ----- Step 1: Dataset -----
        String[] region = {"North", "South", "East", "West", "Central"};
        int[] boysEnroll = {270, 300, 250, 280, 260};
        int[] girlsEnroll = {230, 280, 240, 260, 250};
        int[] boysScore = {76, 78, 72, 75, 74};
        int[] girlsScore = {81, 83, 79, 80, 82};

        while (true) {
            System.out.println("\n===== Gender Education Gap Analysis (SDG 10) =====");
            System.out.println("1. View All Data");
            System.out.println("2. Analyze Specific Region");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\nRegion\tBoysEnroll\tGirlsEnroll\tBoysScore\tGirlsScore");
                System.out.println("---------------------------------------------------------");
                for (int i = 0; i < region.length; i++) {
                    System.out.println(region[i] + "\t" + boysEnroll[i] + "\t\t" + girlsEnroll[i] + "\t\t" + boysScore[i] + "\t\t" + girlsScore[i]);
                }
            } 
            else if (choice == 2) {
                System.out.print("Enter region name: ");
                String r = sc.next();
                boolean found = false;
                for (int i = 0; i < region.length; i++) {
                    if (r.equalsIgnoreCase(region[i])) {
                        found = true;
                        System.out.println("\nRegion: " + region[i]);
                        int enrollGap = boysEnroll[i] - girlsEnroll[i];
                        int scoreGap = girlsScore[i] - boysScore[i];

                        System.out.println("Boys Enrollment: " + boysEnroll[i]);
                        System.out.println("Girls Enrollment: " + girlsEnroll[i]);
                        System.out.println("Enrollment Gap (Boys - Girls): " + enrollGap);
                        System.out.println("Boys Avg Score: " + boysScore[i]);
                        System.out.println("Girls Avg Score: " + girlsScore[i]);
                        System.out.println("Average Score Gap (Girls - Boys): " + scoreGap);

                        if (enrollGap > 0)
                            System.out.println("⚠ More boys enrolled than girls.");
                        else
                            System.out.println("✅ Girls enrollment is equal or higher.");

                        if (scoreGap > 0)
                            System.out.println("🌸 Girls performed better on average.");
                        else
                            System.out.println("📘 Boys performed better on average.");
                        break;
                    }
                }
                if (!found) System.out.println("❌ Region not found.");
            } 
            else if (choice == 3) {
                System.out.println("Exiting... Thank you!");
                break;
            } 
            else {
                System.out.println("Invalid choice. Try again!");
            }
        }
        sc.close();
    }

}
