using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PlovdivUniversity_OOP_ASD
{
    class Disciplines
    {
        public void DisciplinesTask()
        {
            Dictionary<string, Student> currentStudentsGrades = new Dictionary<string, Student>();
            HashSet<string> addedNumbers = new HashSet<string>();

            string enterCourses = Console.ReadLine();
            string[] dataCollected;
            while (!enterCourses.Equals("end"))
            {
                dataCollected = enterCourses.Split("=>");
                if(!currentStudentsGrades.ContainsKey(dataCollected[1]) && !addedNumbers.Contains(dataCollected[2]))
                {
                    currentStudentsGrades.Add(dataCollected[1], new Student(dataCollected[1], dataCollected[2]));
                    currentStudentsGrades[dataCollected[1]].AddCourse(dataCollected[0],double.Parse(dataCollected[3]));

                }

                enterCourses = Console.ReadLine();
            }

            currentStudentsGrades = currentStudentsGrades.OrderByDescending(e => e.Value.HighestGrade)
                .ToDictionary(e => e.Key, e => e.Value);
            foreach(var item in currentStudentsGrades)
            {
                Console.WriteLine(item.Key + " " + item.Value.HighestGradeCourse + " " + item.Value.HighestGrade);
            }

        }

    }

    public class Student
    {
        public string Names { get; private set; }
        public string StudentNumber { get; private set; }
        private Dictionary<string, double> currentCourseGrades;
        private string[] highestGrade;
        public double HighestGrade { get; private set; }
        public string HighestGradeCourse { get; private set; }
        
        private bool addedGrade = false;

        public Student(string names,string studentNumber)
        {
            this.Names = names;
            this.currentCourseGrades = new Dictionary<string, double>();
            this.highestGrade = new string[2];
            this.StudentNumber = studentNumber;

        }

        public void AddCourse(string courseName, double gradeOnCourse)
        {
            
           
           
            if (!currentCourseGrades.ContainsKey(courseName))
            {
                currentCourseGrades.Add(courseName, gradeOnCourse);

                if (this.addedGrade == false)
                {
                    this.highestGrade[0] = courseName;
                    this.highestGrade[1] = gradeOnCourse.ToString();
                    addedGrade = true;
                    this.HighestGrade = gradeOnCourse;
                    this.HighestGradeCourse = courseName;
                }
                else
                {
                    if (gradeOnCourse > double.Parse(this.highestGrade[1]))
                    {
                        this.highestGrade[0] = courseName;
                        this.highestGrade[1] = gradeOnCourse.ToString();
                        this.HighestGrade = gradeOnCourse;
                        this.HighestGradeCourse = courseName;
                    }
                }
                
            }
        }

       

    }

}
