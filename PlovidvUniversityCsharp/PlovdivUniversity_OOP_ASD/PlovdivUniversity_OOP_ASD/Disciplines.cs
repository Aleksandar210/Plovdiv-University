using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PlovdivUniversity_OOP_ASD
{
    class Disciplines
    {
        public void DisciplinesTask()
        {
            Dictionary<string, HashSet<string>> currentGradesAdded = new Dictionary<string, HashSet<string>>();
            Dictionary<string, Dictionary<string, Dictionary<string, double>>> currentDisciplines = new Dictionary<string, Dictionary<string, Dictionary<string, double>>>();
            string enterDisciplineData = Console.ReadLine();
            string[] currentData;
            while (!enterDisciplineData.Equals("end", StringComparison.OrdinalIgnoreCase))
            {
                currentData = enterDisciplineData.Split("=>");

                if (currentGradesAdded[currentData[0]].Contains(currentData[2]))
                {

                }
                else
                {

                    if (currentDisciplines.ContainsKey(currentData[0]))
                    {

                        if (currentDisciplines[currentData[0]].ContainsKey(currentData[1]))
                        {

                        }
                        else
                        {
                            currentDisciplines[currentData[0]].Add(currentData[1], new Dictionary<string, double>());
                            currentDisciplines[currentData[0]][currentData[1]].Add(currentData[2], double.Parse(currentData[3]));
                            currentGradesAdded[currentData[0]].Add(currentData[2]);
                        }
                    }
                    else
                    {
                        currentDisciplines.Add(currentData[0], new Dictionary<string, Dictionary<string, double>>());
                        currentDisciplines[currentData[0]].Add(currentData[1], new Dictionary<string, double>());
                        currentDisciplines[currentData[0]][currentData[1]].Add(currentData[2], double.Parse(currentData[3]));
                        currentGradesAdded.Add(currentData[0], new HashSet<string>());
                        currentGradesAdded[currentData[0]].Add(currentData[2]);
                    }

                }
                enterDisciplineData = Console.ReadLine();
            }
           
            foreach(var item in currentDisciplines)
            {
                Console.WriteLine();
            }
        }
    }
}
