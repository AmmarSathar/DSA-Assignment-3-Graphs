package coen352.ch11.graph.am;
import coen352.ch4.list.AList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CourseSequenceSolver {
    private Graph courseGraph;
    private final String[] coreCourses;
    public CourseSequenceSolver() {

        coreCourses = new String[]{"MATH204", "COEN212", "COEN231", "COEN243", "COEN244"};
    }
    public CourseSequenceSolver(Graph g) {
        courseGraph = g;
        coreCourses = new String[]{"MATH204", "COEN212", "COEN231", "COEN243", "COEN244"};
    }



    public String[] getPrerequisites(String courseCode) {

        int courseVertex = 0;
        for(int i=0; i<coreCourses.length; i++){

            if(coreCourses[i].equals(courseCode)) courseVertex = i;

        }
        //System.out.println(courseGraph.e());

        Integer[] fanInArray = courseGraph.getFanIn(courseVertex);


        if (fanInArray != null) {
            String[] prerequisites = new String[fanInArray.length];
            for (int i = 0; i < fanInArray.length; i++) {
                int temp = fanInArray[i];
                prerequisites[i] = coreCourses[temp];

            }
            return prerequisites;
        } else {
            return null;
        }
    }

    public String[] getCourseSequence(String courseCode) {
        int courseVertex = -1; // Initialize to an invalid value
        for (int i = 0; i < coreCourses.length; i++) {
            if (coreCourses[i].equals(courseCode)) {
                courseVertex = i;
                break; // No need to continue once the course is found
            }
        }

        if (courseVertex == -1) {
            // Course not found in the list
            return null;
        }

        Integer[] fanInArray = courseGraph.getFanIn(courseVertex);

        if (fanInArray != null) {
            String[] prerequisites = new String[fanInArray.length];
            int prerequisitesIndex = 0;

            for (int i = 0; i < fanInArray.length; i++) {
                int temp = fanInArray[i];
                prerequisites[prerequisitesIndex++] = coreCourses[temp];

                Integer[] fanOfFan = courseGraph.getFanIn(temp);

                if (fanOfFan != null) {
                    String[] prerequisites2 = new String[fanOfFan.length];

                    for (int k = 0; k < fanOfFan.length; k++) {
                        int temp2 = fanOfFan[k];
                        prerequisites2[k] = coreCourses[temp2];
                    }

                    // Combine prerequisites and prerequisites2
                    String[] combinedArray = new String[prerequisites.length + prerequisites2.length];
                    System.arraycopy(prerequisites, 0, combinedArray, 0, prerequisites.length);
                    System.arraycopy(prerequisites2, 0, combinedArray, prerequisites.length, prerequisites2.length);
                    prerequisites = combinedArray;
                }
            }

            return prerequisites;
        } else {
            return null;
        }
    }

    public boolean isPrerequisite(String sourceCourse, String destinationCourse) {
        String[] prerequisites = getCourseSequence(destinationCourse);
        for (String prerequisite : prerequisites) {
            if (prerequisite.equals(sourceCourse)) return true;
        }

        return false;
    }

//    public boolean isCourseSequencePossible(String[] courseSequence) {
//        int courseVertex = 0;
//        for(int i=0; i<coreCourses.length; i++){
//            for(int k=0; k< courseSequence.length; k++){
//                if(courseSequence[k].equals(coreCourses[i] ) && i>courseVertex){
//                    courseVertex = i;
//                    break;
//                }
//            }
//        }
//
//        String[] prerequisites = getCourseSequence(coreCourses[courseVertex]);
//
//        for(int i=0; i<courseSequence.length; i++){
//            for(int k=0; k< prerequisites.length; k++){
//                if(!courseSequence[k].equals(prerequisites[i])){
//                    courseVertex = i;
//                    break;
//                }
//            }
//        }
//
//        return false;
//    }
}
