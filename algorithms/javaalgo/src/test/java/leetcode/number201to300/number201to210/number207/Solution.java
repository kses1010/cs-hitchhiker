package leetcode.number201to300.number201to210.number207;

import java.util.ArrayList;
import java.util.List;

class Course {

    boolean visited;
    boolean traced;
    List<Course> pre = new ArrayList<>();

    public void add(Course course) {
        pre.add(course);
    }
}

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course();
        }
        for (int[] prerequisite : prerequisites) {
            courses[prerequisite[0]].add(courses[prerequisite[1]]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(Course course) {
        if (course.traced) {
            return false;
        }
        if (course.visited) {
            return true;
        }
        course.visited = true;

        for (Course c : course.pre) {
            if (isCyclic(c)) {
                return true;
            }
        }
        course.traced = true;
        return false;
    }
}
