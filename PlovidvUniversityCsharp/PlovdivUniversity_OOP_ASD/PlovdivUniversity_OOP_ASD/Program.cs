using System;
using System.ComponentModel.Design;
using System.Linq;

namespace PlovdivUniversity_OOP_ASD
{
    class Program
    {
        static void Main()
        {

            // CarRaceTask currentTasks = new CarRaceTask();
            //currentTasks.CarRace();
            //--------------------------------------



            //Task2
            // Disciplines disciplineTask = new Disciplines();
            // disciplineTask.DisciplinesTask();
            //


            string enterNumbers = Console.ReadLine();
            int[] numbers = enterNumbers.Split().Select(e => int.Parse(e)).ToArray();
            int[] numbersFull = new int[5];

            FillArray(numbers, numbersFull);
            foreach(var item in numbersFull)
            {
                Console.WriteLine(item);
            }

        }

         static void FillArray(int[] array1,int[] neededArray)
        {
            Array.Copy(array1, 0, neededArray, 0, array1.Length);
            int neededData = neededArray.Length - array1.Length;
            Random rand = new Random();
            for(int i = array1.Length; i <= neededData+1; i++)
            {
                neededArray[i] = rand.Next(10, 100);
            }
        }
    }
}
